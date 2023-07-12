package src.stream;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.stream.Collectors;

public class List_to_List {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        // 문자열을 각각 char[] 로 만들어서 List 저장
        List<char[]> char_list = list.stream().map(s -> s.toCharArray()).collect(Collectors.toList());

        /* 이렇게 출력하면
         배열객체.toString 이 되어서 주소값을 반환함
        [C@aa3ab7a9 [C@d3e3ead4 [C@bc767027 [C@ac523d1d [C@a0f22760
        */
        // 비교
        // int[] a = {1, 2,3 ,4, 5,6 ,7};
        // System.out.println(a.toString());

        for (char[] c : char_list) {
            System.out.print(c.toString() + " ");
        } 
        System.out.println("\n"+"--".repeat(20));

        // 배열을 출력할 때는 Arrays.toString 사용
        // [a] [b] [c] [d] [e]
        for (char[] c : char_list) {
            System.out.print(Arrays.toString(c) + " ");
        }

        System.out.println("\n"+"--".repeat(20));

        List<Character> char_list2 = list.stream().map(s -> s.charAt(0)).collect(Collectors.toList());

        // 위와 같은 기능을 하는 코드
//        List<Character> char_list2 = list.stream().map(s -> s.charAt(0)).toList();

        // a b c d e 
        for (char c : char_list2) {
            System.out.print(c + " ");
        }
        System.out.println("\n"+"--".repeat(20));

        List<Integer> num_list = new ArrayList<>();
        num_list.add(1);
        num_list.add(2);
        num_list.add(2);
        num_list.add(4);
        num_list.add(4);
        num_list.add(1);
        num_list.add(7);
        num_list.add(10);
        num_list.add(10);
        num_list.add(9);
        num_list.add(13);
        num_list.add(21);

        // 6 이상 숫자 필터 
        List<Integer> filter =num_list.stream().filter(i -> i >= 6).collect(Collectors.toList());

        // 6 이상 숫자 필터 / 중복 허용
        // 7 10 10 9 13 21
        for (int e :filter) {
            System.out.print(e + " ");
        }
        System.out.println("\n"+"--".repeat(20));

        // 스트림 + 출력 한번에
        System.out.println(
                num_list.stream()
                .filter(i-> i >= 6)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );

//        System.out.println(num_list.stream()
//                .filter(i-> i >= 6)
//                .map(String::valueOf)); // stream.map() 의 결과는 stream 이다.
//
//        System.out.println("\n"+"--".repeat(20));


        System.out.println("\n"+"--".repeat(20));

        List<Integer> filter2 =num_list.stream().filter(i -> i < 6).distinct().toList();

        // 6 미만 숫자 필터 / 중복 제거
        // 1 2 4
        for (int e :filter2) {
            System.out.print(e + " ");
        }
        System.out.println("\n"+"--".repeat(20));


        // 필터 / 중복제거 / 맵 / joining / 출력
        System.out.println(
                num_list.stream()
                .filter(i -> i<6)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
        System.out.println("\n"+"--".repeat(20));


    }
}
