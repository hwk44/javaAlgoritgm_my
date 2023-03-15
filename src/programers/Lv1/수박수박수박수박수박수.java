package src.programers.Lv1;

public class 수박수박수박수박수박수 {

    /*문제 설명
길이가 n이고, "수박수박수박수...."와
 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
  예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

제한 조건
n	return
3	"수박수"
4	"수박수박
*/

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) sb.append("수");// 짝수면
            else sb.append("박");
        }
        return sb.toString();
    }
}
