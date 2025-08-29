import java.util.ArrayList;

import July.command.CommandRoute;
import July.error.JulyException;
import July.data.Storage;
import July.tasks.Task;
import July.ui.Ui;
import July.command.Command;

public class July {
    private Storage storage;
    private ArrayList<Task> tasks;
    private Ui ui;

    public July(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.load();
    }

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

    public static void main(String[] args) {
        new July("data/savefile.txt").run();
    }
}