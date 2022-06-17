package com.example.springsnakes;

import com.example.springsnakes.entities.GameState;
import com.example.springsnakes.responses.CustomizationResponse;
import com.example.springsnakes.responses.MoveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/")
    public CustomizationResponse getSnake() {
        return CustomizationResponse.main();
    }

    @PostMapping("/start")
    public void start() {
        // Allocate resources to this game id
    }

    @PostMapping("/move")
    public MoveResponse move(@RequestBody GameState gameState) {
        return new MoveResponse(service.computeBestMove(gameState));
    }

    @PostMapping("/end")
    public void end() {

    }
}
