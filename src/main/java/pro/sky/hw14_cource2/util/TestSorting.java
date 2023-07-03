package pro.sky.hw14_cource2.util;

import java.util.Arrays;
import java.util.Random;

public class TestSorting {
    public static void main(String[] args) {
        //binarySearch
        Integer array[] = {1, 2, 4, 10, 14, 28, 32, 56, 60};
        System.out.println(binarySearch(28, 0, array.length-1, array));

        //sorting
        Random random = new Random();
        int arr[] = random.ints(100000, 0, 10000).toArray();
        int arr1[] = Arrays.copyOf(arr, 100000);
        int arr2[] = Arrays.copyOf(arr, 100000);
        int arr3[] = Arrays.copyOf(arr, 100000);

        long t1 = System.currentTimeMillis();
        selectionSorting(arr1);
        System.out.println("Selection sorting: " + (System.currentTimeMillis() - t1) + " millisec");

        t1 = System.currentTimeMillis();
        insertionSorting(arr2);
        System.out.println("Insertion sorting: " + (System.currentTimeMillis() - t1) + " millisec");

        t1 = System.currentTimeMillis();
        bubbleSorting(arr3);
        System.out.println("Bubble sorting: " + (System.currentTimeMillis() - t1) + " millisec");

    }
    public static int[] bubbleSorting(int[] arr){
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length-j-1; i++) {
                if(arr[i] > arr[i+1])
                    swapElements(arr, i, i+1);
            }
        }
        return  arr;
    }

    public static int[] selectionSorting(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int indexOfMax = 0;
            int max = arr[indexOfMax];
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > max){
                    max = arr[j];
                    indexOfMax=j;
                }
            }
            swapElements(arr, arr.length-1-i, indexOfMax);
        }
        return arr;
    }

    public static int[] insertionSorting(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static int binarySearch(Integer num, int begin, int end, Integer[] arr) {
        if (num < arr[begin] || num > arr[end]){
            return -1;
        }
        int mid = (begin + end)/2; //
        if (arr[mid] == num){
            return mid;
        }
        if (arr[mid] < num){
            return binarySearch(num, mid + 1, end, arr);
        }
        return binarySearch(num, begin, mid, arr);
    }
}