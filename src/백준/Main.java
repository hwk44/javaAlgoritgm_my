package src.백준;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a0 = sc.nextInt();
        int a1 = sc.nextInt();
//        int g = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

//        int temp = f(a0, a1, n0);

        double n_temp = (double) a1 / (c - a0);
//        System.out.println(n_temp);
        if(c <= a0) System.out.println(0);
        else if (n_temp <= n0) System.out.println(1);
        else if (n_temp > 0 && n_temp <= n0) System.out.println(1);
//        else System.out.println(0);
    }

    public static int f(int a0, int a1, int n) {
        return a0 * n + a1;
    }

}
