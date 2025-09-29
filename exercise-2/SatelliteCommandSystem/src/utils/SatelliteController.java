package utils;

import Commands.Command;
import Models.Satellite;

// controller for satellite
public class SatelliteController {

    final private Satellite satellite;

    public SatelliteController(Satellite satellite) {
        this.satellite = satellite;
    }

    public void showstatus() {
        System.out.println("\nSatellite current status:");
        System.out.println("----------------------------");
        System.out.println("Orientation: " + satellite.getOrientation());
        System.out.println("Solar Panels: " + satellite.getPanelState().getStateName());
        System.out.println("Data Collected: " + satellite.getDataCollected());
        System.out.println();

    }

    public void doOperation(Command command) {
        command.execute(satellite);

    }

}
