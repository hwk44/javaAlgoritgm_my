package src.programers.Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 가장가까운같은글자 {
    /*문자열 s가 주어졌을 때, s의 각
    위치마다 자신보다 앞에 나왔으면서,
     자신과 가장 가까운 곳에 있는 같은 글자가
     어디 있는지 알고 싶습니다.
    예를 들어, s="banana"라고 할 때,
    각 글자들을 왼쪽부터 오른쪽으로 읽어
    나가면서 다음과 같이 진행할 수 있습니다.*/

    public static void main(String[] args) {

        // map 으로 문자열과 인트값 지정. 처음엔 -1
        Map<Character, Integer > map = new HashMap<>();
        String s = "foobar";
        List a = new ArrayList();
        for (int i = 0; i < s.length(); i++) { // map 에 값이 없으면
            if (map.get(s.charAt(i)) == null) {
                a.add(-1); // 배열에 -1 넣음
                map.put(s.charAt(i), i); // 인덱스 값을 밸류로 받음

            }else { // map 에 값있으면
                a.add(i - map.get(s.charAt(i)));
                map.put(s.charAt(i), i); // 밸류값 바꾸고

            }
            
        }
//        int[] result = a.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = a.stream()
                .mapToInt(i -> (int) i)
                .toArray();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
//        a.toArray();
//        System.out.println(arr2.toString());
    }

}
