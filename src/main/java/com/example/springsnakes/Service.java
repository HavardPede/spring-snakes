package com.example.springsnakes;

import com.example.springsnakes.entities.Coordinate;
import com.example.springsnakes.entities.Move;
import com.example.springsnakes.entities.GameState;
import com.example.springsnakes.responses.MoveResponse;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    public MoveResponse computeBestMove(GameState state) {
        List<Coordinate> possibleNextCoordinates = createNextCoordinates(state.you.getHead());
        System.out.println("------- next move -------");
        System.out.println(possibleNextCoordinates);
        possibleNextCoordinates = removeOffBoard(possibleNextCoordinates, state.board.getWidth(), state.board.getHeight());
        System.out.println(possibleNextCoordinates);
        possibleNextCoordinates = removeOwnBody(possibleNextCoordinates, state.you.getBody());
        System.out.println(possibleNextCoordinates);

        // TODO: Using information from 'moveRequest', don't let your Battlesnake pick a
        // move
        // that would collide with another Battlesnake

        // TODO: Using information from 'moveRequest', make your Battlesnake move
        // towards a
        // piece of food on the board

        // Randomise order to not get stuck in a corner
        Collections.shuffle(possibleNextCoordinates);

        return possibleNextCoordinates.stream()
                .map(coordinate -> coordinateToMove(coordinate, state.you.getHead()))
                .map(MoveResponse::new)
                .findFirst()
                .orElse(new MoveResponse(Move.down, "I guess I die now"));
    }

    private List<Coordinate> createNextCoordinates(Coordinate head) {
        List<Coordinate> adjacentCoordinates = new ArrayList<>();
        adjacentCoordinates.add(new Coordinate(head.getX() - 1, head.getY()));
        adjacentCoordinates.add(new Coordinate(head.getX() + 1, head.getY()));
        adjacentCoordinates.add(new Coordinate(head.getX(), head.getY() - 1));
        adjacentCoordinates.add(new Coordinate(head.getX(), head.getY() + 1));

        return adjacentCoordinates;
    }

    private List<Coordinate> removeOffBoard(List<Coordinate> coordinates, int width, int height) {
        return coordinates.stream()
                .filter(coordinate ->
                    coordinate.getX() >= 0 && coordinate.getY() >= 0
                    && coordinate.getX() < width && coordinate.getY() < height)
                .collect(Collectors.toList());
    }

    private List<Coordinate> removeOwnBody(List<Coordinate> coordinates, Set<Coordinate> body) {
        return coordinates.stream()
                .filter(coordinate -> !body.contains(coordinate))
                .collect(Collectors.toList());
    }

    // Todo this should be done better. We are assuming all coordinates are adjacent
    private Move coordinateToMove(Coordinate coordinate, Coordinate head) {

        if (coordinate.getX() > head.getX()) {
            return Move.right;
        } else if (coordinate.getX() < head.getX()) {
            return Move.left;
        } else if (coordinate.getY() > head.getY()) {
            return Move.up;
        } else {
            return Move.down;
        }
    }
}
