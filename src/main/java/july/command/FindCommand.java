package july.command;

import java.util.ArrayList;

import july.data.Storage;
import july.error.JulyException;
import july.tasks.Task;
import july.ui.Ui;

/**
 * Command to find tasks by description keyword.
 * Searches for tasks whose description contains the given keyword and displays them.
 */
public class FindCommand extends Command {
    private final String argument;
    public FindCommand(String s) {
        super();
        this.argument = s;
    }

    /**
     * Executes the find command to search for tasks by description keyword.
     * Finds all tasks whose description contains the given keyword and displays them.
     *
     * @param tasks the ArrayList of tasks to search through
     * @param ui the user interface component for displaying output
     * @param storage the storage component for data persistence
     * @throws JulyException if the argument is null or invalid
     */
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws JulyException {
        if (argument == null) {
            throw new JulyException("I can only find a String data :<");
        }

        ArrayList<Task> save = new ArrayList<>();
        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).checkDescription(argument)) {
                save.add(tasks.get(i));
                cnt.add(i + 1);
            }
        }

        if (!save.isEmpty()) {
            ArrayList<String> responses = new ArrayList<>();
            responses.add("Here are the matching tasks in your list:");
            for (int i = 0; i < save.size(); i++) {
                responses.add(String.format("%d.%s", cnt.get(i), save.get(i)));
            }
            addResponses(responses.toArray(new String[0]));
        } else {
            addResponses("There are no match tasks in your list :<");
        }
    }
}
