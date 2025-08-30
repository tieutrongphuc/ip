package July.tasks;

import July.datetime.StringTime;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String toSave() {
        return "";
    }

    public boolean check(StringTime o) {
        return false;
    }

    public boolean checkDescription(String s) {
        return description.contains(s);
    }
}
