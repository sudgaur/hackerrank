package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarcsCakewalk {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        long miles = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            miles += Math.pow(2, i) * a[n - 1 - i];
        }
        System.out.println(miles);
        in.close();
    }

}
