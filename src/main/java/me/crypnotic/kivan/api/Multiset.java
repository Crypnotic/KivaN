package me.crypnotic.kivan.api;

import java.util.HashMap;

public class Multiset<T, V> extends HashMap<T, V> {

    private static final long serialVersionUID = 4736992155098978362L;

    public Multiset() {
        super();
    }

    public Multiset(Multiset<T, V> map) {
        super(map);
    }

    public static <T, V> Multiset<T, V> empty() {
        return new Multiset<T, V>();
    }

    public static <T, V> Multiset<T, V> of(Multiset<T, V> map) {
        return new Multiset<T, V>(map);
    }
}
