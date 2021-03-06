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
        MoveResponse response = service.computeBestMove(gameState);
        System.out.println(response);

        return response;
    }

    @PostMapping("/end")
    public void end() {
        // Deallocate resources based on game id
    }
}
