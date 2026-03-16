package CommandsManager.Commands;


import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Clear extends Command {
    @Override
    public void execute() {
        ClassesManager.getInstance().ClearCollection();
        System.out.println();
        System.out.println(Colors.GREEN + "Collection cleared" + Colors.RESET);
        System.out.println();

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
        return "очистить коллекцию";
    }
}
