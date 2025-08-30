package July.tasks;

import July.datetime.StringTime;
import July.error.InvalidEventException;

public class Event extends Task {

    protected StringTime from, to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = new StringTime(from);
        this.to = new StringTime(to);
    }

    public static Event process(String argument) throws InvalidEventException {
        String[] tmp = argument.split("/to", 2);
        String to = tmp[1].trim();
        String[] tmp1 = tmp[0].trim().split("/from", 2);
        if (tmp.length != 2 || tmp1.length != 2) {
            throw new InvalidEventException("You need ONE '/from' and ONE '/to' for the event command");
        }
        String from = tmp1[1].trim();
        String description = tmp1[0].trim();
        return new Event(description, from, to);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (From: " + from + " to: " + to +")";
    }

    public String toSave() {
        return String.format("E %s %s /from %s /to %s", super.isDone ? "1" : "0", super.description,
                this.from.toSave(), this.to.toSave());
    }

    public boolean check(StringTime o) {
        if (from.isString() || to.isString() || o.isString()) {
            return false;
        }
        return from.compareTo(o) < 0 && to.compareTo(o) > 0 && !super.isDone;
    }
}