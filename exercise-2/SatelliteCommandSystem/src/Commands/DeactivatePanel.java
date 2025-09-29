package Commands;

import Models.Satellite;

// To deactivate panel
public class DeactivatePanel implements Command {
    
    @Override
    public void execute(Satellite satellite) {
        satellite.deactivatePanel();;
    }

}
