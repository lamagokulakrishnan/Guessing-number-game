--liquibase formatted sql
--changeset lama:1

CREATE TABLE game_result (
    id BIGSERIAL PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    moves INT NOT NULL,
    duration BIGINT NOT NULL,
    score INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
