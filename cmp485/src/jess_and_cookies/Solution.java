package jess_and_cookies;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        
        Arrays.sort(A);

        int count = 0;


        do {

            if (A[0] >= k) return count;
            else if(A.length == 1 && A[0] < k) return -1;

            int sweetness = A[0] + 2 * A[1];

            int[] B = A;

            A = new int[A.length-1];

            System.arraycopy(B, 2, A, 0, B.length-2);

            A[A.length-1] = sweetness;

            count++;

            Arrays.sort(A);

        } while (A[0] < k);

        return count;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0].trim());
//
//        int k = Integer.parseInt(nk[1].trim());
//
//        int[] A = new int[n];
//
//        String[] AItems = scanner.nextLine().split(" ");
//
//        for (int AItr = 0; AItr < n; AItr++) {
//            int AItem = Integer.parseInt(AItems[AItr].trim());
//            A[AItr] = AItem;
//        }
//
        int result = cookies(106, new int[]{1, 2, 3, 9, 10, 12});

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}