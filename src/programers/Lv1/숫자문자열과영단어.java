package src.programers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
    /*다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나,
은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다
. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.*/


    public static void main(String[] args) {
        String s = "one4seveneight";
        s="23four5six7";
//        System.out.println(s.contains("one"));


        System.out.println(solution(s));

//        System.out.println(s);
    }
    public static int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        int answer = 0;

        for (String k: map.keySet()) {
            if(s.contains(k)){
                s= s.replace(k , map.get(k));
            }
        }

        answer = Integer.valueOf(s);
        return answer;
    }
}
