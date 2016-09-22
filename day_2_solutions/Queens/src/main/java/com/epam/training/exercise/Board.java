package com.epam.training.exercise;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int SIZE = 8;
    private List<Queen> queens = new ArrayList<>();

    public Board() {
    }

    public Board(List<Queen> queens) {
        this.queens = new ArrayList<>(queens);
    }
    
    public boolean isOccupied(Coordinate coordinate) {
        boolean occupied = false;
        for (Queen queen : queens) {
            if (queen.occupies(coordinate)) {
                occupied = true;
            }
        }
        return occupied;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isOccupied(new Coordinate(i, j))) {
                    builder.append("q");
                } else {
                    builder.append(".");
                }
            }            
            builder.append("\n");
        }
        return builder.toString();
    }

    public Board copy() {
        return new Board(queens);
    }

    public void addQueen(Queen queen) {
        queens.add(queen);
    }

    public void removeQueen(Queen queen) {
        queens.remove(queen);
    }

    public boolean isSafe(Queen queen) {
        boolean canBeSafe = true;
        for (int i = 0; i < queens.size() && canBeSafe; i++) {
            if (queens.get(i).attacks(queen)) {
                canBeSafe = false;
            }
        }
        return canBeSafe;
    }

}
