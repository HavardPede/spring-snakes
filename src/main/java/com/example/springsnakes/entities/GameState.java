package com.example.springsnakes.entities;

public class GameState {
    private Game game;
    private int turn;
    private Board board;
    private BattleSnake you;

    public Game getGame() {
        return game;
    }

    public int getTurn() {
        return turn;
    }

    public Board getBoard() {
        return board;
    }

    public BattleSnake getYou() {
        return you;
    }
}
