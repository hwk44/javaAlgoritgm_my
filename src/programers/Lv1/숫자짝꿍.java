package src.programers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 숫자짝꿍 {

    public static void main(String[] args) {
        String x= "5525";
        String y= "1255";
//        String y= "203045";
//        String y= "123450";

        System.out.println(solution(x,y));
    }
    public static String solution(String X, String Y) {
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();

        List<Character> clist = new ArrayList<>();
        Arrays.sort(x); // x 정렬

        for (int i = 0; i < y.length; i++) {
            int start = 0;
            int end = x.length-1;
            int middle = (start+end)/2;
//            target => y[i] // 이진탐색
            while (start <= end){
                if(y[i] == x[middle]) {
                    clist.add(y[i]);
                    break;
                }
                if (y[i] < x[middle]){
                    end = middle -1;
                    middle = (start+end)/2;
                }else {
                    start= middle +1;
                    middle = (start+end)/2;
                }
            }
        }
        if (clist.size() == 0) return "-1";
        Collections.sort(clist);
//        for (int i = 0; i < clist.size(); i++) {
//            System.out.println(clist.get(i));
//        }
        if(clist.get(clist.size()-1) =='0') return "0"; // '0'밖에 없을 때
        StringBuilder sb = new StringBuilder();
        for (int i = clist.size()-1; i >= 0; i--) {
            sb.append(clist.get(i));
        }
        return sb.toString();
    }

}
