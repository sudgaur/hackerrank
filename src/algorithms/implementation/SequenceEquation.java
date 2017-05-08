package algorithms.implementation;

import java.util.Scanner;

public class SequenceEquation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int input;
        int index[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input = in.nextInt();
            index[input] = i;
        }
        in.close();
        for (int x = 1; x <= n; x++) {
            System.out.println(index[index[x]]);
        }
    }

}
