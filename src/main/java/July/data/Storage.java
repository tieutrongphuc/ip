package July.data;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import July.tasks.Task;
import July.tasks.Todo;
import July.tasks.Event;
import July.tasks.Deadline;
import July.error.InvalidEventException;
import July.error.InvalidDeadlineException;

public class Storage {
    private final File f;

    public Storage(String filePath) {
        this.f = new File(filePath);
        f.getParentFile().mkdirs();
        try {
            f.createNewFile(); // create if missing
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            return tasks;
        }
        return tasks;
    }

    public void save(ArrayList<Task> tasks) {
        try (FileWriter fw = new FileWriter(f)) {
            for (Task task : tasks) {
                fw.write(task.toSave() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private Task parseTask(String line) {
        try {
            String[] argument = line.split("\\s+", 3);
            String keyword = argument[0].trim();
            String isDone = argument[1].trim();
            String description = argument[2].trim();

            switch (keyword) {
            case "T":
                return new Todo(description);
            case "D":
                try {
                    Task tmp = Deadline.process(description);
                    tmp.setDone(isDone.equals("1"));
                    return tmp;
                } catch (InvalidDeadlineException e) {
                    System.out.println("Error reading Deadline task");
                }
                break;
            case "E":
                try {
                    Task tmp = Event.process(description);
                    tmp.setDone(isDone.equals("1"));
                    return tmp;
                } catch (InvalidEventException e) {
                    System.out.println("Error reading Event task");
                }
                break;
            default:
                return null;
            }
        } catch (Exception e) {
            System.out.println("Found corrupted line: " + line);
            return null;
        }
        return null;
    }
}