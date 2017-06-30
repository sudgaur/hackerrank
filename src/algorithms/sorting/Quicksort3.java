package algorithms.sorting;

import java.util.Scanner;

public class Quicksort3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quicksort(arr, 0, n - 1);
        in.close();
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[end];
        int current = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
                current++;
            }
        }
        int temp = arr[current];
        arr[current] = arr[end];
        arr[end] = temp;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quicksort(arr, start, current - 1);
        quicksort(arr, current + 1, end);
    }
}
