package src.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 잃어버린괄호 {
/*세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다.
그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고,
 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고,
  5자리보다 많이 연속되는 숫자는 없다.
 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.*/


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] sarr = s.split("-"); // 빼기로 스플릿

        int[] sum = new int[sarr.length];

        for (int i = 0; i < sum.length; i++) {
            if(!sarr[i].contains("+")) sum[i] = Integer.valueOf(sarr[i]); // + 기호 없으면 그 값을 저장
            else { // 있으면?
                String[] temps = sarr[i].split("\\+"); // + 기호로 한번더 스플릿
                int sum_temps = 0;
                for (int j = 0; j < temps.length; j++) {
                    sum[i]+= Integer.valueOf(temps[j]); // 정수값들을 다 더해서 저장
                }
//                sum[i] = sum_temps;
            }
        }
        int result = sum[0];
        // 배열이 하나짜리면
//        if(sum.length > 1){
        for (int i = 1; i < sum.length; i++) {
            result -= sum[i];
         }
//        }
        System.out.println(result);



    }
}
