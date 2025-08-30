package July.command;

import java.util.ArrayList;
import July.error.JulyException;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;

public abstract class Command {
    /**
     * Executes the event command to create and add a new event task.
     * Processes the argument to create an Event object, adds it to the task list,
     * and displays a confirmation message to the user.
     *
     * @param tasks the ArrayList of tasks to add the new event to
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     * @throws JulyException there is any error in the execute process
     */
    public abstract void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException;

    /**
     * Indicates whether the command represents a termination request.
     * This method is set to false by default
     *
     * @return false, indicating that the application should continue
     */
    public boolean isDone() {
        return false;
    }
}