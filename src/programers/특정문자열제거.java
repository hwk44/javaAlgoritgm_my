package src.programers;

public class 특정문자열제거 {

    /*
    문제 설명
    문자열 my_string 과 문자 letter 이 매개변수로 주어집니다.
    my_string 에서 letter 를 제거한 문자열을 return 하도록 solution 함수를 완성해주세요.
    */

    public static void main(String[] args) {
        System.out.println(solution("abcdef","f"));
    }
    public static String solution(String my_string, String letter) {

        StringBuilder st = new StringBuilder();
        String answer = my_string.replace(letter, "");
        return answer;
    }
}
