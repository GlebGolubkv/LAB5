package CommandsManager.Commands;

import CommandsManager.Command;
import DataClasses.MusicBand;
import FileManager.CommandsParser.CommandsReader;
import TermenalManager.Colors;

public class Execute_script extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();

    }

    @Override
    public void execute(String value1) {
        System.out.println();
        System.out.println("Read commands from file");
        System.out.println();

        CommandsReader.getInstance().readCommands(value1);
        CommandsReader.getInstance().resetCommand();
        // после обнаружения рикурсии - рекурсивно оотчищает несколько раз список с командами, так как в каждом запросе идет посл выполнения внутренней рекурсии

    }

    @Override
    public void execute(String value1, MusicBand value2) {

    }

    @Override
    public void execute(MusicBand value1) {

    }

    @Override
    public String commandInfo() {
        return "считать и исполнить скрипт из указанного файла";
    }
}
