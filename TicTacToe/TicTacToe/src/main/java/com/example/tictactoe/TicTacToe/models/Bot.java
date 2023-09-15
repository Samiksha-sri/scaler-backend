package com.example.tictactoe.TicTacToe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="player_id")
public class Bot extends Player{

    private Long bot_rank;
}
