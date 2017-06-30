package algorithms.sorting;

import java.util.Scanner;

public class Quicksort4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            arr1[i] = arr[i];
        }
        System.out.println(insertionsort(arr1) - quicksort(arr, 0, n - 1));
        in.close();
    }

    private static int quicksort(int[] arr, int start, int end) {
        if (start >= end)
            return 0;
        int pivot = arr[end];
        int current = start;
        int swaps = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
                current++;
                swaps++;
            }
        }
        int temp = arr[current];
        arr[current] = arr[end];
        arr[end] = temp;
        swaps++;
        swaps += quicksort(arr, start, current - 1);
        return swaps + quicksort(arr, current + 1, end);
    }

    private static int insertionsort(int[] a) {
        int shifts = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    shifts++;
                }
            }
        }
        return shifts;
    }
}
