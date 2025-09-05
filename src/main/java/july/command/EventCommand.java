package july.command;

import java.util.ArrayList;

import july.data.Storage;
import july.error.InvalidEventException;
import july.error.JulyException;
import july.tasks.Event;
import july.tasks.Task;
import july.ui.Ui;

/**
 * Command to create and add a new event task to the task list.
 * This command processes user input to create an event task with a specific
 * time period and adds it to the current task collection.
 */
public class EventCommand extends Command {
    private final String argument;

    /**
     * Constructs an EventCommand with the specified argument string.
     *
     * @param argument the string containing the event task description and time details
     */
    public EventCommand(String argument) {
        this.argument = argument;
    }

    /**
     * Executes the event command to create and add a new event task.
     * Processes the argument to create an Event object, adds it to the task list,
     * and displays a confirmation message to the user.
     *
     * @param tasks the ArrayList of tasks to add the new event to
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     * @throws JulyException if the event format is invalid or cannot be processed
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        try {
            Event tmp = Event.process(argument);
            tasks.add(tmp);
            System.out.printf("Okie no problem, I've added a new event:%n%s%n", tasks.get(tasks.size() - 1));
        } catch (InvalidEventException e) {
            throw new JulyException(e.getMessage());
        }
    }
}
