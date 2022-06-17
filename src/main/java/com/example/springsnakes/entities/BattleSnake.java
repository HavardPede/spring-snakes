package com.example.springsnakes.entities;

import java.util.Set;

public class BattleSnake {
    private String id;
    private String name;
    private String latency;

    private int health;
    private Coordinate head;
    private Set<Coordinate> body;
    private int length;
    private String shout;
    private String squad;
    private Customization customization;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Coordinate getHead() {
        return head;
    }

    public void setHead(Coordinate head) {
        this.head = head;
    }

    public Set<Coordinate> getBody() {
        return body;
    }

    public void setBody(Set<Coordinate> body) {
        this.body = body;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getShout() {
        return shout;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public Customization getCustomization() {
        return customization;
    }

    public void setCustomization(Customization customization) {
        this.customization = customization;
    }
}
