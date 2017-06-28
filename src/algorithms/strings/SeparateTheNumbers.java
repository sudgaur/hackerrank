package algorithms.strings;

import java.math.BigInteger;
import java.util.Scanner;

public class SeparateTheNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        while (queries-- != 0) {
            String input = in.next();
            StringBuilder checkString = new StringBuilder();
            BigInteger firstNumber;
            for (int length = 1; length < input.length(); length++) {
                firstNumber = new BigInteger(input.substring(0, length));
                checkString = new StringBuilder();
                checkString.append(firstNumber.toString());
                BigInteger i = firstNumber;
                while (checkString.length() < input.length()) {
                    i = i.add(BigInteger.ONE);
                    checkString.append(i.toString());
                }
                if (checkString.toString().equals(input)) {
                    System.out.println("YES " + firstNumber);
                    break;
                }
            }
            if (!checkString.toString().equals(input))
                System.out.println("NO");
        }
        in.close();
    }

}
