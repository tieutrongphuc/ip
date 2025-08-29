package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;

public class MarkCommand extends Command {
    private String argument;
    private boolean markAsDone;

    public MarkCommand(String argument, boolean markAsDone) {
        this.argument = argument;
        this.markAsDone = markAsDone;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        try {
            int i = Integer.parseInt(argument);
            if (i <= 0 || i > tasks.size()) {
                throw new JulyException("You are giving me an invalid task number: " + argument);
            } else {
                tasks.get(i - 1).setDone(markAsDone);
                if (markAsDone) {
                    System.out.printf("Okie no problem, I've set task %d to done:%n%s%n", i, tasks.get(i - 1));
                } else {
                    System.out.printf("Okie no problem, I've set task %d to not done yet:%n%s%n", i, tasks.get(i - 1));
                }
            }
        } catch (NumberFormatException e) {
            throw new JulyException("Sorry " + argument + " is not a valid number");
        }
    }
}