package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

import java.util.Hashtable;

public class Filter_less_than_label extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }


    @Override
    public void execute(String value1) {
        int label = CheckInteger(value1);
        int count = 0;
        ClassesManager classesManager = ClassesManager.getInstance();
        Hashtable<Integer, MusicBand> Map = classesManager.GetMap();

        for (int key : Map.keySet()) {
            if (label > Map.get(key).getLabel().getBands()) {
                count++;
            }
        }

        System.out.println();
        System.out.println("The number of elements less than " + Colors.GREEN + label + Colors.RESET + " is " + Colors.GREEN + count + Colors.RESET);
        System.out.println();

    }

    @Override
    public void execute(String value1, MusicBand value2) {

    }

    @Override
    public void execute(MusicBand value1) {

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

    @Override
    public String commandInfo() {
        return "вывести элементы, значение поля label которых меньше заданного";
    }
}
