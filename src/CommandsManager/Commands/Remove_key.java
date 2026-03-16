package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;

import DataClasses.MusicBand;
import TermenalManager.Colors;


public class Remove_key extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();

    }

    @Override
    public void execute(String value1) {
        int key = CheckInteger(value1);
        ClassesManager cm = ClassesManager.getInstance();
        if (cm.keyInMap(key)) {
            cm.removeMusicBandFromCollection(key);
            System.out.println();
            System.out.println("Key " + Colors.GREEN + key + Colors.RESET + " removed");
            System.out.println();
        } else {
            System.out.println();
            System.out.println(Colors.RED + "Invalid key. Key: " + key + Colors.RESET);

        }


    }

    @Override
    public void execute(String value1, MusicBand value2) {

    }

    @Override
    public void execute(MusicBand value1) {

    }

    @Override
    public String commandInfo() {
        return "удалить элемент из коллекции по его ключу";
    }

    private int CheckInteger(String key) {
        int newKey;

        try {
            newKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Must be an integer");
        }
        return newKey;
    }
}
