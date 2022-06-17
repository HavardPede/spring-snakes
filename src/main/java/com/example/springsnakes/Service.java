package com.example.springsnakes;

import com.example.springsnakes.entities.*;
import com.example.springsnakes.responses.MoveResponse;

@org.springframework.stereotype.Service
public class Service {
    public MoveResponse computeBestMove(GameState state) {
        NextMove nextMove = new NextMove(state);
        PossibleMove move = nextMove.getMove();

        if (move == null) {
            return new MoveResponse(Move.down, "I guess I die now");
        }

        return new MoveResponse(move.getMove());
    }
}
