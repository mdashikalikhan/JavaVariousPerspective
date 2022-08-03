package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		NQueens queens = new NQueens();
		/*queens.solveNQueens(1);
		queens.solveNQueens(2);
		queens.solveNQueens(3);*/
		queens.solveNQueens(4);
		/*queens.solveNQueens(5);
		queens.solveNQueens(6);
		queens.solveNQueens(7);
		queens.solveNQueens(8);
		queens.solveNQueens(9);*/
	}
	
	
	List<List<String>> result = new ArrayList<>();
	public List<List<String>> solveNQueens(int n) {
		int[][] matrix = new int[n][n];
		generateQueens(matrix, n, 0);
		System.out.println(result);
        return null;
    }
	
	public void generateQueens(int[][] matrix, int n, int row) {
		
			if(row>=n) {
				
				List<String> cResult = new ArrayList<>();
				for(int i=0; i<n; i++) {
					StringBuilder sb = new StringBuilder();
					for(int j=0; j<n; j++) {
						//System.out.print(matrix[i][j] + " ");
						if(matrix[i][j]==1) {
							sb.append("Q");
						} else {
							sb.append(".");
						}
					}
					cResult.add(sb.toString());
					//System.out.println();
				}
				
				result.add(cResult);
				//System.out.println(sb);
				return;
			}
		/*HashSet<Integer> tDiags = new HashSet<>();
		HashSet<Integer> tRowSet = new HashSet<>();
		HashSet<Integer> cList = new HashSet<>();*/
		
		
		for(int i=0; i<n; i++) {
			if(matrix[row][i]==0) {
				plotDiagonal(matrix, n, row, i);
				plotVertical(matrix, n, i);
				matrix[row][i] = 1;
				generateQueens(matrix, n, row + 1);
				plotReverseDiagonal(matrix, n, row, i);
				plotReverseVertical(matrix, n, i);
				matrix[row][i] = 0;
				
			}
			
			
		}
		
	}
	
	private void plotVertical(int[][] matrix, int n, int col) {
		for(int i=0; i<n; i++) {
			matrix[i][col] -= 1;
		}
	}
	
	private void plotReverseVertical(int[][] matrix, int n, int col) {
		for(int i=0; i<n; i++) {
			matrix[i][col] += 1;
		}
	}
	
	private void plotDiagonal(int[][] matrix, int n, int row, int col) {
		int x = col;
		int y = col;
		for(int i=row-1;i>=0;i--) {
			x-=1;
			y+=1;
			if(x>=0) {
				matrix[i][x] -= 1;
			}
			if(y<n) {
				matrix[i][y] -= 1;
			}
			
		}
		x = col;
		y = col;
		for(int i=row+1;i<n;i++) {
			x-=1;
			y+=1;
			if(x>=0) {
				matrix[i][x] -= 1;
			}
			if(y<n) {
				matrix[i][y] -= 1;
			}
			
		}
		
	}
	
	private void plotReverseDiagonal(int[][] matrix, int n, int row, int col) {
		int x = col;
		int y = col;
		for(int i=row-1;i>=0;i--) {
			x-=1;
			y+=1;
			if(x>=0) {
				matrix[i][x] += 1;
			}
			if(y<n) {
				matrix[i][y] += 1;
			}
			
		}
		x = col;
		y = col;
		for(int i=row+1;i<n;i++) {
			x-=1;
			y+=1;
			if(x>=0) {
				matrix[i][x] += 1;
			}
			if(y<n) {
				matrix[i][y] += 1;
			}
			
		}
		
	}
}
