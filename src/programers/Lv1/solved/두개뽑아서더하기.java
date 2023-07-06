package src.programers.Lv1.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 두개뽑아서더하기 {

    /*정수 배열 numbers가 주어집니다.
    numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
    모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
//        int[] numbers = {5,0,2,7};
        List a = new ArrayList();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                if(!a.contains(numbers[i]+numbers[j])) a.add(numbers[i]+numbers[j]);
            }
        }
        Collections.sort(a);
        System.out.println(a);

    }
    public static List solution(int[] numbers) {
        int[] answer = {};

        List a = new ArrayList();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                if(!a.contains(numbers[i]+numbers[j])) a.add(numbers[i]+numbers[j]);
            }
        }
        Collections.sort(a);
//        System.out.println(a);

        return a;
    }

}
