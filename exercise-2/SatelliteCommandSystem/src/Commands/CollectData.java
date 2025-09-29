package Commands;

import java.util.logging.Level;

import Exceptions.PanelNotActiveException;
import Models.Satellite;
import utils.MyLogger;

// to collect data from satellite
public class CollectData implements Command {

    @Override
    public void execute(Satellite satellite) {
        try {
            satellite.collectData();
            MyLogger.log(Level.INFO, "Data collected");

        } catch (PanelNotActiveException e) {
            MyLogger.log(Level.SEVERE, e.getMessage().toString());

        }

    }

}
