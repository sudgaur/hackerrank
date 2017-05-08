package algorithms.implementation;

import java.util.Scanner;

public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int max = 0;
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
            if (input[i] > max)
                max = input[i];
        }
        if (max <= k)
            System.out.println(0);
        else
            System.out.println(max - k);
        in.close();
    }
}
