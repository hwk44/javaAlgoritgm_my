package src.programers.Lv1.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
//        System.out.println(st.peek());
//        st.push(1);
//        st.push(2);
//        System.out.println(st.contains(1));
//
//        System.out.println(st.search(1));
//        System.out.println(st.toString());
        int[] a = {1, 1, 1, 3, 3, 0, 1, 1};
        int[] b = {4, 4, 4, 3, 3};
        int[] c = {4, 4, 5, 5, 5, 5, 4, 3, 3, 1, 2, 2, 1, 1, 1, 3, 3, 4, 4, 7, 7, 7,};
        System.out.println(solution(a));
        solution(b);
        solution(c);

        System.out.println("------------------------------");
        solution2(a);

    }


    public static Object[] solution(int[] arr) {
        int[] answer = {};
//        List<Integer> l1 = new ArrayList<>();
        Stack<Integer> st1 = new Stack<>();

        int idx = 0; // 스텍 인덱스
        st1.push(arr[0]);
        for (int i = 0; i < arr.length; i++) {

            // 스텍 피크 값과 현재 값이랑 비교. 같으면 패스 다르면 넣기
            if (!(st1.peek() == arr[i])) {
                st1.push(arr[i]);
            }
        }
//        System.out.println(st1.toString());
        Object[] b = st1.toArray();

        return b;
    }
    /*
* 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
*  이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
*  단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
*  예를 들면,
arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다*/

    
    // 프로그래머스 다른사람 풀이
    public  static int[] solution2(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) { // 중복제거 for  문

            if (arr[i] != arr[i - 1])
                list.add(arr[i]);
        }
//        System.out.println(list.toString());
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) { // 어레이 리스트를 배열로 그대로 가져옴
            answer[i] = list.get(i);
        }
        return answer;
    }
}
