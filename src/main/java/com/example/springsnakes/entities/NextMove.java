package com.example.springsnakes.entities;

import com.example.springsnakes.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NextMove {
    private GameState gameState;

    List<PossibleMove> possibleMoves = new ArrayList<>();

    public NextMove(GameState gameState) {
        this.gameState = gameState;
        System.out.println("------- All legal move -------");
        createNextCoordinates();
        System.out.println(possibleMoves);

        removeMovesOffTheBoard();
        System.out.println(possibleMoves);

        removeCollisions();
        System.out.println(possibleMoves);

        avoidHeadToHeadCollisions();
        System.out.println(possibleMoves);

        avoidHallways();

        // TODO Look for food
    }

    public PossibleMove getMove() {
        List<PossibleMove> clonedList = new ArrayList<>(possibleMoves);

        // Randomise order to not get stuck in a corner
        Collections.shuffle(clonedList);
        clonedList = Helper.getNonHTHCollisionOrAll(clonedList);

        return clonedList.stream().findFirst().orElse(null);
    }

    private void createNextCoordinates() {
        Coordinate from = gameState.getYou().getHead();

        addMove(from,from.getX() - 1, from.getY());
        addMove(from,from.getX() + 1, from.getY());

        addMove(from,from.getX(), from.getY() - 1);
        addMove(from,from.getX(), from.getY() + 1);
    }

    private void addMove(Coordinate from, int x, int y) {
        possibleMoves.add(new PossibleMove(from, x, y));
    }

    private void removeMovesOffTheBoard() {
        possibleMoves = possibleMoves.stream()
                .filter(possibleMove -> {
                    Coordinate coord = possibleMove.getCoordinate();

                    return coord.getX() >= 0 && coord.getY() >= 0
                            && coord.getX() < gameState.getBoard().getWidth()
                            && coord.getY() < gameState.getBoard().getWidth();
                })
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

    private void avoidHeadToHeadCollisions() {
        gameState.getBoard().getSnakes().stream()
            .filter(snake -> !snake.equals(gameState.getYou()))
            .forEach(this::handleHeadToHeadCollisionWithSnake);
    }

    private void handleHeadToHeadCollisionWithSnake(BattleSnake snake) {
        List<Coordinate> moves = Helper.allMoves(snake.getHead());

        possibleMoves.forEach(possibleMove -> {
            if (moves.stream().anyMatch(move -> move.equals(possibleMove.coordinate))) {
                possibleMove.headToHeadCollision = true;
            }
        });
    }

    private void avoidHallways() {
        // TODO avoid hallways
    }
}
