package src.programers.Lv1.solved;

public class 약수개수와덧셈 {
    /*두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
     약수의 개수가 짝수인 수는 더하고,
     약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.*/

    public static void main(String[] args) {

        int left = 13;
        int right = 17;
        int sum = 0;

        for (int i = left; i < right+1; i++) {

            int count = 0;

            for (int j = 1; j < i+1; j++) {
                    if( i % j == 0) count++;
            }
            System.out.println(count);
            if ((count % 2) == 0 ) { //약수 개수가 짝수면
                sum += i;
            }else {
                sum -= i;
            }
        }
        return;

    }


}
