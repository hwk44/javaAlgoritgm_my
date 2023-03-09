package src.programers;

import java.util.ArrayList;
import java.util.Arrays;

public class 중앙값 {

    /*
    중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을
    때 가장 중앙에 위치하는 값을 의미합니다. 예를 들어 1, 2, 7, 10, 11의
    중앙값은 7입니다. 정수 배열 array 가 매개변수로 주어질 때,
     중앙값을 return 하도록 solution 함수를 완성해보세요.
     */

    public static void main(String[] args) {

        int[] a = {11, 2, 7 ,1 , 10};
//        sort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(solution(a));

    }

    public static int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);

        return array[array.length/2];
    }
    public static  void swap(int[] array, int x1, int x2) {
        int temp = array[x1];
        array[x1] = array[x2];
        array[x2] = temp;
    }
    public static void sort(int[] array){
        // 정렬 알고리즘
        for (int j = array.length- 1; j >=1 ; j--) {
            for (int i = array.length-1; i >= 1; i--) {
                //            int temp = array[i];
                if (array[i] < array[i - 1]) // 맨 뒤값이 작으면 스왑
                    swap(array, i, i - 1);
                //            else { // 뒤값이 크면? 그대로

            }
        }
    }
}
