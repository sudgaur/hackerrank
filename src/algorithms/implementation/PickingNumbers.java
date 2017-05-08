package algorithms.implementation;

import java.util.Scanner;

public class PickingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int input[] = new int[n];
        int lookup[] = new int[100];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
            lookup[input[i]]++;
        }
        int max = 0;
        for (int i = 0; i < 99; i++) {
            if (lookup[i] + lookup[i + 1] > max)
                max = lookup[i] + lookup[i + 1];
        }
        System.out.println(max);
        in.close();
    }
}
