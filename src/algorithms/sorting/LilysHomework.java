package algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LilysHomework {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        int[] reverseList = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
            reverseList[n - 1 - i] = list[i];
        }
        System.out.println(Math.min(solution(list), solution(reverseList)));
        in.close();

    }

    private static int solution(int[] list) {
        int swaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sortedList[] = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            sortedList[i] = list[i];
            map.put(list[i], i);
        }
        Arrays.sort(sortedList);
        for (int i = 0; i < list.length; i++) {
            int currentValue = list[i];
            int sortedValue = sortedList[i];
            if (currentValue != sortedValue) {
                swaps++;
                int currentIndex = map.get(currentValue);
                int sortedIndex = map.get(sortedValue);
                int temp = list[currentIndex];
                list[currentIndex] = list[sortedIndex];
                list[sortedIndex] = temp;
                map.put(currentValue, sortedIndex);
                map.put(sortedValue, currentIndex);
            }
        }
        return swaps;
    }

}
