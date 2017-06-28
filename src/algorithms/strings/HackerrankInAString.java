package algorithms.strings;

import java.util.Scanner;

public class HackerrankInAString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        while (queries-- != 0) {
            String input = in.next();
            String hack = "hackerrank";
            int j = 0;
            char[] a = input.toCharArray();
            char[] b = hack.toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (a[i] == b[j])
                    j++;
                if (j == 10) {
                    System.out.println("YES");
                    break;
                }
            }
            if (j != 10)
                System.out.println("NO");
        }
        in.close();

    }

}
