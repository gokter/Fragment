package com.flyingh.fragment;

public class Articles {
    private static final String[] titles = {"A", "B", "C"};
    private static final String[] contents = {
            "this is A's content!",
            "this is B's content!",
            "this is C's content!"
    };

    public static String[] getTitles() {
        return titles;
    }

    public static String getContent(int index) {
        return contents[index];
    }
}
