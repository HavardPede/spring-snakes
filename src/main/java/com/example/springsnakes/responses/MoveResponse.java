package com.example.springsnakes.responses;

import com.example.springsnakes.entities.Move;

import java.io.Serializable;

public class MoveResponse implements Serializable {
    private Move move;
    private String shout;

    public MoveResponse(Move move) {
        this.move = move;
    }

    public MoveResponse(Move move, String shout) {
        this.move = move;
        this.shout = shout;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public String getShout() {
        return shout;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    @Override
    public String toString() {
        return "MoveResponse{" +
                "move=" + move +
                ", shout='" + shout + '\'' +
                '}';
    }
}
