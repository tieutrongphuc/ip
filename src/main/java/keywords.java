public enum keywords {
    LIST("list"),
    MARK("mark"),
    UNMARK("unmark"),
    TODO("todo"),
    DEADLINE("deadline"),
    EVENT("event");

    private final String keyword;

    keywords(String s) {
        this.keyword = s;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public static String[] parse(String input) {
        for (keywords k : values()) {
            if (input.startsWith(k.getKeyword())) {
                String description = input.substring(k.getKeyword().length());
                return new String[]{k.getKeyword(), description};
            }
        }
        return new String[]{"",input};
    }

}
