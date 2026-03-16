package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.BandsInputManager;
import TermenalManager.Colors;

import java.util.Scanner;

public class Replace_if_greater extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }

    @Override
    public void execute(String value1) {
        int key = CheckInteger(value1);
        Scanner scanner = new Scanner(System.in);
        ClassesManager cm = ClassesManager.getInstance();
        MusicBand OldMusicBand = cm.GetMap().get(key);
        MusicBand NewMusicBand = BandsInputManager.getInstance().InputBand(scanner);
        if (NewMusicBand.compareTo(OldMusicBand) > 0) {
            cm.GetMap().put(key, NewMusicBand);
            System.out.println();
            System.out.println("Key " + Colors.GREEN + key + Colors.RESET + " replaced");
            System.out.println();
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
        return "заменить значение по ключу, если новое значение больше старого";
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
