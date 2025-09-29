package Factory;

import java.util.Map;
import java.util.HashMap;

import Commands.Command;

//simple Factory to add new commands with their keyword
public class CommandFactory {
    private static Map<String, Command> commands = new HashMap<>();

    public static void register(String key, Command command) {
        commands.put(key, command);
    }

    // returns null if unknown command
    public static Command getCommand(String key) {
        return commands.getOrDefault(key, null);
    }
}
