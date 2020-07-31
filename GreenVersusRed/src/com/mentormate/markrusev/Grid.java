package com.mentormate.markrusev;

import java.util.Scanner;

public class Grid {
	//width and height for the grid of the matrix
	private int width;
	private int height;
	//N means number of generations
	private int N;
	//coordinates for the cell
	private int x,y;
	//scanner object,for using the input from the keyboard
	private Scanner input = new Scanner(System.in);
	
	//method to set the grid of the game
	private void setGrid() {
		do {
			System.out.println("Enter the number of columns for the matrix(1-999): ");
			this.width = input.nextInt();
		}
		while(width < 1 || width > 999);
		do {
			System.out.println("Enter the number of rows for the matrix(1-999): ");
			this.height = input.nextInt();
		}
		while(height < 1 || height > 999);
	}
	
	//method to set the coordinates of the cell
	private void sayCoordinatesOfTheCell() {
		System.out.println("Coordinates(y,x: )");
		y=input.nextInt();
		x=input.nextInt();
		System.out.println("Number of generations: ");
		N=input.nextInt();
		
		if(x < 0 || y < 0 || N < 0) {
			throw new IllegalArgumentException();
		}
	}
	//method in which i call the above methods,inputting the matrix and returning the final answer
	public void start() {
		setGrid();
		//making Generation object,and setting the matrix with the parameters width and height
		Generation generation = new Generation(width,height);
		//calling generationZeroState() method,which allows to input the initial state 
		generation.generationZeroState();
		sayCoordinatesOfTheCell();
		int answer = generation.countGenerationsWhereCellIsGreen(y,x,N);
		System.out.println("Result: "+ answer);
		
		
		
	}

	

}
