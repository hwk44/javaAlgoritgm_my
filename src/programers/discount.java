package src.programers;

import org.w3c.dom.ls.LSOutput;

public class discount {

    public static void main(String[] args) {
        System.out.println();
    }

    /*
     머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%,
      50만 원 이상 사면 20%를 할인해줍니다.
구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을
return 하도록 solution 함수를 완성해보세요.
    */

    public int solution(int price) {
        int answer = price;
        if(price >0 && price <= 100000) {
            answer = price;
        } else if (price <= 300000) {
            answer = (int) (price * 0.95);
        } else if (price <= 500000) {
            answer = (int) (price * 0.9);
        } else answer = (int) (price * 0.8);

        return answer;
    }

    /*머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지
     궁금해졌습니다. 머쓱이네 반 친구들의 키가 담긴 정수 배열 array와
      머쓱이의 키 height가 매개변수로 주어질 때,
     머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.
     */
    public int solution1(int[] array, int height) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > height) answer++;
        }
        return answer;
    }

    /*
    정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를
    곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
    */
    public int solution2(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <numbers.length ; j++) {
                if(i*j > answer) answer = i*j;

            }
            
        }
        return answer;
    }

      /*
     연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
     두 정수 num과 total이 주어집니다. 연속된 수 num개를 더한 값이 total이 될 때,
      정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요
     */


    public static  int[] solution3(int num, int total) {
        int[] answer = new int[num];
        int temp = total / num; // 중간 값
        int a0 = temp - num/2; //배열 맨 처음 들어갈 값(홀수 일때)


        if (num %2 ==0){ // 배열 갯수가 짝수면
            for (int i = 0; i < answer.length; i++) {
                answer[i] = ++a0;
            }
        } else if (num %2 ==1) { // 배열 갯수 홀수면
            for (int i = 0; i < answer.length ; i++) {
                answer[i] = a0++;
            }
        }
        return answer;
    }

    /*선분 3개가 평행하게 놓여 있습니다.
     세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열
      lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
     */
    public int solution(int[][] lines) {

        int answer = 0;
        for (int i = 0; i < lines.length; i++) {

        }
        return answer;
    }

}

