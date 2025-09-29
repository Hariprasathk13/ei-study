package Commands;

import Models.Orientation;
import Models.Satellite;

// generic command to rotate(x) in x direction
public class RotateCommand implements Command {

    final private Orientation orientation;

    public RotateCommand(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void execute(Satellite satellite) {
        satellite.rotate(orientation);
    }

}
