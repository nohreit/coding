package camel_case;

import java.util.List;
import java.util.Scanner;

public class Solution {

    static int camelcase(String s) {
        if(s.length() == 0) return 0;

        int counter = 1;

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90)
                counter++;
        }
        return counter;
    }

    public static void main(String [] args){
        pln(camelcase(""));
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
