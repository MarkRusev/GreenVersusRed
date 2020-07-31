package com.mentormate.markrusev;

import java.util.Scanner;
//all logic class
public class Generation {
   private int[][] matrix;
   private int rows;
   private int columns;
   private Scanner input=new Scanner(System.in);
   
   //constructor,and passing values to the matrix
   public Generation(int columns,int rows) {
          this.columns=columns;
          this.rows=rows;
          matrix=new int[this.rows][this.columns];
}

//inputing generation zero
public void generationZeroState() {
	for (int row = 0; row < this.rows; row++) {
		for (int col = 0; col < this.columns; col++) {
			matrix[row][col]=input.nextInt();
		}
	}
}
   //method that helps me iterate through the matrix
private boolean isTheCellGreen(int row,int col) {
	return this.matrix[row][col] == 1 || this.matrix[row][col] == 10;

}
//method,in which is all the logic
   public int countGenerationsWhereCellIsGreen(int column,int row,int numberOfGenerations) {
	   //main counter,who counts the generations in which the cell is green
	   int counter=0;
	   
	   //first loop is for the generations
	   for (int igen = 0; igen <= numberOfGenerations; igen++) {
		   //if the cell (0,1) in our case is green,if yes counter ++
		   int isGivenCellGreen= this.matrix[row][column];
		    if(isGivenCellGreen==1) {
			counter++;
		    }
		    //other nested loop to iterate through the matrix and check the count of green neighbors
		    for (int i = 0; i < this.rows; i++) {
		    	
				for (int j = 0; j < this.columns; j++) {
					//counter,which counts the green neighbors
					int greenCounter=0; 
					
					//if cell equals 1,then current cell is green,if not it is red
					boolean isCurrentCellGreen = matrix[i][j]==1;
					boolean isCurrentCellRed = matrix[i][j]==0;
					//positions that help me iterate easier through the matrix
					int upperRow=i-1;
					int lowerRow=i+1;
					int leftColumn=j-1;
					int rightColumn=j+1;
					
					//boolean conditions for good coding practice
					boolean isUpperRowExisting = upperRow >= 0;
					boolean isLowerRowExisting = lowerRow < this.rows;
					boolean isLeftColumnExisting = leftColumn >= 0;
					boolean isRightColumnExisting = rightColumn < this.columns;
					
					
					//check if upper row exists
					if(isUpperRowExisting) {
						//checking up left diagonal 
						if(isLeftColumnExisting && isTheCellGreen(upperRow,leftColumn)) {
							greenCounter++;
						}
						//checking up right diagonal
						if(isRightColumnExisting && isTheCellGreen(upperRow,rightColumn)) {
							greenCounter++;
						}
						//checking the cell above
						if(isTheCellGreen(upperRow,j)) {
							greenCounter++;
						}
					}
					//if lower row exists,get in the body 
					if(isLowerRowExisting) {
						//lower left diagonal
					   if(isLeftColumnExisting && isTheCellGreen(lowerRow,leftColumn)) {
						greenCounter++;
					   }
					   //lower right diagonal
					   if(isRightColumnExisting && isTheCellGreen(lowerRow,rightColumn)) {
						greenCounter++;
					   }
					   //if the cell under the current is green
					   if(isTheCellGreen(lowerRow,j)) {
						greenCounter++;
					   }
					}
					
					//checking if the cell to the left is green
					if(isLeftColumnExisting && isTheCellGreen(i,leftColumn)) {
						greenCounter++;
					}
					//checking if the cell to the right is green
					if(isRightColumnExisting && isTheCellGreen(i,rightColumn)) {
						greenCounter++;
					}
					
					//if the cell is green and if it has 0,1,4,5,7 or 8 green neighbors ,make it equal to 10 ,and then we will get to
					//nextGeneration method,in which we check if the cell equals 10 and if true make it 0 (or red)
				if(isCurrentCellGreen) {
						if(greenCounter==0 || greenCounter==1 || greenCounter==4 || greenCounter==5 || greenCounter==7|| greenCounter==8) {
							this.matrix[i][j]=10;
							
						}
				}
				
				//if the cell is red and if it has 3 or 6 green neighbors,make it equal to 11,and then we will get to
				//nextGeneration method,in which we check if the cell equals 11 and if true make it 1 (or green)
				if(isCurrentCellRed) {
					if(greenCounter==3 || greenCounter==6) {
						this.matrix[i][j]=11;
						
					}
				}
			}
				
		}
		    //calling nextGeneration method,see what it does below..
		    nextGeneration();
	} 
	   //returning the final result
	   return counter;
   }
   
 //this method is helping with setting the values for the next generation,if the cell equals 11,make it equal to 1 (green),and
 //if the cell equals 10,make it equal to 0 (red)
   private void nextGeneration() {
   	
   	for (int row = 0; row < this.rows; row++) {
   		
   		for (int col = 0; col < this.columns; col++) {
   			int cell = this.matrix[row][col];
   			//if cell equals 11 , then make it equal to 1 (green)
   			if(cell == 11) {
   				this.matrix[row][col]=1;
   			}
   			//if cell equals 10,then make it equal to 0 (red)
   			if(cell == 10) {
   				this.matrix[row][col]=0;
   		    }
   			
   		}
   	 }
  }


	
}
