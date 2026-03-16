package FileManager.CommandsParser;

import Data.DataCommands;

import DataClasses.MusicBand;
import TermenalManager.BandsFileReader;

import TermenalManager.Colors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Класс, с помощью которого можно производить чтение команд и их запуск
 * <p>
 * Команды будут читаться построчно. Каждая строка должна содержать одну команду + входные данные для команды при необходимости.
 * </p>
 */
public class CommandsReader {

    private static CommandsReader instance;
    private static final ArrayList<String> filesNames = new ArrayList<>();


    private CommandsReader() {

    }

    public static void initialize() {

        if (instance == null) {
            instance = new CommandsReader();
        } else {
            throw new IllegalStateException("CommandsReader has already been initialized");
        }
    }

    public static CommandsReader getInstance() {
        if (instance == null) {
            throw new IllegalStateException("CommandsReader has not been initialized");
        }
        return instance;
    }

    /**
     * Метод читает и запускает команды из файла
     *
     * @param fileName
     */
    public void readCommands(String fileName) {


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.trim()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                if (!checkRecursion(line)) {

                    try {
                        // Возвращает null, если в строке команда, которой не нужен musicBand. Возвращает musicBand, если его ввод прошел без ошибок.
                        // Выкидывает ошибку, если что-то пошло не так
                        MusicBand musicBand = checkIfBandsInput(bufferedReader, line);

                        if (musicBand != null) {
                            DataCommands.getInstance().createCommandByName(line, musicBand);
                        } else {
                            DataCommands.getInstance().createCommandByName(line);
                        }
                        System.out.println("Command " + line + " processed");

                    } catch (Exception _) {
                        System.out.println(Colors.RED + "Error reading MusicBand from file." + Colors.RESET);
                        System.out.println("Command " + line + " processed");

                    }


                }

            }

        } catch (IOException e) {
            System.out.println();
            System.out.println(Colors.RED + "There is no file with this name." + Colors.RESET);


        }
    }

    private boolean checkRecursion(String line) {

        String[] command = line.toLowerCase().split("\\s+");

        if (Objects.equals(command[0], "execute_script")) {
            if (filesNames.contains(command[1])) {
                System.out.println(Colors.RED + "A recursion was detected. Executing the file " + Colors.GREEN + command[1] + Colors.RED + " will cause the program to loop. " + Colors.RESET);
                return true;
            } else {
                filesNames.add(command[1]);
            }
        }
        return false;
    }

    public void resetCommand() {
        filesNames.clear();
    }

    private MusicBand checkIfBandsInput(BufferedReader reader, String line) {
        String[] command = line.toLowerCase().split("\\s+");

        if (Objects.equals(command[0], "remove_lower") & command.length == 1) {
            try {
                MusicBand musicBand = BandsFileReader.getInstance().InputBand(reader);
                return musicBand;
            } catch (Exception e) {
                throw new IllegalArgumentException("Error reading MusicBand from file.");

            }

        } else if (Objects.equals(command[0], "update") & command.length == 2) {
            try {
                MusicBand musicBand = BandsFileReader.getInstance().InputBand(Integer.parseInt(command[1]), reader);
                return musicBand;
            } catch (Exception e) {
                throw new IllegalArgumentException("Error reading MusicBand from file.");

            }


        } else if ((Objects.equals(command[0], "insert") || Objects.equals(command[0], "replace_if_greater") || Objects.equals(command[0], "replace_if_lower")) & command.length == 2) {

            try {
                MusicBand musicBand = BandsFileReader.getInstance().InputBand(reader);
                return musicBand;
            } catch (Exception e) {
                throw new IllegalArgumentException("Error reading MusicBand from file.");

            }
        } else return null;
        // Проверять если неправильный ввод, то обрабатывать
        // сделать обработку ошибок. Получаем null если в ходе считывания обьекта произошла ошибка и если команда не использует элемент
    }

    //

}