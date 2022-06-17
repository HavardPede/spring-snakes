package com.example.springsnakes;

import com.example.springsnakes.entities.Coordinate;
import com.example.springsnakes.entities.Move;
import com.example.springsnakes.entities.GameState;
import com.example.springsnakes.responses.MoveResponse;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    public MoveResponse computeBestMove(GameState state) {
        Set<Coordinate> possibleNextCoordinates = createNextCoordinates(state.you.getHead());
        System.out.println("all coords");
        System.out.println(possibleNextCoordinates);
        possibleNextCoordinates = removeOffBoard(possibleNextCoordinates, state.board.getHeight(), state.board.getWidth());
        System.out.println("all on board");
        System.out.println(possibleNextCoordinates);
        possibleNextCoordinates = removeOwnBody(possibleNextCoordinates, state.you.getBody());
        System.out.println("all without body");
        System.out.println(possibleNextCoordinates);

        // TODO: Using information from 'moveRequest', don't let your Battlesnake pick a
        // move
        // that would collide with another Battlesnake

        // TODO: Using information from 'moveRequest', make your Battlesnake move
        // towards a
        // piece of food on the board

        return possibleNextCoordinates.stream()
                .map(coordinate -> coordinateToMove(coordinate, state.you.getHead()))
                .map(MoveResponse::new)
                .findFirst()
                .orElse(new MoveResponse(Move.down, "I guess I die now"));
    }

    private Set<Coordinate> createNextCoordinates(Coordinate head) {
        Set<Coordinate> adjacentCoordinates = new HashSet<>();
        adjacentCoordinates.add(new Coordinate(head.getX() - 1, head.getY()));
        adjacentCoordinates.add(new Coordinate(head.getX() + 1, head.getY()));
        adjacentCoordinates.add(new Coordinate(head.getX(), head.getY() - 1));
        adjacentCoordinates.add(new Coordinate(head.getX(), head.getY() + 1));

        return adjacentCoordinates;
    }

    private Set<Coordinate> removeOffBoard(Set<Coordinate> coordinates, int height, int width) {
        return coordinates.stream()
                .filter(coordinate ->
                    coordinate.getX() >= 0 && coordinate.getY() >= 0
                    && coordinate.getX() < height && coordinate.getY() < width)
                .collect(Collectors.toSet());
    }

    private Set<Coordinate> removeOwnBody(Set<Coordinate> coordinates, Set<Coordinate> body) {
        return coordinates.stream()
                .filter(coordinate -> !body.contains(coordinate))
                .collect(Collectors.toSet());
    }

    // Todo this should be done better. We are assuming all coordinates are adjacent
    private Move coordinateToMove(Coordinate coordinate, Coordinate head) {

        if (coordinate.getX() > head.getX()) {
            return Move.up;
        } else if (coordinate.getX() < head.getX()) {
            return Move.down;
        } else if (coordinate.getY() > head.getY()) {
            return Move.right;
        } else {
            return Move.left;
        }
    }

    public void avoidMyNeck(JsonNode head, JsonNode body, ArrayList<String> possibleMoves) {
        JsonNode neck = body.get(1);

        if (neck.get("x").asInt() < head.get("x").asInt()) {
            possibleMoves.remove("left");
        } else if (neck.get("x").asInt() > head.get("x").asInt()) {
            possibleMoves.remove("right");
        } else if (neck.get("y").asInt() < head.get("y").asInt()) {
            possibleMoves.remove("down");
        } else if (neck.get("y").asInt() > head.get("y").asInt()) {
            possibleMoves.remove("up");
        }
    }
}
