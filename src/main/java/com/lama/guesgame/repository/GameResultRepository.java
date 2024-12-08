package com.lama.guesgame.repository;

import com.lama.guesgame.model.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {
    Optional<GameResult> findTopByOrderByScoreAsc(); // Fetch the best player based on the score

Optional<Game> findTopByOrderByScoreAsc();  // Assuming score is a combined metric of time and moves
}
