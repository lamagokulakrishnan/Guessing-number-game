package com.lama.guesgame.controller;

import com.lama.guesgame.DTO.GameRequestDTO;
import com.lama.guesgame.DTO.GameResponseDTO;
import com.lama.guesgame.model.GameResult;
import com.lama.guesgame.service.GameService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> startNewGame(@RequestBody GameRequestDTO gameRequestDTO) {
        try {
            gameService.startNewGame(gameRequestDTO.getPlayerName());
            return ResponseEntity.ok("Game started successfully for player: " + gameRequestDTO.getPlayerName());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error starting game: " + e.getMessage());
        }
    }

    // Endpoint to make a guess
    @PostMapping("/guess")
    public ResponseEntity<GameResponseDTO> guess(@RequestBody GameRequestDTO gameRequestDTO) {
        try {
            GameResponseDTO response = gameService.checkGuess(gameRequestDTO.getGuess(), gameRequestDTO.getPlayerName());
            return ResponseEntity.ok(response);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(new GameResponseDTO(e.getMessage(), 0, 0, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new GameResponseDTO("Unexpected error: " + e.getMessage(), 0, 0, null));
        }
    }

    // Endpoint to get the best score
    @GetMapping("/best-score")
    public ResponseEntity<String> getBestScore() {
        try {
            String bestPlayer = gameService.getBestPlayer();
            return ResponseEntity.ok(bestPlayer);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving best score: " + e.getMessage());
        }
    }
}
