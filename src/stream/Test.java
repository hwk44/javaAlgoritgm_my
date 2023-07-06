package src.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 스트림 자료의 대상
 * */
public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5,};

        // 스트림 생성
        IntStream stream = Arrays.stream(arr);

        // 스트림 소모
        int sum = stream.sum();
        System.out.println(sum);

       /* // 이미 쓰인 스트림을 다시 사용하려면 에러발생
        int count = (int)stream.count();
        System.out.println(count);
       */

        List<String> slist = new ArrayList<String>();
        slist.add("Tomas");
        slist.add("James");
        slist.add("Park");
        slist.add("Bob");
        slist.add("Anna");

        // 스트림 생성
        Stream<String> stream2 = slist.stream();

        // 람다로 구현 & 스트림 소모
        stream2.forEach(s -> System.out.print(s + " "));
        // Tomas James Park Bob Anna
        System.out.println();

        // 새로운 스트림 생성 & 소모
        // comparable 객체를 오름차순 정렬
        slist.stream().sorted().forEach(s -> System.out.print(s + " "));
    }
}
