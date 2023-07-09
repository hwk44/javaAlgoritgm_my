package src.programers.Lv1.solved;

import java.util.Arrays;

/*
없는 숫자 더하기
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가
매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아
더한 수를 return 하도록 solution 함수를 완성해주세요.
* */
public class sum_of_not_found {
    public static void main(String[] args) {
//        int[] numbers = {1,2,3,4,6,7,8,0};
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));
        System.out.println(sol_Stream(numbers));
    }
    public static int solution(int[] numbers) {
        int answer = 45; // 0 ~ 9 합

        int sum = 0;
        for (int e : numbers) { // 배열의 합
            sum += e;
        }
        return answer- sum; // 두개 차이 리턴
    }

    // 스트림을 이용한 풀이
    public  static int sol_Stream(int[] numbers) {
        return 45- Arrays.stream(numbers).sum();
    }
}
