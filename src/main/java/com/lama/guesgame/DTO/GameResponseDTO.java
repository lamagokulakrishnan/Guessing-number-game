package com.lama.guesgame.DTO;

import lombok.*;

@Data


public class GameResponseDTO {
    private String message;
    private int moves;
    private long timeTaken;
    private String bestPlayer;
    private String feedback;
    private double score;

    public GameResponseDTO(String feedback, int moves, long timeTaken, String bestPlayer) {
        this.feedback = feedback;
        this.moves = moves;
        this.timeTaken = timeTaken;
        this.bestPlayer = bestPlayer;
        this.score = score;
    }

    // Getters and setters
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getBestPlayer() {
        return bestPlayer;
    }

    public void setBestPlayer(String bestPlayer) {
        this.bestPlayer = bestPlayer;
    }
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
