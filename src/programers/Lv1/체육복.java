package src.programers.Lv1;

import java.util.*;

public class 체육복 {
    /*
     * 전체 학생의 수 n, 체육복을 도난당한
     * 학생들의 번호가 담긴 배열 lost, 여벌의
     * 체육복을 가져온 학생들의 번호가 담긴 배열
     *  reserve가 매개변수로 주어질 때, 체육수업을 들을 수
     * 있는 학생의 최댓값을 return 하도록 solution
     * 함수를 작성해주세요.*/

    public static int solution(int n, int[] lost, int[] reserve) {


        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> list_reserve = new ArrayList<>();
        List<Integer> list_lost = new ArrayList<>();

        for (int i : lost) {
            list_lost.add(i); // lost 어레이 리스트로
        }
        for (int i : reserve) {
            list_reserve.add(i); // lost 어레이 리스트로
        }

        for (int j = 0; j < list_lost.size(); j++) {
            for (int i = 0; i < list_reserve.size(); i++) {
                if(list_reserve.get(i) + 1 == list_lost.get(j) || list_reserve.get(i) - 1 == list_lost.get(j) ) {
                    list_reserve.remove(list_reserve.get(i));
                    list_lost.remove(list_lost.get(j));
                }
            }
        }
        return n-list_lost.size();
    }
    public static void main(String[] args) {
        System.out.println();
//        int n = 5;
//        int[] lost = {2,4};
//        int[] reverse = {1,3,5};
//        // 배열 정렬
//        Arrays.sort(lost);
//        Arrays.sort(reverse);
//
//        List<Integer> list_reverse = new ArrayList<>();
//        List<Integer> list_lost = new ArrayList<>();
//
//        for (int i : lost) {
//            list_lost.add(i); // lost 어레이 리스트로
//        }
//        for (int i : reverse) {
//            list_reverse.add(i); // lost 어레이 리스트로
//        }
//
//        for (int j = 0; j < list_lost.size(); j++) {
//            for (int i = 0; i < list_reverse.size(); i++) {
//                if(list_reverse.get(i) + 1 == list_lost.get(j) || list_reverse.get(i) - 1 == list_lost.get(j) ) {
//                    list_reverse.remove(list_reverse.get(i));
//                    list_lost.remove(list_lost.get(j));
//                }
//            }
//        }
//        System.out.println(n- list_lost.size());


    }
}
