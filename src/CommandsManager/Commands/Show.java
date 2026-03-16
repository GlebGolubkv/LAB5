package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Show extends Command {
    @Override
    public void execute() {

        System.out.println();
        System.out.println(ClassesManager.getInstance());
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
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
