package src.programers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class _2016년 {
    /*2016년 1월 1일은 금요일입니다.
     2016년 a월 b일은 무슨 요일일까요?
     두 수 a ,b를 입력받아 2016년 a월 b일이
     무슨 요일인지 리턴하는 함수, solution을 완성하세요.
     요일의 이름은 일요일부터 토요일까지 각각
     SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
     예를 들어 a=5, b=24라면 5월 24일은 화요일이므로
     문자열 "TUE"를 반환하세요.*/

    public static void main(String[] args) {
        // 1 월 1일은 금요일
        // 1월 31일까지 있으니
        // 일단 1월 부터 처리
//        int[] month ;
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"FRI");
        map.put(1,"SAT");
        map.put(2,"SUN");
        map.put(3,"MON"); // 며칠 추가 되었니 ? days % 7
        map.put(4,"TUE");
        map.put(5,"WED");
        map.put(6,"THU");

        // 1 월 2일이면?
        int days = 31 - 1;
        days %= 7; // => map 에서 value 찾기
//        System.out.println(map.get(days));

            // 2 월이면?
        System.out.println(solution(2,29));
    }
    public static String solution(int a, int b) {
        // 1월 1일이 금요일 윤년. 
        // 2월은 29일까지
        String answer = "";
        int days = 0;
        int[] month = {0, 31, 29, 31, 30, 31,30, 31,31,30,31,30,31};
        for (int i = 0; i < a; i++) { // 해당 월 전월 까지 날짜를 더함 => 그 월 1일로 맞춤
            days += month[i];
        }
        days += b-1; // 해당 월 1일 부터 며칠 지났는지 더함 ex) 3 월 10(b) 일 이면 9만큼 더함
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"FRI");
        map.put(1,"SAT");
        map.put(2,"SUN");
        map.put(3,"MON"); // 며칠 추가 되었니 ? days % 7
        map.put(4,"TUE");
        map.put(5,"WED");
        map.put(6,"THU");

        days %= 7;

        return map.get(days);
    }
}
