package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Save extends Command {
    @Override
    public void execute() {
        ClassesManager classesManager = ClassesManager.getInstance();
        classesManager.SaveCollectionToFile();

        System.out.println();
        System.out.println(Colors.GREEN + "The collection has been saved" + Colors.RESET);
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
        return "сохранить коллекцию в файл";
    }
}
