import java.util.ArrayList;

import july.command.Command;
import july.command.CommandRoute;
import july.data.Storage;
import july.error.JulyException;
import july.tasks.Task;
import july.ui.Ui;

/**
 * Main class for the July task management application.
 * This class serves as the entry point and orchestrates the interaction between
 * the user interface, command processing, task management, and data storage components.
 */
public class July {
    private final Storage storage;
    private final ArrayList<Task> tasks;
    private final Ui ui;

    /**
     * Constructs a July application instance with the specified storage file path.
     * Initializes the user interface, storage system, and loads existing tasks from the file.
     *
     * @param filePath the path to the file used for storing task data
     */
    public July(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.load();
    }

    /**
     * Runs the main application loop.
     * Displays the greeting message and continuously processes user commands
     * until an exit command is received. Handles exceptions by displaying
     * error messages to the user.
     */
    public void run() {
        ui.greet();
        boolean isDone = false;

        while (!isDone) {
            try {
                String fullCommand = ui.read();
                Command c = CommandRoute.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isDone = c.isDone();
            } catch (JulyException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Main method that serves as the entry point for the July application.
     * Creates a new July instance with a default storage file and starts the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new July("data/savefile.txt").run();
    }
}
