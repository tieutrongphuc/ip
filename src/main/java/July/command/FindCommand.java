package July.command;

import java.util.ArrayList;
import July.data.Storage;
import July.error.JulyException;
import July.tasks.Task;
import July.ui.Ui;

public class FindCommand extends Command {
    private String argument;
    public FindCommand(String s) {
        this.argument = s;
    }
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        if (argument == null) {
            throw new JulyException("I can only find a String data :<");
        }

        ArrayList<Task> save = new ArrayList<Task>();
        ArrayList<Integer> cnt = new ArrayList<Integer>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).checkDescription(argument)) {
                save.add(tasks.get(i));
                cnt.add(i + 1);
            }
        }
        if (save.size() > 0) {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < save.size(); i++) {
                System.out.printf("%d.%s%n", cnt.get(i), save.get(i));
            }
        } else {
            System.out.println("There are no match tasks in your list :<");
        }
    }
}
