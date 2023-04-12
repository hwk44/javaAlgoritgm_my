package src.programers.LV0;

import java.util.Arrays;

public class 짝수는싫어요 {

    /*정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로
     담긴 배열을 return 하도록 solution 함수를 완성해주세요.*/
    public static int[] solution(int n) {
        int i = 0;
        if (n%2 == 0) {// 짝수면
            int[] answer = new int[n/2];
            int index = 0;
            while(i <= n) {
                if(i%2 != 0) answer[index++] = i++; // 홀수면 값 저장
                i++;
            }
            return answer;
        }else{ // 홀수면
            int index= 0;
            int[] answer = new int[n/2 + 1];
            while (i <= n ) {
                if(i%2 != 0) answer[index++]  = i++;
                i++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(solution(101)));
    }
}
