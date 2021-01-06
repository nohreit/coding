package codes;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main (String [] args){
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter the Celsius Temperature as a decimal: ");
        double celsius = scnr.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.printf(" %.2f C = %.2f F ", celsius, fahrenheit);

    }
}
