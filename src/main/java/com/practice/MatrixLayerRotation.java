package com.practice;

import java.util.Arrays;
import java.util.List;

public class MatrixLayerRotation {

	public static void main(String[] args) {
		
		
		List<List<Integer>> matrix= Arrays.asList(
				/*Arrays.asList(1,2,3,4),
				Arrays.asList(5,6,7,8),
				Arrays.asList(9,10,11,12),
				Arrays.asList(13,14,15,16)*/
				Arrays.asList(1,2,3,4,5),
				Arrays.asList(6,7,8,9,10),
				Arrays.asList(11,12,13,14,15),
				Arrays.asList(16,17,18,19,20),
				Arrays.asList(21,22,23,24,25),
				Arrays.asList(26,27,28,29,30));
		
		System.out.println(matrix);
		int rows = matrix.size();
		
		int cols = matrix.get(0).size();
		
		
		
		
		
		int offset =1;
		
		
		int rowsO = rows - offset*2;
		int colsO = cols - offset*2;
		rows = rows - offset;
		cols = cols - offset;
		
		
		
		System.out.println("rows = " + rows);
		
		System.out.println("cols = " + cols);
		
		System.out.println("rowsO = " + rowsO);
		
		System.out.println("colsO = " + colsO);
		
		if(colsO<=1) {
			return;
		}
		
		int size = cols + rows-1 + cols-1 + rows-2 ;
		
		if(offset>0) {
			size = colsO + rowsO-1 + colsO-1 + rowsO-2;
		}
		
		int[] tArray = new int[size];
		System.out.println("Size: " + size);
		
		int index = 0;
		for(int i=offset; i<cols; i++) {
			tArray[index++] = matrix.get(offset).get(i);
		}
		
		for(int i =1 + offset; i < rows; i++) {
			tArray[index++] = matrix.get(i).get(cols-1);
		}
		
		for(int i = cols-2; i>=offset; i--) {
			tArray[index++] = matrix.get(rows-1).get(i);
		}
		
		for(int i = rows-2; i>offset; i--) {
			tArray[index++] = matrix.get(i).get(offset);
		}


		for(int i : tArray) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		/*int pos = 0;
		
		for(int i=0; i<matrix.get(0).size(); i++) {
			System.out.println(matrix.get(0).get(i));
		}
		
		for(int i=0; i<matrix.size(); i++) {
			System.out.println(matrix.get(i).get(matrix.get(i).size()-1));
		}*/
		
	}

}
