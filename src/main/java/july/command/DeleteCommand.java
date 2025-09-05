package july.command;

import java.util.ArrayList;

import july.data.Storage;
import july.error.JulyException;
import july.tasks.Task;
import july.ui.Ui;

/**
 * Command to delete a task from the task list by its index number.
 * This command removes a specified task from the task ArrayList and
 * provides feedback about the deletion and remaining task count.
 */
public class DeleteCommand extends Command {
    private final String argument;

    /**
     * Constructs a DeleteCommand with the specified task number argument.
     *
     * @param argument the string representing the task number to delete
     */
    public DeleteCommand(String argument) {
        this.argument = argument;
    }

    /**
     * Executes the delete command to remove a task from the task list.
     * Validates the task number, removes the specified task, and displays
     * confirmation messages including the deleted task and remaining count.
     *
     * @param tasks the ArrayList of tasks from which to delete the specified task
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     * @throws JulyException if the argument is not a valid number or if the
     *                       task number is out of range (less than 1 or greater than task list size)
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        try {
            int i = Integer.parseInt(argument);
            if (i <= 0 || i > tasks.size()) {
                throw new JulyException("You are giving me an invalid task number: " + argument);
            } else {
                System.out.printf("I've deleted task %d:%n%s%n", i, tasks.get(i - 1));
                tasks.remove(i - 1);
                System.out.printf("You have now %d remaining tasks%n", tasks.size());
            }
        } catch (NumberFormatException e) {
            throw new JulyException("Sorry " + argument + " is not a valid number");
        }
    }
}
