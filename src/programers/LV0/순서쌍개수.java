package src.programers.LV0;

/*
순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
 자연수 n이 매개변수로 주어질 때 두숫자의 곱이 n인 자연수 순서쌍의 개수를
 return 하도록 solution 함수를 완성해주세요.
 예시
 n	 result
20	  6
100	  9
 */
public class 순서쌍개수 {
    // n = 6 (1,6) (2,3) (3,2) (6,1)
    // n = 10 (1,10) (2,5)
    // n = 20 (1, 20) (2,10) (4,5) // 5,4
    public int solution(int n) {// 숫자곱이 n 인 순서쌍의 개수
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0) answer++;
        }
        return answer;
    }
}
