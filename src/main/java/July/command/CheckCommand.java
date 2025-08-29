package July.command;

import java.util.ArrayList;
import July.tasks.Task;
import July.ui.Ui;
import July.data.Storage;
import July.error.JulyException;
import July.datetime.StringTime;

public class CheckCommand extends Command {
    private String argument;

    public CheckCommand(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        StringTime temp = new StringTime(argument);
        if (temp.isString()) {
            throw new JulyException("Please give a valid date: example dd/mm/yyyy");
        }

        System.out.printf("Okay let me check if you have any task not done yet on %s%n", temp);

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).check(temp)) {
                System.out.println(tasks.get(i));
            }
        }
    }
}