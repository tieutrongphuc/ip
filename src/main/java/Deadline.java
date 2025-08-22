public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public static Deadline process(String argument) {
        String[] tmp = argument.split("/by", 2);
        String description = tmp[0].trim();
        String by = tmp[1].trim();
        return new Deadline(description, by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}