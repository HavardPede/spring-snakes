package com.example.springsnakes.entities;

public class Customization {
    private final static String TEAL = "008080";

    private String color;
    private String head;
    private String tail;

    public Customization(String color, String head, String tail) {
        this.color = color;
        this.head = head;
        this.tail = tail;
    }

    public static Customization main() {
        return new Customization(TEAL, Head.shades.value, Tail.blockBum.value);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
