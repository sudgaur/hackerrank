package algorithms.greedy;

import java.util.Scanner;

public class LargestPermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int swaps = in.nextInt();
        int x;
        int[] input = new int[n + 1];
        int[] index = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x = in.nextInt();
            input[i] = x;
            index[x] = i;
        }
        if (swaps >= n) {
            for (int i = n; i > 0; i--)
                System.out.print(i + " ");
        } else {
            for (int i = 1; i <= n && swaps > 0; i++) {
                if (input[i] == n - i + 1)
                    continue;
                int a = index[n - i + 1];
                int b = input[i];
                int temp = input[i];
                input[i] = n - i + 1;
                input[a] = temp;
                index[n - i + 1] = i;
                index[b] = a;
                swaps--;

            }
            for (int i = 1; i <= n; i++)
                System.out.print(input[i] + " ");

        }
        in.close();
    }
}
