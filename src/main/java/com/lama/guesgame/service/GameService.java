package com.lama.guesgame.service;

import com.lama.guesgame.DTO.GameResponseDTO;
import com.lama.guesgame.model.GameResult;
import com.lama.guesgame.repository.GameResultRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class GameService {
    private final GameResultRepository repository;
    private String computerNumber;
    private long startTime;

    public GameService(GameResultRepository repository) {
        this.repository = repository;
    }

    public void startNewGame(String playerName) {
        computerNumber = generateNumber();
        startTime = System.currentTimeMillis();
    }

    public GameResponseDTO checkGuess(String guess, String playerName) {
        if (computerNumber == null) {
            throw new IllegalStateException("Game has not been started. Please start a new game first.");
        }

        StringBuilder feedback = new StringBuilder();
        int moves = 0;

        for (int i = 0; i < 4; i++) {
            if (computerNumber.charAt(i) == guess.charAt(i)) {
                feedback.append("+");
            } else if (computerNumber.contains(String.valueOf(guess.charAt(i)))) {
                feedback.append("-");
            }
        }

        moves++;

        if (guess.equals(computerNumber)) {
            long timeTaken = (System.currentTimeMillis() - startTime) / 1000;
            int score = (int) (timeTaken + moves);

            GameResult result = new GameResult();
            result.setPlayerName(playerName);
            result.setMoves(moves);
            result.setDuration(timeTaken);
            result.setScore(score);

            repository.save(result);

            Optional<GameResult> topPlayerResult = repository.findTopByOrderByScoreAsc();

            String bestPlayer = topPlayerResult
                    .map(GameResult::getPlayerName) // Extract playerName from the GameResult if present
                    .orElse("No player found");    // Default message if no player is found
            return new GameResponseDTO("Congratulations! You've guessed it.", moves, timeTaken, bestPlayer);
        }

        return new GameResponseDTO(feedback.toString(), moves, 0, null);
    }

    private String generateNumber() {
        Random random = new Random();
        StringBuilder number = new StringBuilder();

        while (number.length() < 4) {
            int digit = random.nextInt(10);
            if (!number.toString().contains(String.valueOf(digit))) {
                number.append(digit);
            }
        }
        return number.toString();
    }
}

