package July.tasks;

import July.datetime.StringTime;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }

    public String toSave() {
        return String.format("T %s %s", super.isDone ? "1" : "0", super.description);
    }

    public boolean check(StringTime o) {
        return !super.isDone;
    }
}
