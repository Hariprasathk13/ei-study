package States;

import Exceptions.PanelNotActiveException;
import Models.Satellite;

// State Pattern : panelState(Active,Inactive)
public interface PanelState {

    String getStateName(); // each state has unique name

    void activatePanels(Satellite satellite);

    void deactivatePanels(Satellite satellite);

    void collectData(Satellite satellite) throws PanelNotActiveException;

}
