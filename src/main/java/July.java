import java.util.Scanner;

public class July {
    public static void main(String[] args) {
        System.out.println("Hello I'm July, your helpful assistant");

        Scanner scanner = new Scanner(System.in);
        String input;
        int listLength = 0;
        String[] list = new String[105];

        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                if (input.equalsIgnoreCase("list")) {
                    for (int i = 0; i < listLength; i++) {
                        System.out.printf("%d.%s%n", i + 1, list[i]);
                    }
                } else {
                    System.out.println("added: " + input);
                    list[listLength] = input;
                    listLength++;
                }
            }
        }

        scanner.close();
        System.out.println("Good bye, I'm always here for you.");
    }
}
