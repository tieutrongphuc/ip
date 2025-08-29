package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.tasks.Todo;
import July.ui.Ui;
import July.data.Storage;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(new Todo(description));
        System.out.printf("Okie no problem, I've add the given task:%n%s%n", tasks.get(tasks.size() - 1));
    }
}