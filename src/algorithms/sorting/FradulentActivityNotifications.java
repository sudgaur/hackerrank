package algorithms.sorting;

import java.util.Scanner;

public class FradulentActivityNotifications {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int notifications = 0;
        int counts[] = new int[201];
        for (int i = 0; i < 201; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < d; i++) {
            counts[a[i]]++;
        }
        for (int i = d; i < n; i++) {
            double median = getMedian(counts, d);
            if (a[i] >= 2 * median)
                notifications++;
            counts[a[i]]++;
            counts[a[i - d]]--;
        }
        System.out.println(notifications);
        in.close();
    }

    private static double getMedian(int counts[], int d) {
        int sum = 0;
        if (d % 2 == 1) {
            for (int i = 0; i < 201; i++) {
                if (sum < (d + 1) / 2)
                    sum += counts[i];
                else
                    return i - 1;
            }
        } else {
            for (int i = 0; i < 201; i++) {
                if (sum < d / 2)
                    sum += counts[i];
                else if (sum == d / 2) {
                    int first = i - 1;
                    while (counts[i] == 0) {
                        i++;
                    }
                    return (first + i) / 2.0;
                } else {
                    return i - 1;
                }
            }
        }
        return 0;
    }
}
