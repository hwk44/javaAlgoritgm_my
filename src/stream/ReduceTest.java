package src.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {
    public static void main(String[] args) {

        String[] greetings = {"안녕하세요~~~~~", "hello", "good morning", "반갑습니다."};

        // 길이가 가장 긴 문자열 확인 영어 한글 혼합이라 getBytes().length 로 길이 확인
        System.out.println(           // reduce("기본값", BinaryOperator 의 apply 메서드 구현부)
                Arrays.stream(greetings).reduce("",(s1,s2) ->{
                    if(s1.getBytes().length >= s2.getBytes().length) return s1;
                    else return s2;
                })
        );

        // 방법 2 BinaryOperator 클래스로 직접 구현
        // reduce 부분에 초기값을 넣지 않음
        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);
    }


}
class CompareString implements BinaryOperator<String>{
    @Override
    public String apply(String s1, String s2) {
        if(s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
}
