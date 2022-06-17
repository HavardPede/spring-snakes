package com.example.springsnakes.entities;

public class Game {
    private String id;
    private Ruleset ruleset;
    private String map;
    private int timeout;
    private String source;

    public String getId() {
        return id;
    }

    public Ruleset getRuleset() {
        return ruleset;
    }

    public String getMap() {
        return map;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getSource() {
        return source;
    }
}
