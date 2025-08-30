package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;
import July.datetime.StringTime;

/**
 * Command to check for tasks that are not completed on a specific date.
 * This command allows users to query for incomplete tasks on a given date
 * and displays them to the user.
 */
public class CheckCommand extends Command {
    private String argument;

    /**
     * Constructs a CheckCommand with the specified date argument.
     *
     * @param argument the date string to check for incomplete tasks
     */
    public CheckCommand(String argument) {
        this.argument = argument;
    }

    /**
     * Executes the check command to find and display incomplete tasks on the specified date.
     * Check the date format and find tasks that are not completed on the given date.
     *
     * @param tasks the ArrayList of tasks to search through
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     * @throws JulyException if the date format is invalid
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        StringTime temp = new StringTime(argument);
        if (temp.isString()) {
            throw new JulyException("Please give a valid date: example dd/mm/yyyy");
        }

        System.out.printf("Okay let me check if you have any task not done yet on %s%n", temp);

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).check(temp)) {
                System.out.println(tasks.get(i));
            }
        }
    }
}