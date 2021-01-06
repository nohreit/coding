package codes;

import java.util.Scanner;

public class SecondsConverter {
    public static void main(String[] args) {
        int seconds,temp, h,m,s;
        Scanner scnr = new Scanner (System.in);

        System.out.print("Enter the number of seconds: ");
        seconds = scnr.nextInt();
        temp = seconds;

        s = seconds%60;
        seconds/=60;

        m = seconds%60;
        h = seconds/60;

        System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds",temp,h,m,s);
        System.out.printf("\n%d seconds = %02dh:%02dm:%02ds\n",temp,h,m,s);
    }
}
