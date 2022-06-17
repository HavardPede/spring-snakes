package com.example.springsnakes.entities;

import com.example.springsnakes.Helper;

public class PossibleMove {
    Coordinate coordinate;
    Move move;

    boolean headToHeadCollision;
    boolean towardsFood;
    boolean downHallway;

    PossibleMove(Coordinate from, int x, int y) {
        this.coordinate = new Coordinate(x, y);
        this.move = Helper.coordinateToMove(coordinate, from);
        this.headToHeadCollision = false;
        this.towardsFood = false;
        this.downHallway = false;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public boolean isHeadToHeadCollision() {
        return headToHeadCollision;
    }

    public void setHeadToHeadCollision(boolean headToHeadCollision) {
        this.headToHeadCollision = headToHeadCollision;
    }

    public boolean isTowardsFood() {
        return towardsFood;
    }

    public void setTowardsFood(boolean towardsFood) {
        this.towardsFood = towardsFood;
    }

    public boolean isDownHallway() {
        return downHallway;
    }

    public void setDownHallway(boolean downHallway) {
        this.downHallway = downHallway;
    }
}
