package com.example.springsnakes.entities;

import java.util.List;

public class Board {
    private int height;
    private int width;
    private List<Coordinate> food;
    private List<Coordinate> hazards;
    private List<BattleSnake> snakes;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Coordinate> getFood() {
        return food;
    }

    public List<Coordinate> getHazards() {
        return hazards;
    }

    public List<BattleSnake> getSnakes() {
        return snakes;
    }
}
