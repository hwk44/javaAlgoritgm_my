package src.programers.Lv1.solved;

public class 이상한문자열 {
    /*문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
     각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
     각 단어의 짝수번째 알파벳은 대문자로,
     홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

    제한 사항
    문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
    첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

    입출력 예
    s	return
    "try hello world"	"TrY HeLlO WoRlD"*/

    public static void main(String[] args) {

        String s = "return";
        char[] a = s.toCharArray(); // char 어레이를 만들고 s의 각 ch 를 받아옴
        System.out.println(a[0]);

        System.out.println(String.valueOf(a)); // 배열 값들을 문자열로 얻어옴

        System.out.println(solution("try hello world"));

    }
    public static String solution(String s ){
        String result = "";
        
        // 공백을 기준으로 인덱스를 나눠야함
        int idx = 0; // 문자열 순회 인덱스
        int flag = 0; // 문자열이 공백인지 체크 0 이면 공백x 1이면 공백
        int i = 0; // 단어의 인덱스

        while (true){

            // flag 처리 &
            if(String.valueOf(s.charAt(idx)).equals(" ")) flag = 1 ;
            else flag = 0;

            if (flag == 0){ // 공백이 아니면

                if(i % 2 == 0 ){ // 짝수 인덱스면 대문자
                 result = result.concat(String.valueOf(s.charAt(idx)).toUpperCase());
                 i ++;
                // 홀수 인덱스면 소문자
                }else {
                    result = result.concat(String.valueOf(s.charAt(idx)).toLowerCase());
                    i ++;
                }


            } else { // 공백이면?
                result = result.concat(" ");
                i = 0;
            }
            if (idx == s.length() - 1) break;
            //  다음 문자열 확인
            idx++;


        }
        
        
        
        // 이렇게 할 경우 단어별로 인덱스를 따뤄 나눠줘야함
//        for (int i = 0; i < s.length(); i++) {
//            // 짝수 인덱스는 대문자
//            if(i % 2 == 0 ){
//                 result = result.concat(String.valueOf(s.charAt(i)).toUpperCase());
//            // 홀수면 소문자
//            }else result = result.concat(String.valueOf(s.charAt(i)).toLowerCase());
//
//        }

        return  result;
    }

    // 프로그래머스 문제 풀이
    public String solution2(String s) {
        String answer;
        answer = s.toUpperCase();
        char[] chars = answer.toCharArray();

        //앞문자가 대문자라면 소문자로 치환
        for (int i = 1; i < chars.length; i++) {
            if (62 <= chars[i - 1] && chars[i - 1] <= 90) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        answer = String.valueOf(chars);   // 배열을 이렇게도 표현이 가능
        return answer;
    }
}
