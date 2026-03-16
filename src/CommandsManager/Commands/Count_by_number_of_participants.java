package CommandsManager.Commands;

import CommandsManager.Command;
import Data.ClassesManager;
import DataClasses.MusicBand;
import TermenalManager.Colors;

public class Count_by_number_of_participants extends Command {
    @Override
    public void execute() {
        System.out.println();
        System.out.println(Colors.RED + "Not supported" + Colors.RESET);
        System.out.println();
    }

    @Override
    public void execute(String value1) {
        ClassesManager classesManager = ClassesManager.getInstance();
        int count_participant = 0;
        int number_of_participants = CheckInteger(value1);
        for (int key : classesManager.GetMap().keySet()) {
            if (classesManager.GetMap().get(key).getNumberOfParticipants() == number_of_participants) {
                count_participant++;
            }
        }
        System.out.println();
        System.out.println("The number participants of equal " + Colors.GREEN + number_of_participants + Colors.RESET +
                "s is " + Colors.GREEN + count_participant + Colors.RESET);
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
        return "вывести количество элементов, значение поля numberOfParticipants которых равно заданному";
    }

    private int CheckInteger(String key) {
        int newKey;
        // если не является числом
        try {
            newKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Must be an integer");
        }
        return newKey;
    }
}
