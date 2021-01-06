package courses;

import java.util.Arrays;

public class Array {
//    public static int findMaxConsecutiveOnes(int[] nums){
//        int count = 0, max = 0;
//
//        for(int i : nums){
//            if(i == 1){
//                count++;
//            }else{
//                count = 0;
//            }
//            max = Math.max(max, count);
//        }
//        return max;
//    }
//
//    public static int findNumbers(int[] nums){
//        int count = 0;
//        for(int i : nums)
//            count += ((i+"").length() % 2 == 0) ? 1 : 0;
//        return count;
//    }
//
//    public static int[] sortedSquares(int[] A){
//        for(int i = 0; i < A.length; i++){
//            A[i]*=A[i];
//        }
//        Arrays.sort(A);
//        return A;
//    }
//
//    public static void duplicateZeros(int[] arr){
//        for (int i = arr.length-1; i >= 0; i--){
//            if(arr[i] == 0){
//                if (arr.length - 2 - i >= 0) System.arraycopy(arr, i + 1, arr,
//                        i + 1 + 1, arr.length - 2 - i);
////                for(int j = arr.length-2; j > i; j--){
////                    arr[j+1] = arr[j];
////                }
//                if(i < arr.length-1) arr[i+1] = 0;
//            }
//        }
//    }
//
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
////        for(int i = n-1; i >= 0; i--){ // loop for nums2
////            int j, last = nums1[m-1];
////            for(j = m-2; j >=0 && nums1[j] > nums2[i]; j--) {
////                nums1[j + 1] = nums1[j];
////                j = Math.max(j, 0);
////            }
////            if(j != m-2 || last > nums2[i]) {
////                nums1[j + 1] = nums2[i];
////                nums2[i] = last;
////            }
////        }
////
////        int i = n-1, j = m-2;
////        while (i > -1){ // loop for nums2
////            int last = nums1[m-1];
////            while(j > -1 && nums1[j] > nums2[i]) {
////                nums1[j + 1] = nums1[j];
////            }
////            if(j != m-2 || last > nums2[i]) {
////                nums1[j + 1] = nums2[i];
////                nums2[i] = last;
////            }
////            i--;
////        }
////        System.arraycopy(nums2, 0, nums1, m, n);
//
////        int[] arr = new int[m+n];
////        int i = 0;
////        for (i = 0; i < m; i++) {
////            arr[i] = nums1[i];
////        }
////
////        for (int item : nums2){
////            if(i < arr.length) arr[i] = item;
////            i++;
////        }
////        Arrays.sort(arr);
////        System.arraycopy(arr, 0, nums1, 0, nums1.length);
//        if ( nums1.length == (m+n))
//        {
//            int j =0;
//            for ( int i = nums1.length - n; i < nums1.length; i++)
//            {
//                nums1[i] = nums2[j];
//                j++;
//            }
//        }
//        Arrays.sort(nums1);
//    }
//
//    public static int removeElement(int[] nums, int val){
//        int size = nums.length;
//
//
//        for(int i = size-1; i >= 0; i--){
//            if(nums[i] == val){
//                nums[i] = nums[size-1];
//                nums[size-1] = val;
//                size--;
//            }
//        }
//
////        for (int j = 0; j < nums.length; ++j) {
////            if (nums[j] != val) {
////                nums[i] = nums[j];
////                i++;
////            }
////
////        }
//
//        return size;
//    }
//
//    public static int removeDuplicates(int[] nums){
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }

    public static  boolean checkIfExist(int[] arr){
        for (int k : arr) {
            for (int i = 1; i < arr.length; i++) {
                if (k != 0 && arr[i] != 0){
                    if((double) arr[i] / (double) k == 2 ||
                            (double) k / (double) arr[i] == 2) return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] args){
        int[] A = new int[]{0,0};
//        int[] B = new int[]{2,5,6};
//        int val = 2;
//        merge(A, 3, B, 3);

        pln("Old length: " + A.length);
//        System.out.println("New length: " + removeDuplicates(A));
//            for(int i : A)
                p(checkIfExist(A));
    }

    public static void pln(Object o){
        System.out.println(o);
    }

    public static void p(Object o){
        System.out.print(o);
    }
}
