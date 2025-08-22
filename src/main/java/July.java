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
            switch (splitInput[0]) {
            case "list":
                for (int i = 0; i < list.size(); i++) {
                    System.out.printf("%d.%s%n", i + 1, list.get(i));
                }
                break;
            case "mark":
                int i = Integer.parseInt(argument);
                list.get(i - 1).setDone(true);
                System.out.printf("Okie no problem, I've set task %d to done:%n%s%n", i,list.get(i - 1));
                break;
            case "unmark":
                int j = Integer.parseInt(argument);
                list.get(j - 1).setDone(false);
                System.out.printf("Okie no problem, I've set task %d to not done yet:%n%s%n", j,list.get(j - 1));
                break;
            case "todo":
                list.add(new Todo(argument));
                System.out.printf("Okie no problem, I've add the given task:%n%s%n",list.get(list.size() - 1));
                break;
            case "deadline":
                list.add(Deadline.process(argument));
                System.out.printf("Okie no problem, I've added a new deadline:%n%s%n",list.get(list.size() - 1));
                break;
            case "event":
                list.add(Event.process(argument));
                System.out.printf("Okie no problem, I've added a new event:%n%s%n",list.get(list.size() - 1));
                break;
            default:
                System.out.println("Sorry I don't quite understand you :(");
            }

        }

        scanner.close();
        System.out.println("Good bye, I'm always here for you.");
    }
}
