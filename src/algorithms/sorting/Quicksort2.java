package algorithms.sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        quicksort(list);
        in.close();
    }

    private static void quicksort(ArrayList<Integer> list) {
        if (list.size() < 2)
            return;
        int pivot = list.get(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot)
                left.add(list.get(i));
            else
                right.add(list.get(i));
        }
        quicksort(left);
        quicksort(right);
        list.clear();
        list.addAll(left);
        list.add(pivot);
        list.addAll(right);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
