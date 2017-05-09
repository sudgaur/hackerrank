package algorithms.implementation;

import java.util.Scanner;

public class AlmostSorted {

    public static boolean isSorted(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }

    public static int countDips(int a[]) {
        int dips = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                dips++;
        }
        return dips;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        if (isSorted(a)) {
            System.out.println("yes");
        } else {
            int dips = countDips(a);
            if (dips == 1) {
                // must be a swap condition
                int index = 0;
                for (int i = 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        index = i;
                        break;
                    }
                }
                int temp = a[index];
                a[index] = a[index - 1];
                a[index - 1] = temp;
                if (isSorted(a)) {
                    System.out.println("yes");
                    System.out.println("swap " + index + " " + Integer.toString(index + 1));
                } else {
                    System.out.println("no");
                }
            } else if (dips == 2) {
                int firstIndex = 0, secondIndex = 0;
                boolean first = true;
                for (int i = 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        if (first) {
                            firstIndex = i - 1;
                            first = false;
                        } else {
                            secondIndex = i;
                        }
                    }
                }
                int temp = a[firstIndex];
                a[firstIndex++] = a[secondIndex];
                a[secondIndex++] = temp;
                if (isSorted(a)) {
                    System.out.println("yes");
                    System.out.println("swap " + firstIndex + " " + secondIndex);
                } else
                    System.out.println("no");
            } else {
                int firstIndex = 0, secondIndex = 0;
                for (int i = 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        firstIndex = i - 1;
                        while (i < n && a[i] < a[i - 1])
                            i++;
                        secondIndex = i - 1;
                        reverse(a, firstIndex, secondIndex);
                        if (isSorted(a)) {
                            System.out.println("yes");
                            System.out.println("reverse " + Integer.toString(firstIndex + 1) + " "
                                    + Integer.toString(secondIndex + 1));
                        } else
                            System.out.println("no");
                        break;
                    }
                }
            }
        }
        in.close();
    }

    public static void reverse(int[] a, int begin, int end) {
        while (begin < end) {
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
            begin++;
            end--;
        }
    }

}
