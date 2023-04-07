package src.programers.LV0;
/* 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
    피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기
    위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
    n	    result
    7	    1
    1	    1
    15	    3
*/
public class pizza1 {

    public static void main(String[] args) {
        System.out.println(solution(7));
    }
    public static int solution(int n){
        // n 사람 수. 피자를 한조각 이상 먹어야 함 피자의 갯수는?
        int answer = 0;
        while(n > 0){
            answer += n / 7; // 몫 7 일때 1 14 일때 2 15일때 2
            if( (n % 7) != 0) {
                answer++; // 나머지 저장 나머지가 7보다 작으면 하나 더 주문 해야함
                n = 0;
            }else break;
        }
        return answer;
    }

    public static int solution2(int n){
        // 프로그래머스 클린코드
        return n%7 == 0 ? n/7 : n/7+1;
    }
}
   
