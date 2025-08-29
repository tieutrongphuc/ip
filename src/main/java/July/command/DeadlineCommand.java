package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.tasks.Deadline;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;
import July.error.InvalidDeadlineException;

public class DeadlineCommand extends Command {
    private String argument;

    public DeadlineCommand(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        try {
            Deadline tmp = Deadline.process(argument);
            tasks.add(tmp);
            System.out.printf("Okie no problem, I've added a new deadline:%n%s%n", tasks.get(tasks.size() - 1));
        } catch (InvalidDeadlineException e) {
            throw new JulyException(e.getMessage());
        }
    }
}