package src.programers.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기 {

    /*문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
     각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
     예를 들어 strings가 ["sun", "bed", "car"]이고
    n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
    같은 문자면 사전순으로 정렬
    */

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        List<String> list1 = new ArrayList<>();
        for (String s : strings) {
            list1.add(s);
        }

        // 정렬하는
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) < o2.charAt(n)) return -1;
                else if (o1.charAt(n) > o2.charAt(n)) return 1;
                else return o1.compareTo(o2); // 인덱스 값이 같으면 사전 순으로
            }
        });
//        for (String s : list1) {
//            System.out.println(s);
//        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list1.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
//        char c = 'a';
//        System.out.println((char) 96 );
        //   ` : a 앞 문자열


//        String[] stirngs = {"sun", "bud", "car"};
        String[] stirngs = {"abce", "abcd", "cdx"};
        int i = 1 ;

        System.out.println(solution(stirngs,i));


//        String[] strings = {"sun", "bed", "car"};
//        List<String> s = new ArrayList<>();
//        int num = 1; // 주어진 정수
//        boolean f = true;
//        if("s">"a")

//        System.out.println("s" > "a");

    }
}
