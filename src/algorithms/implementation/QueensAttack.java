package algorithms.implementation;

import java.util.Scanner;

public class QueensAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int qx = in.nextInt();
        int qy = in.nextInt();
        int x, y, d;
        int up = n - qx, down = qx - 1, left = qy - 1, right = n - qy;
        int upright = Math.min(up, right), upleft = Math.min(up, left), downright = Math.min(down, right),
                downleft = Math.min(down, left);
        for (int i = 0; i < k; i++) {
            x = in.nextInt();
            y = in.nextInt();
            // same row
            if (x == qx) {
                if (y > qy) {
                    d = distance(qx, qy, x, y);
                    if (d < right)
                        right = d;
                } else {
                    d = distance(qx, qy, x, y);
                    if (d < left)
                        left = d;
                }

            }
            // same column
            if (y == qy) {
                if (x > qx) {
                    d = distance(qx, qy, x, y);
                    if (d < up)
                        up = d;
                } else {
                    d = distance(qx, qy, x, y);
                    if (d < down)
                        down = d;
                }
            }
            // diagonal
            if (Math.abs(qx - x) == Math.abs(qy - y)) {
                if (x > qx) {
                    if (y > qy) {
                        d = distance(qx, qy, x, y);
                        if (d < upright)
                            upright = d;
                    } else {
                        d = distance(qx, qy, x, y);
                        if (d < upleft)
                            upleft = d;
                    }
                } else {
                    if (y > qy) {
                        d = distance(qx, qy, x, y);
                        if (d < downright)
                            downright = d;
                    } else {
                        d = distance(qx, qy, x, y);
                        if (d < downleft)
                            downleft = d;
                    }
                }
            }
        }
        System.out.println(up + down + right + left + upright + upleft + downright + downleft);
        in.close();
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Math.abs(y1 - y2) - 1;
        }
        if (y1 == y2) {
            return Math.abs(x1 - x2) - 1;
        }
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            return Math.abs(x1 - x2) - 1;
        }
        return 0;
    }

}
