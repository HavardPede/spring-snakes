package com.example.springsnakes.entities;

import com.example.springsnakes.Helper;
import com.example.springsnakes.responses.MoveResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NextMove {
    private GameState gameState;

    List<Coordinate> possibleMoves = new ArrayList<>();

    public NextMove(GameState gameState) {
        this.gameState = gameState;
        System.out.println("------- All legal move -------");
        createNextCoordinates();
        System.out.println(possibleMoves);

        removeMovesOffTheBoard();
        System.out.println(possibleMoves);

        removeCollisions();
        System.out.println(possibleMoves);

        // TODO Look for food
        // TODO avoid hallways
    }

    public Move getMove() {
        // Randomise order to not get stuck in a corner
        Collections.shuffle(possibleMoves);

        return possibleMoves.stream()
                .map(coordinate -> Helper.coordinateToMove(coordinate, gameState.getYou().getHead()))
                .findFirst()
                .orElse(null);
    }

    private void createNextCoordinates() {
        Coordinate head = gameState.getYou().getHead();

        addMove(head.getX() - 1, head.getY());
        addMove(head.getX() + 1, head.getY());

        addMove(head.getX(), head.getY() - 1);
        addMove(head.getX(), head.getY() + 1);
    }

    private void addMove(int x, int y) {
        possibleMoves.add(new Coordinate(x, y));
    }

    private void removeMovesOffTheBoard() {
        possibleMoves = possibleMoves.stream()
                .filter(coordinate ->
                    coordinate.getX() >= 0 && coordinate.getY() >= 0
                            && coordinate.getX() < gameState.getBoard().getWidth()
                            && coordinate.getY() < gameState.getBoard().getWidth())
                .collect(Collectors.toList());
    }

    private void removeCollisions() {
        gameState.getBoard().getSnakes().forEach(snake -> removeCollision(snake.getBody()));
    }

    private void removeCollision(Set<Coordinate> snakeBody) {
        possibleMoves = possibleMoves.stream()
                .filter(coordinate -> !snakeBody.contains(coordinate))
                .collect(Collectors.toList());
    }
}
