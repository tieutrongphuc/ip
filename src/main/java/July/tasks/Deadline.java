package July.tasks;

import July.datetime.StringTime;
import July.error.InvalidDeadlineException;

public class Deadline extends Task {

    protected StringTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = new StringTime(by);
    }

    public static Deadline process(String argument) throws InvalidDeadlineException {
        String[] tmp = argument.split("/by", 2);
        if (tmp.length != 2) {
            throw new InvalidDeadlineException("You need to have ONE '/by' in deadline command");
        }
        String description = tmp[0].trim();
        String by = tmp[1].trim();
        return new Deadline(description, by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String toSave() {
        return String.format("D %s %s /by %s", super.isDone ? "1" : "0", super.description, this.by);
    }

    public boolean check(StringTime o) {
        if (by.isString() || o.isString()) {
            return false;
        }
        return by.compareTo(o) >= 0;
    }

}