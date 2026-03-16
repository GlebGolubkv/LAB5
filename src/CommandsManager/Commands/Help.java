package CommandsManager.Commands;

import CommandsManager.Command;
import Data.DataCommands;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Help extends Command {

    public Help() {
    }


    @Override
    public void execute() {
        StringBuilder helpCommands = new StringBuilder();
        DataCommands data = DataCommands.getInstance();
        for (String name : data.getNames()) {
            helpCommands.append(Colors.WHITE + "Command: " + Colors.GREEN)
                    .append(name).append(" : " + Colors.RESET).append(data.getCommand(name).commandInfo()).append("\n");

        }
        System.out.println();
        System.out.println(Colors.GREEN + "Commands: " + Colors.RESET);
        System.out.println(helpCommands);
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
        return "вывести справку по доступным командам";
    }

}
