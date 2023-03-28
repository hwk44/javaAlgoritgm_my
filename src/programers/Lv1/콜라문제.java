package src.programers.Lv1;

public class 콜라문제 {

    /*문제 설명
오래전 유행했던 콜라 문제가 있습니다. 콜라 문제의 지문은 다음과 같습니다.

정답은 아무에게도 말하지 마세요.
콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다.
빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.

문제를 풀던 상빈이는 콜라 문제의 완벽한 해답을 찾았습니다.
상빈이가 푼 방법은 아래 그림과 같습니다.
 우선 콜라 빈 병 20병을 가져가서 10병을 받습니다.
 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다.
  5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고,
또 2병을 모두 마신 뒤 가져가서 1병을 받습니다.
받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤
가져가면 1병을 또 받을 수 있습니다. 이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.*/

    /* 빈 병 a개를 주면 콜라 b 병을 준다.
    * 이 문제는 빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때,
    * 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다.
    * 기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면,
    *  추가적으로 빈 병을 받을 순 없습니다.*/
    public static int solution(int a, int b, int n) { 
        // a개로 나누고 나머지 == > 빈병
        // a개로 나눈 몫*b ==> 받을 콜라수

        // 빈병 a개 주면 콜라 b개 받음 보유중인 빈병은 n개임 몇개 받을수있을까??
//        int answer = 0;
        int coke = (n/a)*b; // 처음 받을 콜라병. 보유한 콜라가 됨.
        int answer = coke;
        int empty = n%a; // 나머지 0개

        while(coke > a) { // 10 갠데 거기서 
            coke = coke/a; // a 개로 나눈 몫 몇개 더 줄수 있는가?

        }
        if(coke/a == 0) {// 나누어 떨어지면 다 먹고 빈병 만들기
            empty += coke;
            coke = 0;

        }else{ // 남으면?

        }
        System.out.println("coke = " + coke);
        System.out.println("empty = " + empty);

       /* while(n>a){ // 빈병이 a 보다 크면 a주고 콜라 받기
            n -= a;       // 보유한 빈병 빈병에 a개 줌
            coke += b;    // 콜라 b 개 받음
            answer += b; 
            while(coke >= a) { // 콜라가 좀 많이 남으면
                coke -=a; // a개 만큼 먹고
                n+=a; // 빈병 a개 채움
            }
        }
*/
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(2,1,20));
    }
}
