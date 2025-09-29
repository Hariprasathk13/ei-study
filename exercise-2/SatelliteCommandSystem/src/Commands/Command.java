package Commands;

import Models.Satellite;

// common interface for all commands
public interface Command {
    void execute(Satellite satellite);
}
