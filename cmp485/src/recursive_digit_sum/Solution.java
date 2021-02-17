package recursive_digit_sum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        int p = Integer.parseInt(n);
        if(n.length() == 1) return Integer.parseInt(n);
        else if (k == 0) return p;


        for (int i = 0; i < n.length(); i++){
            p += Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        superDigit(String.valueOf(p), --k);
        return p;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        String[] nk = scanner.nextLine().split(" ");

//        String n = nk[0];

//        int k = Integer.parseInt(nk[1]);

//        int result = superDigit(n, k);
        int result = superDigit("1234", 4);

//        pln("1234".charAt(0));
        pln(result);

    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}