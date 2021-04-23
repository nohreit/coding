package cmp485;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SalesByMatch {

    public static void main(String[] args) {
        int[] socks = new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20};
        pln("Number of pair: "+ stockMerchant(socks.length, socks));
    }

    public static int stockMerchant(int n, int[] ar) {
        Set<Integer> oddSocks = new HashSet<>();
        int pairs = 0;
        for(int sock : ar) {
            if(oddSocks.contains(sock)) {
                oddSocks.remove(sock);
                pairs++;
            } else {
                oddSocks.add(sock);
            }
        }
        return pairs;
}

    public static void p(Object o) {
        System.out.print(o);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
