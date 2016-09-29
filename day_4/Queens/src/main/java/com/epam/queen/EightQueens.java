package com.epam.queen;

import java.util.ArrayList;

public class EightQueens {

    public static void main(String[] args) {
        Board result = new Board();
        ArrayList<Board> solutions = solveAllNQueens(result, 0);
        System.out.println(solutions.size());
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("\nSolution " + (i + 1));
            Board board = solutions.get(i);
            System.out.println(board);
        }
    }

    public static ArrayList<Board> solveAllNQueens(Board board, int column) {
        ArrayList<Board> solutions = new ArrayList<>();
        if (column == Board.SIZE) {
            solutions.add(board.copy());
        } else {
            for (int row = 0; row < Board.SIZE; row++) {
                Queen queen = new Queen(new Coordinate(row, column));
                if (board.isSafe(queen)) {
                    board.addQueen(queen);
                    solutions.addAll(solveAllNQueens(board, column + 1));
                    board.removeQueen(queen);
                }
            }
        }
        return solutions;
    }

}