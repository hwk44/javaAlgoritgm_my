package src.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1654_랜선자르기 {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine()); // 원하는 갯수

//        List<Integer> nums = new ArrayList<>();
        int[] nums = new int[n];
        int avg =0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            nums[i] =temp;
            avg += temp;
        }
        avg /= nums.length; // 대략적인 평균 / 자를 값
        Arrays.sort(nums);

        if (nums[0] > avg) avg = nums[0]; // 자를게 없으면 제일 작은 값으로 설정
        int s = 0;
        int e = nums.length-1;
        while(true) {
            int answer = 0;
            for (int i : nums) {
                answer += i / avg;
            }
            if(answer < m ){ // 랜선 부족하면
                s= avg +1;
            }else{ // 원하는 값보다 크거나 같으면?
                e = avg;
                // TODO 구현
            }
        }
    }

}
