package cmp167;

import java.util.Scanner;

public class
Grades {
    public static int readGrades(int[] grades) {

        Scanner scnr = new Scanner(System.in);

        int grade; //variable that will get a grade from the user.
        int count = 0; // Number of grades.

        do {
            pln("Enter a grade: ");

            grade = scnr.nextInt(); // get the input from the use

            if (grade >= 0) {
                grades[count] = grade; // Assign the grade to the first index of the array.
                count++; // Increment each time a grade is added.
            }

        } while (grade > -1);

        return count;
    }

    public static int sum(int[] arr) {

        int results = 0;

        for (int x : arr) {
            results += x;
        }

        return results;
    }


    public static int sum(int[] arr, int firstIndex, int lastIndex) {
        // First and last index should be between 0 and array.length-1

        if (firstIndex < 0 || firstIndex >= arr.length) {
            return -666;
        }

        if (lastIndex < 0 || lastIndex >= arr.length) {
            return -666;
        }

        if (firstIndex > lastIndex) {
            return -666;
        }


        int sum = 0;

        for (int n = firstIndex; n <= lastIndex; n++) {
            sum += arr[n];
        }

        return sum;
    }

    public static double average(int[] arr) {
        return 1d * sum(arr) / arr.length;
    }

    public static int maxValue(int[] arr) {
        int maxi = arr[0];

        for (int y : arr) {
            maxi = Math.max(maxi, y);
        }

        return maxi;
    }

    public static int maxValue(int[] arr, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || firstIndex >= arr.length) {
            return -666;
        }

        if (lastIndex < 0 || lastIndex >= arr.length) {
            return -666;
        }

        if (firstIndex > lastIndex) {
            return -666;
        }

        int maxi = arr[firstIndex];
        for (int n = firstIndex; n <= lastIndex; n++) {
            maxi = Math.max(arr[n], maxi);
        }
        return maxi;
    }

    public static int indexOfFirstMaxValue(int[] arr) {
        int maxi = maxValue(arr);
        for (int n = 0; n < arr.length; n++) {
            if (arr[n] == maxi) {
                return n;
            }
        }
        return 0;
    }

    public static int minValue(int[] arr) {
        int mini = arr[0];
        for (int y : arr) {
            mini = Math.min(mini, y);
        }
        return mini;
    }

    public static int minValue(int[] arr, int firstIndex, int lastIndex) {

        if (firstIndex < 0 || firstIndex >= arr.length) {
            return -666;
        }

        if (lastIndex < 0 || lastIndex >= arr.length) {
            return -666;
        }

        if (firstIndex > lastIndex) {
            return -666;
        }

        int mini = arr[firstIndex];

        for (int n = firstIndex; n <= lastIndex; n++) {
            mini = Math.min(arr[n], mini);
        }

        return mini;
    }

    public static int indexOfFirstMinValue(int[] arr) {
        int m = minValue(arr);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == m) {
                return i;
            }
        }

        return 0;
    }

    public static int numberOfBelowAverageElements(int[] arr) {

        double avg = average(arr);
        int counterB = 0;

        for (int x : arr) {

            if (x < avg) {
                counterB++;
            }
        }

        return counterB;
    }

    public static int numberOfAboveAverageElements(int[] arr) {

        double avg = average(arr);
        int counterA = 0;

        for (int x : arr) {

            if (x > avg) {
                counterA++;
            }
        }

        return counterA;
    }

    public static void rotateElements(int[] arr) { // Rotate right
        int e = arr[arr.length - 1];

        // we start from the last index to 1
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = e;
    }

    public static void rotateElements(int[] arr, int rotationCount) {

        for (int n = 0; n < rotationCount; n++) {
            rotateElements(arr);
        }
    }

    public static void reverseArray(int[] arr) {

        for (int n = 0; n < arr.length / 2; n++) {

            int rev = arr[n];

            arr[n] = arr[arr.length - n - 1];
            arr[arr.length - n - 1] = rev;
        }
    }

    public static void main(String[] args) {
        boolean answer = true;
        do {
            int numberOfGrade = 0;
            int[] cmp = new int[100];

            numberOfGrade = readGrades(cmp);

            if (numberOfGrade != 0) {
                int[] temp = cmp;
                cmp = new int[numberOfGrade];

                for (int i = 0; i < cmp.length; i++) {
                    cmp[i] = temp[i];
                }

                pln("Number of grades: " + numberOfGrade);
                pln("Maximum grade: " + maxValue(cmp)); // int max = maxValue(cmp);
                pln("Minimum grade: " + minValue(cmp));
                pln("");

            } else {
                answer = false;
            }
        } while (answer);

    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
