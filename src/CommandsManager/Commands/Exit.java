package CommandsManager.Commands;

import CommandsManager.Command;
import DataClasses.MusicBand;
import TermenalManager.Colors;


public class Exit extends Command {
    @Override
    public void execute() {
        System.out.println(Colors.GREEN + "Exit Program" + Colors.RESET);
        System.exit(0);
    }

    @Override
    public void execute(String value1) {

        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }

    @Override
    public void execute(String value1, MusicBand value2) {

    }

    @Override
    public void execute(MusicBand value1) {

    }

    @Override
    public String commandInfo() {
        return "завершить программу";
    }
}
