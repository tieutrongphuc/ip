package July.command;

import July.error.JulyException;

/**
 * Router class responsible for parsing user input and creating appropriate Command objects.
 * This class serves as the main entry point for command parsing, analyzing input strings
 * and returning the corresponding command instances based on keywords and arguments.
 */
public class CommandRoute {

    /**
     * Parses a full command string and returns the appropriate Command object.
     * This method processes user input by extracting keywords and arguments,
     * then creates and returns the corresponding command instance.
     *
     * @param fullCommand the complete command string entered by the user
     * @return the appropriate Command object based on the parsed input
     * @throws JulyException if the command requires an argument but none is provided,
     *                       or if there are issues with command parsing
     */
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
        case "find":
            return new FindCommand(argument);
        default:
            return new UnknownCommand();
        }
    }
}