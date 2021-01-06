package algorithm;

import java.util.Scanner;

public class Recursive {
    public static int factorial(int n){
        if( n < 0 ) throw new ArithmeticException("Negative value forbidden");
        return ( n == 0 || n == 1 ) ? 1 : n * factorial( n - 1 );
    }

    public static void run(){
        Scanner input = new Scanner(System.in);
        int i, f;
        pln("Factorial calculator\nEnter an integer: ");
        i = input.nextInt();

        pln(i+"! = "+factorial(i));
    }

    public static void pln(Object o){ System.out.println(o); }
    public static void p(Object o){ System.out.print(o); }
}
