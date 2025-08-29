package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;

public class ExitCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        storage.save(tasks);
        ui.bye();
    }

    @Override
    public boolean isDone() {
        return true;
    }
}