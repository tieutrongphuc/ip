package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;

/**
 * Command to mark or unmark a task as done by its index number.
 * This command allows users to change the completion status of a specific task
 * and provides appropriate feedback based on the marking action performed.
 */
public class MarkCommand extends Command {
    private String argument;
    private boolean markAsDone;

    /**
     * Constructs a MarkCommand with the specified task number and marking action.
     *
     * @param argument the string representing the task number to mark/unmark
     * @param markAsDone true to mark the task as done, false to mark as not done
     */
    public MarkCommand(String argument, boolean markAsDone) {
        this.argument = argument;
        this.markAsDone = markAsDone;
    }

    /**
     * Executes the mark command to change the completion status of a specified task.
     * Validates the task number, updates the task's completion status, and displays
     * an appropriate confirmation message based on whether the task was marked or unmarked.
     *
     * @param tasks the ArrayList of tasks containing the task to mark/unmark
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
                tasks.get(i - 1).setDone(markAsDone);
                if (markAsDone) {
                    System.out.printf("Okie no problem, I've set task %d to done:%n%s%n", i, tasks.get(i - 1));
                } else {
                    System.out.printf("Okie no problem, I've set task %d to not done yet:%n%s%n", i, tasks.get(i - 1));
                }
            }
        } catch (NumberFormatException e) {
            throw new JulyException("Sorry " + argument + " is not a valid number");
        }
    }
}