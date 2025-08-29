import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class July {
    public static void main(String[] args) {
        System.out.println("Hello I'm July, your helpful assistant");

        // Init variables
        Scanner scanner = new Scanner(System.in);
        String input;
        ArrayList<Task> list = new ArrayList<>();

        while (true) {
            input = scanner.nextLine();
            input = input.trim().replaceAll("\\s+", " ").toLowerCase(); // delete unwanted space and turn lowercase

            if (input.equalsIgnoreCase("bye")) {
                break;
            }
            String[] splitInput = keywords.parse(input);
            String argument = splitInput[1].trim();

            // check if argument is empty
            if (argument.isEmpty() && !Objects.equals(splitInput[0], "list")) {
                System.out.println("Can you give the description of the task on one line");
                continue;
            }
            switch (splitInput[0]) {
            case "list":
                for (int i = 0; i < list.size(); i++) {
                    System.out.printf("%d.%s%n", i + 1, list.get(i));
                }
                break;
            case "mark":
                try {
                    int i = Integer.parseInt(argument);
                    if (i <= 0 || i > list.size()) {
                        System.out.printf("You are giving me an invalid task number: %s%n", argument);
                    } else {
                        list.get(i - 1).setDone(true);
                        System.out.printf("Okie no problem, I've set task %d to done:%n%s%n", i, list.get(i - 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.printf("Sorry %s is not a valid number%n", argument);
                }
                break;
            case "unmark":
                try {
                    int i = Integer.parseInt(argument);
                    if (i <= 0 || i > list.size()) {
                        System.out.printf("You are giving me an invalid task number: %s%n", argument);
                    } else {
                        list.get(i - 1).setDone(false);
                        System.out.printf("Okie no problem, I've set task %d to not done yet:%n%s%n", i, list.get(i - 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.printf("Sorry %s is not a valid number%n", argument);
                }
                break;
            case "todo":
                list.add(new Todo(argument));
                System.out.printf("Okie no problem, I've add the given task:%n%s%n",list.get(list.size() - 1));
                break;
            case "deadline":
                try {
                    Deadline tmp = Deadline.process(argument);
                    list.add(tmp);
                    System.out.printf("Okie no problem, I've added a new deadline:%n%s%n",list.get(list.size() - 1));
                } catch (InvalidDeadlineException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "event":
                try {
                    Event tmp = Event.process(argument);
                    list.add(tmp);
                    System.out.printf("Okie no problem, I've added a new event:%n%s%n",list.get(list.size() - 1));
                } catch (InvalidEventException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "delete":
                try {
                    int i = Integer.parseInt(argument);
                    if (i <= 0 || i > list.size()) {
                        System.out.printf("You are giving me an invalid task number: %s%n", argument);
                    } else {
                        System.out.printf("I've deleted task %d:%n%s%n", i, list.get(i - 1));
                        list.remove(i - 1);
                        System.out.printf("You have now %d remaining tasks%n", list.size());
                    }
                } catch (NumberFormatException e) {
                    System.out.printf("Sorry %s is not a valid number%n", argument);
                }
                break;
            default:
                System.out.println("Sorry I don't quite understand you :(");
            }

        }
        scanner.close();
        System.out.println("Good bye, I'm always here for you.");
    }
}
