package CommandsManager;

import DataClasses.MusicBand;

public abstract class Command {

    public Command() {}

    public abstract void execute();

    public abstract void execute(String value1);

    public abstract void execute(String value1, MusicBand value2);

    public abstract void execute(MusicBand value1);

    public abstract String commandInfo();
}
