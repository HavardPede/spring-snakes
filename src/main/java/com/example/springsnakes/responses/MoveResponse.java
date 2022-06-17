package com.example.springsnakes.responses;

import com.example.springsnakes.entities.Move;

public class MoveResponse {
    private Move move;
    private String shout;

    public MoveResponse(Move move) {
        this.move = move;
    }

    public MoveResponse(Move move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}
