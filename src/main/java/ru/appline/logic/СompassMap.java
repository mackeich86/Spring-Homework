package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class СompassMap implements Serializable {
    private static final СompassMap INSTANCE = new СompassMap();

    private final Map<String, Range> model;


    private СompassMap() {
        model = new HashMap<String, Range>();
    }

    public static СompassMap getInstance() {
        return INSTANCE;
    }

    public void add(String name, Range range) {
        model.put(name, range);
    }

    public String getSide(int degree) {
        return "{\"Side\":\"" + model.entrySet().stream()
                .filter(x -> x.getValue().contains(degree))
                .map(x -> x.getKey())
                .collect(Collectors.joining()) + "\"}";
    }
}
