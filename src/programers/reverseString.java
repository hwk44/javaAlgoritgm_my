package programers;

import java.util.Arrays;
// 주어진 문자열을 반대로 출력
public class reverseString {
    public static void main(String[] args) {

//        for (int i = 1; i < 10; i++) {
//            if(i%3 == 0) {
//
//            }
//            else {
//                System.out.println( i +"는 3의 배수가 아닙니다.");
//            }
//        }

        String str = new String("jaron");
        String answer = "";
        String[] arr =  str.split("");
        System.out.println(Arrays.toString(arr));
//        System.out.println(str);

        StringBuilder st = new StringBuilder();

        // 방법 1 하나씩 잘라서 넣기
//        String answer = "";
//        for (int i = arr.length-1; i >= 0; i--) {
//            st.append(arr[i]);
//        }

        // 통째로 넣고 뒤집기
        st.append(str);
        st.reverse();
        System.out.println(st);

        for(int i= str.length()-1; i>=0; i--){
            answer+=str.charAt(i);
        }
        System.out.println(answer);

    }
}
