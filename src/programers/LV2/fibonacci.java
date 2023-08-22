package src.programers.LV2;

import java.math.BigInteger;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(solution(100));
    }

    public static BigInteger solution(int n) {

        BigInteger[] fibo = new BigInteger[100_001];

        fibo[0] = BigInteger.valueOf(0);
        fibo[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
           (fibo[i]) = fibo[i-1].add(fibo[i-2]) ;
        }

        return  (fibo[n].mod(BigInteger.valueOf(1234567)));
    }
}
