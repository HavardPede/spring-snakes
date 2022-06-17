package com.example.springsnakes.entities;

public enum Tail {
    blockBum("block-bum"),
    bolt("bolt"),
    curled("curled"),
    fatRattle("fat-rattle"),
    freckled("freckled"),
    hook ("hook "),
    pixel("pixel"),
    roundBum("round-bum"),
    sharp("sharp"),
    skinny ("skinny "),
    smallRattle("small-rattle");

    public final String value;

    private Tail(String value) {
        this.value = value;
    }
}
