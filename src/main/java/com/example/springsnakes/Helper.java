package com.example.springsnakes;

import com.example.springsnakes.entities.Coordinate;
import com.example.springsnakes.entities.Move;
import com.example.springsnakes.entities.PossibleMove;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static Move coordinateToMove(Coordinate from, Coordinate to) {
        if (to.getX() > from.getX()) {
            return Move.right;
        } else if (to.getX() < from.getX()) {
            return Move.left;
        } else if (to.getY() > from.getY()) {
            return Move.up;
        } else {
            return Move.down;
        }
    }

    public static List<Coordinate> allMoves(Coordinate from) {
        List<Coordinate> moves = new ArrayList<>();
        moves.add(new Coordinate(from.getX() - 1, from.getY()));
        moves.add(new Coordinate(from.getX() + 1, from.getY()));
        moves.add(new Coordinate(from.getX(), from.getY() - 1));
        moves.add(new Coordinate(from.getX(), from.getY() + 1));

        return moves;
    }

    public static List<PossibleMove> getNonHTHCollisionOrAll(List<PossibleMove> possibleMoves) {
        List<PossibleMove> possibleMovesWithoutHTHCollisions = possibleMoves.stream()
            .filter(pm -> !pm.isHeadToHeadCollision())
            .collect(Collectors.toList());

        return possibleMovesWithoutHTHCollisions.isEmpty() ? possibleMoves : possibleMovesWithoutHTHCollisions;
    }
}
