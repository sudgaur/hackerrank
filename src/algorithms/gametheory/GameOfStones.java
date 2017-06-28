package algorithms.gametheory;

import java.util.Scanner;

public class GameOfStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            if (n % 7 == 0 || n % 7 == 1)
                System.out.println("Second");
            else
                System.out.println("First");
        }
        in.close();
    }

}
