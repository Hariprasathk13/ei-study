package Commands;


import Models.Satellite;

// command to active panel
public class ActivatePanel implements Command {


  

    @Override
    public void execute(Satellite satellite) {
        satellite.activatePanel();
    }

}
