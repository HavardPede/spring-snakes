package com.example.springsnakes;

import com.example.springsnakes.entities.Coordinate;
import com.example.springsnakes.entities.Move;
import com.example.springsnakes.entities.GameState;
import com.example.springsnakes.entities.NextMove;
import com.example.springsnakes.responses.MoveResponse;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    public MoveResponse computeBestMove(GameState state) {
        NextMove nextMove = new NextMove(state);
        Move move = nextMove.getMove();

        if (move == null) {
            return new MoveResponse(Move.down, "I guess I die now");
        }

        return new MoveResponse(move);
    }
}
