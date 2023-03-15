package src.programers.Lv1;

public class 문자열다루기기본 {

    /*문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수
    , solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고
    "1234"라면 True를 리턴하면 됩니다.
        제한 사항
        입출력 예
        s	return
        "a234"	false
        "1234"	true
*/

    public static void main(String[] args) {
        char a = '0'; // 49
        char b = '9'; // 57
//        char c = '4'; // 57

        System.out.println((int) a);
        System.out.println((int) b);

    }
    public static boolean solution(String s) {
        if(s.length() !=4 || s.length() !=6){
            return false;
        }
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < 48 || s.charAt(i) > 57 ) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
