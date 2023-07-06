package src.programers.Lv1.solved;

public class 시저암호 {

    /*어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
      문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.*/
    public static void main(String[] args) {
//        System.out.println((int)'z'); // 아스키 코드 122
//        System.out.println((int)'a'); // 아스키 코드 97
//
//        int a = 91; // [ 의 아스키 코드값
//        char a1 = (char) a;
//        for (int i = 0; i < 6; i++) {
//            System.out.println((char) (a+i));
//        }
////        System.out.println(a1);
//        System.out.println((int)'Z'); // 아스키 코드 90
//        System.out.println((int)'A'); // 아스키 코드 65

        solution("Answ  erZ", 5);

    }
    public static String solution(String s, int n) {
        String answer = "";

        char[] c = s.toCharArray(); // s 문자열을 char 배열로 가져옴
        for (char ch: c) {
            int temp = (int) ch;// ch의 아스키 코드값
//            int temp = (int) ch +n; // n 만큼 미는 곳의 아스키 코드값

            // 대문자의 경우
            if(temp >= 65 && temp <= 90){
                temp += n;
                if (temp > 90) temp -= 26;
            }
            if(temp >= 97 && temp <= 122){ // 소문자의 경우
                temp += n;
                if (temp > 122) temp -= 26;
            }
            answer += String.valueOf((char)(temp));


        }

        System.out.println(answer);
        return answer;
    }

}
