public class Event extends Task {

    protected String from, to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public static Event process(String argument) {
        String[] tmp = argument.split("/to", 2);
        String to = tmp[1].trim();
        String[] tmp1 = tmp[0].trim().split("/from", 2);
        String from = tmp1[1].trim();
        String description = tmp1[0].trim();
        return new Event(description, from, to);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (From: " + from + " to: " + to +")";
    }
}