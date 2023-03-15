package src.programers;

public class 문자열반복출력 {

    /*
    문자열 my_string 과 정수 n이 매개변수로 주어질 때,
     my_string 에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록
     solution 함수를 완성해보세요.
     */
    public static void main(String[] args) {
        String s = "hello";
        StringBuilder st = new StringBuilder();

        st.append(s.charAt(0));
        st.append(s.charAt(0));
        st.append(s.charAt(0));
        System.out.println(st);

    }
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st.append(st.charAt(i));
        }

        return answer;
    }
}
