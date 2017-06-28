package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class GridlandMetro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        int k = in.nextInt();
        long answer = m * n;
        int r, c1, c2;
        HashMap<Integer, ArrayList<Interval>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            r = in.nextInt();
            c1 = in.nextInt();
            c2 = in.nextInt();
            if (map.get(r) == null) {
                ArrayList<Interval> list = new ArrayList<>();
                list.add(new Interval(c1, c2));
                map.put(r, list);
            } else {
                ArrayList<Interval> list = map.get(r);
                list.add(new Interval(c1, c2));
                map.put(r, list);
            }
        }
        for (ArrayList<Interval> list : map.values()) {
            if (list.size() == 1) {
                Interval only = list.get(0);
                answer = answer - (only.getEnd() - only.getStart() + 1);
                continue;
            }
            Collections.sort(list, new IntervalComparator());
            Interval first = list.get(0);
            int start = first.getStart();
            int end = first.getEnd();
            ArrayList<Interval> mergedList = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                Interval current = list.get(i);
                if (current.getStart() <= end) {
                    end = Math.max(end, current.getEnd());
                } else {
                    mergedList.add(new Interval(start, end));
                    start = current.getStart();
                    end = current.getEnd();
                }
            }
            mergedList.add(new Interval(start, end));
            for (Interval i : mergedList) {
                System.out.println("start " + i.getStart() + " end " + i.getEnd());
                answer = answer - (i.getEnd() - i.getStart() + 1);
            }
        }
        System.out.println(answer);
        in.close();
    }

}

class Interval {
    int start, end;

    public Interval() {

    }

    public Interval(int x, int y) {
        start = x;
        end = y;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.getStart() - o2.getStart();
    }

}
