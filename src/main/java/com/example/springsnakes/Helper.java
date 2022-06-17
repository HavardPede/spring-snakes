package com.example.springsnakes;

import com.example.springsnakes.entities.Coordinate;
import com.example.springsnakes.entities.Move;

public class Helper {
    public static Move coordinateToMove(Coordinate coordinate, Coordinate startingPosition) {
        if (coordinate.getX() > startingPosition.getX()) {
            return Move.right;
        } else if (coordinate.getX() < startingPosition.getX()) {
            return Move.left;
        } else if (coordinate.getY() > startingPosition.getY()) {
            return Move.up;
        } else {
            return Move.down;
        }
    }
}
