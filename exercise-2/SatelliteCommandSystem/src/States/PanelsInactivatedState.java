package States;

import java.util.logging.Level;

import Exceptions.PanelNotActiveException;
import Models.Satellite;
import utils.MyLogger;

//  inactive state 
public class PanelsInactivatedState implements PanelState {

    final private String stateName = "INACTIVE";

    @Override
    public void activatePanels(Satellite satellite) {
        satellite.setPannelState(new PanelsActivatedState());
        MyLogger.log(Level.INFO, "Panels are activated");

    }

    @Override
    public void deactivatePanels(Satellite satellite) {
        MyLogger.log(Level.INFO, "Panels are already deactivated");
    }

    @Override
    public void collectData(Satellite satellite) throws PanelNotActiveException {
        throw new PanelNotActiveException("Cannot collect data. Solar panels are inactive ");
    }

    @Override
    public String getStateName() {
        return stateName;
    }

}
