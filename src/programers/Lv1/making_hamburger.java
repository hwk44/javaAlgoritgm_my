package src.programers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class making_hamburger {

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        for (int e : ingredient) {
                st.add(e);

            if (st.size() >= 4){
                if ((st.get(st.size()- 4) ==1)
                        &&(st.get(st.size()-3) ==2)
                        &&(st.get(st.size()-2) ==3)
                        &&(st.get(st.size()-1) ==1)){
                    answer++;
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                }

            }
        }
        return answer;
    }
}
