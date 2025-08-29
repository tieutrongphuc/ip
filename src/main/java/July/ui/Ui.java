package July.ui;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String read() {
        return scanner.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void greet() {
        System.out.println("Hello I'm July, your helpful assistant");
    }

    public  void bye() {
        System.out.println("Good bye, I'm always here for you.");
    }

    public void sorry() {
        System.out.println("Sorry I don't quite understand you :(");
    }
}
