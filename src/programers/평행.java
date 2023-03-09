package src.programers;

import java.util.Arrays;

public class 평행 {

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
//        dots = new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}};
        System.out.println(dots.length);
        System.out.println(solution(dots));
    }
    /*
     문제 설명
    점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
    [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
    주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을
    없으면 0을 return 하도록 solution 함수를 완성해보세요.
 */

    public static int solution(int[][] dots) {
        int answer = 0;
        double[] temp = new double[6];
        int index = 0;
        for (int i = 0; i < dots.length; i++) {
            for (int j = i+1; j < dots.length; j++) {
                temp[index++] = (double)((dots[i][0] - dots[j][0]) / (dots[i][1] - dots[j][1]));
            }
        }
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            for (int j = i+1; j < temp.length; j++) {
                if(temp[i] != 0.0 && temp[j] != 0.0) {
                    if (temp[i] == temp[j]) answer++;
                }
            }
        }
        if (answer > 0) return 1;
        else return 0;

    }
}
