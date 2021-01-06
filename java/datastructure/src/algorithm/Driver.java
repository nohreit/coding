package algorithm;

import algorithm.sorting.tree.HeapException;
import algorithm.sorting.tree.HeapSort;
import algorithm.sorting.tree.MaxHeap;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String [] args) throws HeapException {
        execute();
    }

    private static void execute() throws HeapException {
        // List of code execution
//        Recursive.run();
//        System.out.println(shiftedDiff("cofee", "eecoff"));
//        for (int i: withdraw(970)) {
//            ArrayManip.p(i+" " );
//        }

//        System.out.println(numberToOrdinal(0));
//        System.out.println(sjf(Arrays.asList(10,10,10,10),3));
        myHeap();
    }

    public static void myHeap() throws HeapException {
        Integer[] arr = new Integer[]{13, 18, 41, 75, 21, 30};
        //		MergeSort ms= new MergeSort();
        HeapSort<Integer> hs= new HeapSort<>();
//		System.out.println("merge sort");
//		ms.sort(arr);
        System.out.println("before sorting: 13, 18, 41, 75, 21, 30");
//		System.out.println();
        System.out.println("heap sort");

        MaxHeap<Integer> mh = new MaxHeap<>();


    }



    public static int shiftedDiff(String first, String second){
        if(first.length() != first.length()) return -1;
        for (int i = 0; i < second.length(); i++){
            if(first.equals(second)) return i;
            first = first.charAt(first.length()-1)+first.substring(0, first.length()-1);
        }
        return -1;
    }

    public static int[] withdraw(int amount){
        int[] bills = new int[3];

        if(amount < 40 || amount > 1000) return new int[]{0, 0, 0};

        if(((amount / 10) % 10) % 2 == 0){
            bills[0] = (amount / 100);
            if(((amount % 100) % 50) % 20 == 0) {
                bills[1] = (amount % 100) / 50;
                bills[2] = (amount % 50) / 20;
            }
            else{
                bills[1] = 0;
                bills[2] = (amount % 100) / 20;
            }
        }else{
            bills[0] = (amount - 50) / 100;
            bills[1] = 1;
            bills[2] = ((amount - 50) % 100) / 20;
        }

        return bills;
    }

    public static String numberToOrdinal(Integer number){
        String ordinal = null;
        if(number > 0 && number <= 10000){
            if(number % 100 == 11 || number % 100 == 12 || number % 100 == 13){
                ordinal = number+"th";
            }else{
                switch (number % 10){
                    case 1:
                        ordinal = number+"st";
                        break;
                    case 2:
                        ordinal = number+"nd";
                        break;
                    case 3:
                        ordinal = number+"rd";
                        break;
                    default:
                        ordinal = number+"th";
                }
            }
            return ordinal;
        }
        return String.valueOf(number);
    }

    public static Integer sjf(List<Integer> jobs, Integer index){
        Integer target = jobs.get(index);
        for (int i = 0; i < jobs.size(); i++){
            if(jobs.get(i).compareTo(jobs.get(index)) < 0)
                target += jobs.get(i);
            else if(jobs.get(i).equals(jobs.get(index))) {
                if (i < index)
                    target += jobs.get(i);
            }
        }
        return target;
    }

//    public static Integer decode( String roman){
//        int[] deci = {1000, 500, 100, 50, 10 , 5, 1};
//        int[] roma = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
//        Integer decimal;
//
//        for (int i = 0; i < roman.length(); i++) {
//            switch (roman.charAt(i)){
//                case 'M':
//                    decimal +=
//                    break;
//                case 'D':
//
//                    break;
//                case 'C':
//
//                    break;
//                case 'L':
//
//                    break;
//                case 'X':
//
//                    break;
//                case 'V':
//
//                    break;
//                case 'I':
//
//                    break;
//            }
//        }
//
//
//        //A symbol placed after another of equal or greater value adds its value
//
//        //A symbol placed before one of greater value subtracts its value
//
//    }

    public static void pln(Object o){
        System.out.println(o);
    }

    public static void p(Object o){
        System.out.print(o);
    }
}
