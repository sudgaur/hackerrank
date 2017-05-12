package algorithms.greedy;

import java.util.Scanner;

public class GoodlandElectricity {

    public static void main(String[] args) {
        boolean possible = true;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int range = in.nextInt();
        range--;
        boolean hasTower[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 1)
                hasTower[i] = true;
        }
        in.close();
        int count = 0;
        boolean isCovered[] = new boolean[n];
        boolean isOn[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isCovered[i]) {
                for (int j = (i + range < n ? i + range : n - 1); j >= (i - range < 0 ? 0 : i - range); j--) {
                    if (hasTower[j]) {
                        isOn[j] = true;
                        for (int k = (j - range < 0 ? 0 : j - range); k <= (j + range < n ? j + range : n - 1); k++)
                            isCovered[k] = true;
                        count++;
                        break;
                    }
                }
            }
            if (!isCovered[i]) {
                possible = false;
                break;
            }
        }
        if (!possible)
            System.out.println("-1");
        else
            System.out.println(count);

    }

}
