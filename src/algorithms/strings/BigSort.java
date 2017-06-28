package algorithms.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++)
            input[i] = in.next();
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                if (o1.length() < o2.length())
                    return -1;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) > o2.charAt(i))
                        return 1;
                    if (o1.charAt(i) < o2.charAt(i))
                        return -1;
                }
                return 0;
            }
        });
        for (int i = 0; i < n; i++)
            System.out.println(input[i]);
        in.close();
    }

}
