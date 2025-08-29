package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.tasks.Event;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;
import July.error.InvalidEventException;

public class EventCommand extends Command {
    private String argument;

    public EventCommand(String argument) {
        this.argument = argument;
    }

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