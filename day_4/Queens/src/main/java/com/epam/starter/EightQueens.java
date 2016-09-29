package com.epam.starter;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

	public static void main(String[] args) {
		calculateNumberOfSolutions();
	}

	public static int calculateNumberOfSolutions() {
        ArrayList<char[][]> solutions = new ArrayList<char[][]>();
		
		char[][] result = new char[8][8];
		for (int r1 = 0; r1 < 8; r1++)
			Arrays.fill(result[r1], '.');
		
		solveAllNQueens(result, 0, solutions);
		
		System.out.println(solutions.size());
		for (int i = 0; i < solutions.size(); i++) {
			System.out.println("\nSolution " + (i + 1));
			
			char[][] board = solutions.get(i);
			
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[r].length; c++)
					System.out.print(board[r][c]);
				System.out.println();
			}
		}
		return solutions.size();
    }

	private static void solveAllNQueens(char[][] board, int col, ArrayList<char[][]> solutions) {
		if (col == board.length) {
			char[][] copy = new char[board.length][board[0].length];
			for (int r = 0; r < board.length; r++)
				for (int c = 0; c < board[0].length; c++)
					copy[r][c] = board[r][c];
			solutions.add(copy);
		} else {
			for (int row = 0; row < board.length; row++) {
				board[row][col] = 'q';
				boolean canBeSafe = true;
				
				for (int i = 0; i < board.length; i++) {
					boolean found = false;
					for (int j = 0; j < board.length; j++) {
						if (board[i][j] == 'q') {
							if (found) {
								canBeSafe = false;
							}
							found = true;
						}
					}
				}
				
				for (int i = 0; i < board.length; i++) {
					boolean found = false;
					for (int j = 0; j < board.length; j++) {
						if (board[j][i] == 'q') {
							if (found) {
								canBeSafe = false;
							}
							found = true;
						}
					}
				}
				
				for (int offset = -board.length; offset < board.length; offset++) {
					boolean found = false;
					for (int i = 0; i < board.length; i++) {
						if (inbounds(i, i + offset, board)) {
							if (board[i][i + offset] == 'q') {
								if (found) {
									canBeSafe = false;
								}
								found = true;
							}
						}
					}
				}
				
				for (int offset = -board.length; offset < board.length; offset++) {
					boolean found = false;
					for (int i = 0; i < board.length; i++) {
						if (inbounds(i, board.length - offset - i - 1, board)) {
							if (board[i][board.length - offset - i - 1] == 'q') {
								if (found) {
									canBeSafe = false;
								}
								found = true;
							}
						}
					}
				}
				
				if (canBeSafe)
					solveAllNQueens(board, col + 1, solutions);
				board[row][col] = '.';
			}
		}
	}

	private static boolean inbounds(int row, int col, char[][] mat) {
		return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
	}

}