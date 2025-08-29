package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;

public class DeleteCommand extends Command {
    private String argument;

    public DeleteCommand(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        try {
            int i = Integer.parseInt(argument);
            if (i <= 0 || i > tasks.size()) {
                throw new JulyException("You are giving me an invalid task number: " + argument);
            } else {
                System.out.printf("I've deleted task %d:%n%s%n", i, tasks.get(i - 1));
                tasks.remove(i - 1);
                System.out.printf("You have now %d remaining tasks%n", tasks.size());
            }
        } catch (NumberFormatException e) {
            throw new JulyException("Sorry " + argument + " is not a valid number");
        }
    }
}
