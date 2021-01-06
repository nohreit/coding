package codes;

import java.util.Scanner;

public class Triangle {
    public static void main(String [] args) {
        Scanner jin = new Scanner(System.in);
        int row = 0;
        boolean isWrong = true;
        while(isWrong) { // isWrong == true; thus this loops as long as the if statement is not true;
            System.out.println("Please enter a number 1...9 : ");
            row = jin.nextInt();
            if(row <= 9 && row >= 1) isWrong = false; // if it is true then isWrong == false and we get out
        }

        for(int i = 1; i <= row; i++){ // loop working on each row

            for(int j = 1; j <= (row - i) * 2; j++){ // add spaces before printing the number for each row
                System.out.print(" ");
            }

            for(int k = i; k >= 1; k--){ // counts backward row-- where row > 0
                System.out.print(" " + k);
            }

            System.out.println(); // ends each row
        }
    }
}
