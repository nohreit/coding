package cmp168bomber;

public class Test {

    public static void main(String[] args) {
        Grid minesweep = new Grid();

        int rows = minesweep.getNumRows();

        int cols = minesweep.getNumColumns();

        boolean[][] bombgrid = minesweep.getBombGrid();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(bombgrid[i][j] ? "T" : "F");

            }

            System.out.println("");

        }

        System.out.println("");

        int[][] countgrid = minesweep.getCountGrid();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(countgrid[i][j] + "");

            }

            System.out.println("");

        }
    }
}


