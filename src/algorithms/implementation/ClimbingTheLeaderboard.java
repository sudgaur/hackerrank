package algorithms.implementation;

import java.util.Scanner;

public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int scores[] = new int[n];
        int ranks[] = new int[n];
        ranks[0] = 1;
        scores[0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            scores[i] = in.nextInt();
            if (scores[i] < scores[i - 1])
                ranks[i] = ranks[i - 1] + 1;
            else
                ranks[i] = ranks[i - 1];
        }
        int m = in.nextInt();
        int alice[] = new int[m];
        for (int i = 0; i < m; i++)
            alice[i] = in.nextInt();
        int currentRank = ranks[n - 1] + 1;
        for (int i = 0, j = n - 1; i < m; i++) {
            for (; j >= 0; j--) {
                if (alice[i] < scores[j])
                    break;
                if (alice[i] >= scores[j])
                    currentRank = ranks[j];
            }
            System.out.println(currentRank);
        }
        in.close();
    }

}
