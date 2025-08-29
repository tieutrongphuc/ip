package July.datetime;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
public class StringTime {
    private String input;
    private LocalDateTime dateTime = null;

    private static final List<String> DATE_TIME = Arrays.asList(
            "dd/MM/yyyy HH:mm",
            "dd/MM/yyyy HH:mm",
            "yyyy-MM-dd HH:mm",
            "dd-MM-yyyy HH:mm"
    );

    private static final List<String> DATE_ONLY = Arrays.asList(
            "d/M/yyyy",
            "dd/MM/yyyy",
            "yyyy-MM-dd",
            "dd-MM-yyyy"
    );

    public StringTime(String s) {
        this.input = s;
        this.dateTime = parse(s);
        if (this.dateTime == null) {
            this.dateTime = parseDate(s);
        }
    }

    private LocalDateTime parse(String input) {
        for (String pattern : DATE_TIME) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException ignored) {

            }
        }
        return null;
    }

    private LocalDateTime parseDate(String input) {
        for (String pattern : DATE_ONLY) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                LocalDate date = LocalDate.parse(input, formatter);
                return date.atStartOfDay();
            } catch (DateTimeParseException ignored) {

            }
        }
        return null;
    }

    public boolean isString() {
        return this.dateTime == null;
    }

    public int compareTo(StringTime other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public String toString() {
        if (this.dateTime != null) {
            return dateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"));
        }
        return input;
    }

}

