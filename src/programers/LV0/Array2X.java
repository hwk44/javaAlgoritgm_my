package src.programers.LV0;


import java.util.Arrays;

public class Array2X {

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5};
        System.out.println(solustion(n));
    }

    private static String solustion(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        return Arrays.toString(answer);
    }
}


