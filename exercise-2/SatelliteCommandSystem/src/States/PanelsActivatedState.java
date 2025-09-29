package States;

import java.util.logging.Level;

import Exceptions.PanelNotActiveException;
import Models.Satellite;
import utils.MyLogger;



// activated state
public class PanelsActivatedState implements PanelState {
    final private String stateName = "ACTIVE";

    @Override
    public void activatePanels(Satellite satellite) {
        MyLogger.log(Level.INFO, "Panels are already active");
    }

    @Override
    public void deactivatePanels(Satellite satellite) {
        satellite.setPannelState(new PanelsInactivatedState());
        MyLogger.log(Level.INFO, "Panels are deactivated");
    }

    @Override
    public void collectData(Satellite satellite) throws PanelNotActiveException {
        satellite.setDataCollected(satellite.getDataCollected() + 10);
    }

  

    @Override
    public String getStateName() {
        return stateName;
    }

}
