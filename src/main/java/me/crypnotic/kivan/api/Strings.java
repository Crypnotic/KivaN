package me.crypnotic.kivan.api;

public class Strings {

    public static String join(String[] content) {
        return join(content, 0, content.length);
    }

    public static String join(String[] content, int start) {
        return join(content, start, content.length);
    }

    public static String join(String[] content, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(content[i]);

            if (i + 1 < end) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
