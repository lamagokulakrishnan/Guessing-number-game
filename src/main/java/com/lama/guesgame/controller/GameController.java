package com.lama.guesgame.controller;

import com.lama.guesgame.DTO.GameRequestDTO;
import com.lama.guesgame.DTO.GameResponseDTO;
import com.lama.guesgame.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Endpoint to start a new game
    @PostMapping("/start")
    public void startNewGame(@RequestBody GameRequestDTO gameRequestDTO) {
        gameService.startNewGame(gameRequestDTO.getPlayerName());
    }

    // Endpoint to make a guess
    @PostMapping("/guess")
    public GameResponseDTO guess(@RequestBody GameRequestDTO gameRequestDTO) {
        return gameService.checkGuess(gameRequestDTO.getGuess(), gameRequestDTO.getPlayerName());
    }
}

