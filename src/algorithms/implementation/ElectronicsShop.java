package algorithms.implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ElectronicsShop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer keyboards[] = new Integer[n];
        int drives[] = new int[m];
        for (int i = 0; i < n; i++) {
            keyboards[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            drives[i] = in.nextInt();
        }
        
        Arrays.sort(keyboards, Collections.reverseOrder());
        Arrays.sort(drives);
        
        int result = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(keyboards[i] + drives[j] > s)
                    break;
                if(keyboards[i] + drives[j] > result)
                    result = keyboards[i] + drives[j];
            }
        }
        System.out.println(result);
        in.close();
    }

}
