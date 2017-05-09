package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        while (queries-- != 0) {
            boolean isPossible = true;
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int types[] = new int[n];
            int containers[] = new int[n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    containers[i] += matrix[i][j];
                    types[j] += matrix[i][j];
                }
            Arrays.sort(types);
            Arrays.sort(containers);
            for (int i = 0; i < n; i++) {
                if (types[i] != containers[i]) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                System.out.println("Possible");
            } else
                System.out.println("Impossible");
        }
        in.close();
    }

}
