package Data;

import CommandsManager.Command;

import CommandsManager.Commands.*;
import DataClasses.MusicBand;
import TermenalManager.Colors;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс, который запускает команды
 * <p>
 *     Получает на вход команды, далее обращаясь к билдерам, которые создают команды
 * </p>
 */
public class DataCommands {

    // список всех команд, поиск по команде
    private static final HashMap<String, Command> commands = new HashMap<>();
    private static DataCommands instance;

    public static DataCommands getInstance() {
        if (instance == null) {
            throw new IllegalStateException("DataCommands has not been initialized");
        }
        return instance;
    }

    public static void initialize() {
        if (instance == null) {
            instance = new DataCommands();
        }
        else {
            throw new IllegalStateException("DataCommands has already been initialized");
        }
    }


    private DataCommands() {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("insert", new Insert());
        commands.put("update", new Update());
        commands.put("remove_key", new Remove_key());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script", new Execute_script());
        commands.put("exit", new Exit());
        commands.put("remove_lower", new Remove_lower());
        commands.put("replace_if_greater", new Replace_if_greater());
        commands.put("replace_if_lower", new Replace_if_lower());
        commands.put("count_by_number_of_participants", new Count_by_number_of_participants());
        commands.put("filter_less_then_label", new Filter_less_than_label());
        commands.put("print_field_descending_label", new Print_field_descending_label());

    }

    /**
     * Метод поучения названий всех команд
     * @return названия всех команд
     */
    public ArrayList<String> getNames() {
        return new ArrayList<>(commands.keySet());
    }


    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }


    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }

    /**
     * Метод, который запускает команду.
     * <p>
     *     Он проверяет сколько переменных было введено, далее создает подходящую команду и передает в нее переменные
     * </p>
     * @param commandName
     */
    public void createCommandByName(String commandName) {
        commandName = commandName.trim().toLowerCase();
        if (commandName.split("\\s+").length == 1) {
            if (commands.containsKey(commandName)) {
                commands.get(commandName).execute();
            } else {
                System.out.println();
                System.out.print(Colors.RED + "Cannot create command with name " + commandName + Colors.RESET);
                System.out.println();

            }
        } else if (commandName.split("\\s+").length == 2) {
            String[] values = commandName.split("\\s+");
            if (commands.containsKey(values[0])) {
                commands.get(values[0]).execute(values[1]);
            } else {
                System.out.println();
                System.out.print(Colors.RED + "Cannot create command with name " + values[0] + Colors.RESET);
                System.out.println();
            }

        } else {
            System.out.println();
            System.out.println(Colors.RED + "There are too many arguments for the function" + Colors.RESET);
            System.out.println();

        }


    }


    public void createCommandByName(String commandName, MusicBand musicBand) {
        commandName = commandName.trim().toLowerCase();
        if (commandName.split("\\s+").length == 1) {
            if (commands.containsKey(commandName)) {
                commands.get(commandName).execute(musicBand);
            } else {
                System.out.println();
                System.out.print(Colors.RED + "Cannot create command with name " + commandName + Colors.RESET);
                System.out.println();

            }
        } else if (commandName.split("\\s+").length == 2) {
            String[] values = commandName.split("\\s+");
            if (commands.containsKey(values[0])) {
                commands.get(values[0]).execute(values[1], musicBand);
            } else {
                System.out.println();
                System.out.print(Colors.RED + "Cannot create command with name " + values[0] + Colors.RESET);
                System.out.println();
            }

        } else {
            System.out.println();
            System.out.println(Colors.RED + "There are too many arguments for the function" + Colors.RESET);
            System.out.println();

        }


    }
}
