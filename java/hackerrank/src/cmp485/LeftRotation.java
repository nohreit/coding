package cmp485;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        int d = 1;
        List<Integer> arr = Arrays.asList(1,2,3,4,5);


        List<Integer> result = rotateLeft(d, arr);

        for(int i : result){
            p(i+" ");
        }
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
//        for (int n = 0; n < d; n++) {
//            int e = arr.get(0);
//            for (int i = 0; i < arr.size()-1; i++)
//                arr.set(i, arr.get(i + 1));
//            arr.set(arr.size() - 1, e);
//        }

        Collections.rotate(arr, -d);
        return arr;
    }

    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
