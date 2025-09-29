import java.util.ArrayList;
import java.util.List;


/**
 * CommandPatternDemo
 * A simple project to demonstate command pattern
 *
 * - Command objects represent actions (Insert, Delete).
 * - The TodoApp acts as the receiver that actually performs the task
 * operations.
 * - The client creates commands and executes them via the app.
 * 
 * 
 */

// Command interface
interface Command {
    void execute(TodoApp app); // method to execute on call

}

// Concrete Command: Insert a new task
class InsertCommand implements Command {

    String task;

    public InsertCommand(String task) {
        this.task = task;
    }

    @Override
    public void execute(TodoApp app) {
        app.addTask(task);
    }

}

// Concrete Command: Delete a Existing task
class DeleteCommand implements Command {

    String task;

    public DeleteCommand(String task) {
        this.task = task;
    }

    @Override
    public void execute(TodoApp app) {
        app.removeTask(task);

    }

}

class TodoApp {
    List<String> tasks;

    public TodoApp() {
        this.tasks = new ArrayList<>();

    }

    // adding a new task
    public void addTask(String task) {
        tasks.add(task);
    }

    // deleting a existing task
    public void removeTask(String task) {
        try {
            tasks.remove(task);
        } catch (Exception e) {
            System.out.println("Task not found");
        }

    }

    void doOperation(Command command) {
        command.execute(this);
    }

    // printing current tasks in list
    public void showtasks() {
        System.out.println("current tasks:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }

}

// client
public class CommandPatternDemo {

    public static void main(String[] args) {
        // creating main app
        TodoApp todoApp = new TodoApp();

        // creating commands
        Command insert1 = new InsertCommand("task1");
        Command insert2 = new InsertCommand("task2");

        todoApp.doOperation(insert1);
        todoApp.doOperation(insert2);
        todoApp.showtasks();

        // deletion of tasks
        Command delete1 = new DeleteCommand("task1");
        todoApp.doOperation(delete1);

        // show all tasks
        todoApp.showtasks();

    }
}