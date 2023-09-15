package com.example.tictactoe.TicTacToe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Player {

    @Id
    private long id;
    private String name;
    private int age;
}
