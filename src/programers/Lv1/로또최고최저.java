package src.programers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또최고최저 {

    /*순위	당첨 내용
1	6개 번호가 모두 일치
2	5개 번호가 일치
3	4개 번호가 일치
4	3개 번호가 일치
5	2개 번호가 일치
6(낙첨)	그 외

lottos	                win_nums	                result
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	    [3, 5]
[0, 0, 0, 0, 0, 0]	    [38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]*/

    // 최저 순위. 0 을 아무것도 못맞추는 숫자라 가정하면 최저 순위
    // 최고 순위 0 을 모두 맞춘다고 가정하면 됨
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        // 답 확인
        for (int i : solution(lottos, win_nums)) {
            System.out.print(" "+i);
        }
    }
    public static int[] solution(int[] lottos, int[] win_nums) {

        // lottos 에  0 이 몇개인가?
        int cnt0 = 0;
        for (int i : lottos) {
            if(i == 0) cnt0++;
        }

        // 순위 맵
        Map<Integer, Integer> rank  = new HashMap<>(); // 맞춘 갯수 : 랭크
        rank.put(6,1);
        rank.put(5,2);
        rank.put(4,3);
        rank.put(3,4);
        rank.put(2,5);
        rank.put(1,6); // NullPointerException 때문에 
        rank.put(0,6); // 2개 추가


        // 두 배열 비교 몇개가 일치하는지 확인
        int count =0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) count++;
            }
        }
        // 기존 랭크
        int low_rank = rank.get(count);
        // 0이 모두 일치할때 랭크
        int high_rank = rank.get(count+cnt0);

        int[] answer = { high_rank, low_rank};
        return answer;
    }
}
