package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MinimumLoss {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long price;
        List<Flat> list = new ArrayList<Flat>();
        for (int i = 1; i <= n; i++) {
            price = in.nextLong();
            list.add(new Flat(price, i));
        }
        in.close();
        Collections.sort(list, new FlatComparator());
        long minLoss = Long.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).price - list.get(i - 1).price < minLoss && list.get(i).year < list.get(i - 1).year)
                minLoss = list.get(i).price - list.get(i - 1).price;
        }
        System.out.println(minLoss);
    }

}

class Flat {
    long price;
    int year;

    public Flat(long x, int y) {
        price = x;
        year = y;
    }
}

class FlatComparator implements Comparator<Flat> {

    @Override
    public int compare(Flat o1, Flat o2) {
        if (o1.price < o2.price)
            return -1;
        if (o1.price == o2.price)
            return 0;
        return 1;
    }

}
