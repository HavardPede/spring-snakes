package com.example.springsnakes.entities;

public enum Head {
    beluga("beluga"),
    bendr("bendr"),
    dead("dead"),
    evil("evil"),
    fang("fang"),
    pixel("pixel"),
    safe("safe"),
    sandWorm("sand-worm"),
    shades("shades"),
    silly("silly"),
    smile("smile"),
    tongue("tongue");

    public final String value;

    private Head(String value) {
        this.value = value;
    }
}
