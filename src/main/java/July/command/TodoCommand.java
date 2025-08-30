package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.tasks.Todo;
import July.ui.Ui;
import July.data.Storage;

/**
 * Command to create and add a new todo task to the task list.
 * This command creates a basic todo task with a description and adds it
 * to the current task collection without any specific deadline or time constraints.
 */
public class TodoCommand extends Command {
    private String description;

    /**
     * Constructs a TodoCommand with the specified task description.
     *
     * @param description the description text for the new todo task
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the todo command to create and add a new todo task.
     * Creates a new Todo object with the provided description, adds it to the
     * task list, and displays a confirmation message to the user.
     *
     * @param tasks the ArrayList of tasks to add the new todo to
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Todo(description));
        System.out.printf("Okie no problem, I've add the given task:%n%s%n", tasks.get(tasks.size() - 1));
    }
}