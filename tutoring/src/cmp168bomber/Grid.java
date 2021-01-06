package cmp168bomber;

//import java.util.ArrayList;
//import java.util.Collections;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Grid {

    private boolean[][] bombGrid;
    private int[][] countGrid;
    private int numRows;
    private int numColumns;
    private int numBombs;

    public Grid() {
        this.numRows = 10;
        this.numColumns = 10;
        this.numBombs = 25;
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns) {
        numRows = rows;
        numColumns = columns;
        numBombs = 25;
        createBombGrid();
        createCountGrid();
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
    }

    public Grid(int rows, int columns, int numBombs) {
        numRows = rows;
        numColumns = columns;
        this.numBombs = numBombs;
        createBombGrid();
        createCountGrid();
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
    }


    private void createBombGrid() {
        bombGrid = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                bombGrid[i][j] = false; // This will create a grid that has all cells as false.
            }
        }

        // Set the bombs
        int x = 0;
        int y = 0;
        for (int i = 0; i < numBombs; i++) { // Set the bombs randomly in the grid. 25
            do {
                x = genrandom(numRows); // generate a location
                y = genrandom(numColumns);

            } while (bombGrid[x][y]); // When the mine is already set.


            bombGrid[x][y] = true; // Set a mine at that location.
        }
    }

    public int genrandom(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }

//	  Collections.shuffle(list);
//	  for (int i = 0; i < numBombs; i++) {
//	        int number = (list.get(i));
//	        int row = new Integer(number / numColumns);
//	        int column = new Integer(number % numColumns);
//
//	        bombGrid[row][column] = true;
//	  }
//	  
//  }

    private void createCountGrid() { //
        countGrid = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                countGrid[i][j] += getCountAtLocation(i, j); // [0][0] // increment whenever there is a bomb adjacent to that location.
                //if()
                countGrid[i][j-1] += getCountAtLocation(i, j); //[x][0]// left
                countGrid[i][j+1] += getCountAtLocation(i, j); // [0][1] right
                countGrid[i-1][j] += getCountAtLocation(i, j); // top
                countGrid[i+1][j] += getCountAtLocation(i, j); // bottom
                countGrid[i-1][j-1] += getCountAtLocation(i, j); // top-left
                countGrid[i-1][j+1] += getCountAtLocation(i, j); // top-right
                countGrid[i+1][j-1] += getCountAtLocation(i, j); // bottom-left
                countGrid[i-1][j-1] += getCountAtLocation(i, j); // bottom-right
            }
        }
    }

    public boolean IsBombAtLocation(int row, int column) {
        return (bombGrid[row][column]); // return true or false
    }


    public int getNumRows() {
        return numRows;
    }

    public int getNumBombs() {

        return numBombs;

    }

    public int getNumColumns() {

        return numColumns;
    }

    public boolean[][] getBombGrid() {
        boolean[][] copy = new boolean[numRows][numColumns];
        IntStream.range(0, bombGrid.length).forEach(i -> System.arraycopy(bombGrid[i], 0, copy[i], 0, bombGrid[i].length));
        return copy;
    }


    public int[][] getCountGrid() {
        int[][] result = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(countGrid[i], 0, result[i], 0, countGrid[i].length);
        }
        return result;
    }

    public int getCountAtLocation(int row, int column) {
        int count = 0;
        if (IsBombAtLocation(row, column)) {
            count++;
        }

        if (row + 1 < numRows) {
            if (IsBombAtLocation(row + 1, column))
                count++;
            if (column + 1 < numColumns) {
                if (IsBombAtLocation(row + 1, column + 1))
                    count++;
            }

            if (column - 1 >= 0) { // check for all columns except first column
                if (IsBombAtLocation(row + 1, column - 1)) // Add count by 1 if element at next row,previous column is a bomb
                    count++;
            }

            if (row - 1 >= 0) { // check for all rows except first row
                if (IsBombAtLocation(row - 1, column)) // Add count by 1 if element at next row,same column is a bomb
                    count++;
                if (column - 1 >= 0) { // check for all columns except first column
                    if (IsBombAtLocation(row - 1, column - 1)) // Add count by 1 if element at previous row,previous column
                        // is a bomb
                        count++;
                }

                if (column + 1 < numColumns) { // check for all columns except last column
                    if (IsBombAtLocation(row - 1, column + 1)) // Add count by 1 if element at previous row,next column is a
                        // bomb
                        count++;
                }


                if (column + 1 < numColumns) { // check for all columns except last column
                    if (IsBombAtLocation(row, column + 1)) // Add count by 1 if element at same row,next column is a bomb
                        count++;
                }

                if (column - 1 >= 0) { // check for all columns except first column
                    if (IsBombAtLocation(row, column - 1)) // Add count by 1 if element at same row,previous column is a bomb
                        count++;
                }

            }
        }
        return count;
    }

}
	 
  
  
  

  
