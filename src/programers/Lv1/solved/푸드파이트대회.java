package src.programers.Lv1.solved;

public class 푸드파이트대회 {

    public static String solution(int[] food) {
        String answer = "";
        int times;
        for (int i = 1; i < food.length; i++) {
            times = food[i]/2;
            for (int j =0; j < times; j++){
                answer += String.valueOf(i);
            }
        }

        StringBuffer sb = new StringBuffer(answer);
        sb = sb.reverse();
        answer += "0";
        answer = answer.concat(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        // result = "1223330333221";
        System.out.println(solution(food));


    }
}
