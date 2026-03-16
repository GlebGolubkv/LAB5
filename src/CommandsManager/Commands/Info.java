package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Info extends Command {
    @Override
    public void execute() {

        ClassesManager cm = ClassesManager.getInstance();
        System.out.println();
        System.out.println(cm.GetCollectionType());
        System.out.println(cm.GetCreationDate());
        System.out.println(Colors.GREEN + "Map size: " + Colors.RESET + cm.MapSize());
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
        return "вывести в стандартный поток вывода информацию о коллекции";
    }
}
