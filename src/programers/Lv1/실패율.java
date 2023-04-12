package src.programers.Lv1;

import java.util.*;

public class 실패율 {

    /*
    전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 
    스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 
    높은 스테이지부터 내림차순으로 
    스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
    같은 실패율은 오름차순으로
    N	stages	result
    5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
    4	[4,4,4,4,4]	[4,1,2,3]*/

    public static int[] solution(int n, int[] stages) {
        double[] answer = new double[n];
        Arrays.sort(stages);

        for (int i = 1; i <= n; i++) {
            int cnt = 0; // 현재 단계
            int pass = 0; // 지나간 사람들
            for (int j = 0; j < stages.length; j++) {
                if(i == stages[j]) cnt ++;
                if(stages[j] >= i) pass++;
            }
            answer[i-1] = (double) cnt/pass;
        }
//        for (double i : answer) {
//            System.out.println(i);
//        }
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < answer.length; i++) {
            map.put(i+1, answer[i]);
        }
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
//        list.sort(Map.Entry.comparingByKey());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o2.getValue().equals(o1.getValue())){
                    return o1.getKey().compareTo(o2.getKey()); // 키를 기준으로 오름차순 정렬
                }
                return o2.getValue().compareTo(o1.getValue()); // 내림차순 정렬
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey());
        }
        System.out.println("-------------------------");
        int [] a = new int[n];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i).getKey();
            System.out.println(a[i]);
        }


        return a;
    }
    public static void main(String[] args) {
        int n = 4;
//        int[] stages = {2, 4, 5, 4,6,1, 2, 6,2,4,3,3};
        int[] stages = {4,4,4,4,4};
        solution(n,stages);
    }
}
