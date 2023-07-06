package src.programers.Lv1.solved;

public class 행렬덧셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < answer.length; i++) { // 행 순회
            for (int j = 0; j < answer[i].length; j++) { // 열 순회
                answer[i][j] = arr1[i][j] +  arr2[i][j];
            }
            
        }
        
        return answer;
    }
}
