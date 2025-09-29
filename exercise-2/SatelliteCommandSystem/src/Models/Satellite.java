package Models;

import java.util.logging.Level;

import Exceptions.PanelNotActiveException;
import States.PanelsInactivatedState;
import utils.MyLogger;
import States.PanelState;

//satellite model
public class Satellite {
    private Orientation orientation;
    private PanelState panelState;
    private int dataCollected;

    public Satellite() {
        // setting up its initial state
        this.orientation = Orientation.North;
        panelState = new PanelsInactivatedState();
        this.dataCollected = 0;
    }

    public void   rotate(Orientation orientation) {
        this.orientation = orientation;
        MyLogger.log(Level.INFO, "Satellite rotated to "+orientation);
    }

    public void setPannelState(PanelState panelState) {
        this.panelState = panelState;
    }

    public void activatePanel() {
        panelState.activatePanels(this);
    }

    public void deactivatePanel() {
        panelState.deactivatePanels(this);
    }

    public void collectData() throws PanelNotActiveException {
        panelState.collectData(this);
    }

    public void setDataCollected(int dataCollected) {
        this.dataCollected = dataCollected;
    }

    public int getDataCollected() {
        return dataCollected;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public PanelState getPanelState() {
        return panelState;
    }

}
