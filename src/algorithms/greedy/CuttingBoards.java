package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CuttingBoards {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        int mod = 1000000007;
        while (queries-- != 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            List<Cut> list = new ArrayList<Cut>();
            for (int i = 1; i < m; i++) {
                list.add(new Cut(in.nextInt(), true));
            }
            for (int i = 1; i < n; i++) {
                list.add(new Cut(in.nextInt(), false));
            }
            Collections.sort(list, new Comparator<Cut>() {

                @Override
                public int compare(Cut o1, Cut o2) {
                    return o2.price - o1.price;
                }
            });
            long horizontalCuts = 1, verticalCuts = 1;
            long result = 0;
            for (Cut c : list) {
                if (c.type)
                    horizontalCuts++;
                else
                    verticalCuts++;
                result = result + (c.type ? verticalCuts * (long) c.price : horizontalCuts * (long) c.price);
                result = result % mod;
            }
            System.out.println(result);
        }
        in.close();
    }
}

class Cut {
    int price;
    boolean type; // true for horizontal, false for vertical

    public Cut(int x, boolean y) {
        price = x;
        type = y;
    }
}
