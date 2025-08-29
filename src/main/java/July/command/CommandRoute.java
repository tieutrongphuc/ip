package July.command;

import July.error.JulyException;

public class CommandRoute {
    public static Command parse(String fullCommand) {
        String input = fullCommand.trim().replaceAll("\\s+", " ").toLowerCase();

        if (input.equalsIgnoreCase("bye")) {
            return new ExitCommand();
        }

        String[] splitInput = keywords.parse(input);
        String keyword = splitInput[0];
        String argument = splitInput[1].trim();

        // Check if argument is empty for commands that require it
        if (argument.isEmpty() && !keyword.equals("list")) {
            throw new JulyException("Can you give the description of the task on one line");
        }

        switch (keyword) {
        case "check":
            return new CheckCommand(argument);
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(argument, true);
        case "unmark":
            return new MarkCommand(argument, false);
        case "todo":
            return new TodoCommand(argument);
        case "deadline":
            return new DeadlineCommand(argument);
        case "event":
            return new EventCommand(argument);
        case "delete":
            return new DeleteCommand(argument);
        default:
            return new UnknownCommand();
        }
    }
}
