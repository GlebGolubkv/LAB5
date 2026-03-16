package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.BandsInputManager;
import TermenalManager.Colors;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_lower extends Command {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        ClassesManager classesManager = ClassesManager.getInstance();
        MusicBand InputMusicBand = BandsInputManager.getInstance().InputBand(scanner);
        ArrayList<String> RemoveKeys = new ArrayList<>();

        for (int key : classesManager.GetMap().keySet()) {
            if (InputMusicBand.compareTo(classesManager.GetMap().get(key)) > 0) {

                RemoveKeys.add(String.valueOf(key));

            }
        }


        for (String key : RemoveKeys) {
            new Remove_key().execute(key);
        }


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

        ClassesManager classesManager = ClassesManager.getInstance();
        ArrayList<String> RemoveKeys = new ArrayList<>();

        for (int key : classesManager.GetMap().keySet()) {
            if (value1.compareTo(classesManager.GetMap().get(key)) > 0) {

                RemoveKeys.add(String.valueOf(key));

            }

        }
    }

    @Override
    public String commandInfo() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
