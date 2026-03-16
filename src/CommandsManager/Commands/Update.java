package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.BandsInputManager;
import TermenalManager.Colors;

import java.util.Hashtable;
import java.util.Scanner;

public class Update extends Command {


    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }

    @Override
    public void execute(String value1) {
        Scanner scanner = new Scanner(System.in);

        int key = RemoveBandByID(CheckInteger(value1));
        ClassesManager.getInstance().GetMap().put(key, BandsInputManager.getInstance().InputBand(CheckInteger(value1), scanner));

    }

    @Override
    public void execute(String value1, MusicBand value2) {

        int key = RemoveBandByID(CheckInteger(value1));
        ClassesManager.getInstance().GetMap().put(key, value2);

    }

    @Override
    public void execute(MusicBand value1) {

    }

    @Override
    public String commandInfo() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }


    public int RemoveBandByID(int ID) {
        Hashtable<Integer, MusicBand> Map = ClassesManager.getInstance().GetMap();

        for (int key : Map.keySet()) {
            if (ID == Map.get(key).getId()) {
                System.out.println("The object that you are replacing");
                System.out.println(Map.get(key));
                Map.remove(key);
                return key;
            }
        }
        throw new IllegalArgumentException("There is no object with this ID. ID: " + ID);
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
