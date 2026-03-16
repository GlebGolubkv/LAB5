package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import Data.KeyGenerator;
import DataClasses.MusicBand;
import TermenalManager.BandsInputManager;
import TermenalManager.Colors;

import java.util.Scanner;

public class Insert extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }

    @Override
    public void execute(String value1) {
        int key = keyChek(value1);
        Scanner scanner = new Scanner(System.in);
        MusicBand musicBand = BandsInputManager.getInstance().InputBand(scanner);
        ClassesManager.getInstance().addMusicBandToCollection(key, musicBand);


    }

    @Override
    public void execute(String value1, MusicBand musicBand){
        int key = keyChek(value1);
        ClassesManager.getInstance().addMusicBandToCollection(key, musicBand);

    }

    @Override
    public void execute(MusicBand value1) {

    }

    @Override
    public String commandInfo() {
        return "добавить новый элемент с заданным ключом";
    }


    private int keyChek(String key) {
        int newKey;


        try {
            newKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            int newGenerateKey = new KeyGenerator().generateNewKey();
            System.out.println("This key is unavailable. New Key created automatically. Key: " + newGenerateKey);
            return newGenerateKey;
        }

        //если уже есть в массиве
        if (!ClassesManager.getInstance().GetMap().containsKey(newKey)) {
            return newKey;
        } else {
            int newGenerateKey = new KeyGenerator().generateNewKey();
            System.out.println("This key is already in Map. New Key created automatically. Key: " + newGenerateKey);
            return newGenerateKey;
        }
    }
}
