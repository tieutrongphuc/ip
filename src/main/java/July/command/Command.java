package July.command;

import java.util.ArrayList;
import July.error.JulyException;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;

public abstract class Command {
    public abstract void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException;

    public boolean isDone() {
        return false;
    }
}