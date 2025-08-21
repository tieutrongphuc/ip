import java.util.Scanner;

public class July {
    public static void main(String[] args) {
        System.out.println("Hello I'm July, your helpful assistant");
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                System.out.println(input);
            }
        }

        scanner.close();
        System.out.println("Good bye, I'm always here for you.");
    }
}
