package src.programers.Lv1;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args) {

        int[] a1 = {1,2,3,4,5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


//        int[] answer= {1,2,3,4,5, 2, 4, 5, 2,1, 1,2,3, 4,5};
//        int[] answer= {1,2,3,4,5};
        int[] answer= {1,3,2,4,2};

        int score = 0;
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == a1[i%a1.length]) score++;
        }

//        System.out.println(score);
        System.out.println((solution(answer)));
    }

    public static List solution(int[] answers) {
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == a1[i%a1.length]) score1++;
            if(answers[i] == a2[i%a2.length]) score2++;
            if(answers[i] == a3[i%a3.length]) score3++;
        }

        List<Integer> l = new ArrayList<Integer>();
        l.add(score1);
        l.add(score2);
        l.add(score3);
        int max = 0;
        List<Integer> idx = new ArrayList<Integer>();

        for (int i = 0; i < l.size(); i++) {
            if(l.get(i) >= max) {
                max = l.get(i);
                idx.add(i+1);
            }
        }

        int[] answer = idx.stream()
                .mapToInt(i -> i)
                .toArray();
        Arrays.sort(answer);
//        List l1 = new ArrayList<>();
//        Collections.sort(l);
//        for (int i = l.size() -1; i >= 0; i--) {
//            if(l.get(i) != 0) l1.add(i+1);
//        }
//        Collections.sort(l);


//        int[] answer = l.stream()
//                .mapToInt(i -> (int) i)
//                .toArray();
//        for (int i = 0; i < l1.size(); i++) {
//            System.out.println(l1.get(i));
//        }
//        System.out.println();

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,score1);
        map.put(2,score2);
        map.put(3,score3);
        // 맵에 저장

        int max_score = 0;
        for (Integer value : map.values()){
            if(value > max_score) max_score = value;
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> et : map.entrySet()){
            if (max_score == 0) break;
            if(et.getValue() == max_score) { // max 값과 같으면
                result.add(et.getKey()); // 키 값을 넣어라
            }
        }

        return result;

    }
}
