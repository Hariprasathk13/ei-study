
import java.util.Scanner;

import Models.Orientation;
import Models.Satellite;
import utils.MyLogger;
import utils.SatelliteController;

import java.util.logging.Level;

import Commands.ActivatePanel;
import Commands.CollectData;
import Commands.Command;
import Commands.DeactivatePanel;
import Commands.RotateCommand;
import Factory.CommandFactory;

/* java version: java 17.0.11 2024-04-16 LTS

 * This satellite command system uses the command pattern to handle various commands
 * commandregistry - central register to configure commands
 * Satellite  -  Receiver
 * SatelliteController - invoker
 * SatelliteCommandSystem -client
 * 
 * 
 * uses state pattern to handle panel state and data collection
 * Im assuming rotation is independent of panelstate
 * 
 */

// main class 
public class SatelliteCommandSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Satellite satellite = new Satellite();
        SatelliteController controller = new SatelliteController(satellite);

        // registering commands in factory
        // easy to add new commands
        CommandFactory.register("rotate(South)", new RotateCommand(Orientation.South));
        CommandFactory.register("rotate(North)", new RotateCommand(Orientation.North));
        CommandFactory.register("rotate(East)", new RotateCommand(Orientation.East));
        CommandFactory.register("rotate(West)", new RotateCommand(Orientation.West));

        CommandFactory.register("activatePanels()", new ActivatePanel());
        CommandFactory.register("deactivatePanels()", new DeactivatePanel());
        CommandFactory.register("collectData()", new CollectData());

        // menu
        System.out.println("welcome to satellite command system!");
        System.out.println(
                """
                        Enter a series of commands separated by spaces.
                            Available commands:
                                1. rotate('Direction') -> Direction can be North, South, East, West
                                2. activatePanels()      -> Activate  the satellite's solar panels
                                3. deactivatePanels()    -> Deactivate the solar panels
                                4. collectData()        -> Collect data  (needs panels as active)
                                5. exit()                -> to exit the system
                                Example:
                                    rotate(East) activatePanels() collectData()\n """);

        while (!exit) {

            System.out.print(">>");

            String input = scanner.nextLine().trim(); // accept series of commands

            String[] commands = input.split(" ");

            for (String usercommand : commands) {

                String strcmd = usercommand.trim();

                if (strcmd.equals("exit()")) {
                    exit = true; // break the loop
                    MyLogger.log(Level.INFO, "Exiting system");
                    scanner.close();
                } else {
                    Command command = CommandFactory.getCommand(strcmd); // converting to string command to
                                                                         // Command objects
                    if (command != null) {
                        try {
                            controller.doOperation(command);

                        } catch (Exception e) {

                            MyLogger.log(Level.SEVERE, "Error while executing command :" + strcmd);

                        }
                    } else {

                        MyLogger.log(Level.SEVERE, "Invalid command " + strcmd);

                    }

                }

            }
            controller.showstatus(); // display satillite status after every command

        }

    }

}
