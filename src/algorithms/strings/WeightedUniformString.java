package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Set<Integer> possibleWeights = new HashSet<Integer>();
        char[] a = input.toCharArray();
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            char firstCharacter = a[i];
            while (i + 1 < a.length && a[i + 1] == firstCharacter) {
                possibleWeights.add(((int) firstCharacter - 96) * count);
                i++;
                count++;
            }
            possibleWeights.add(((int) firstCharacter - 96) * count);
        }
        int queries = in.nextInt();
        while (queries-- != 0) {
            int n = in.nextInt();
            if (possibleWeights.contains(n))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        in.close();
    }

}
