package programers.LV1;

public class 명함 {
    public static void main(String[] args) {
        int[][] size = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] size1 = {{10, 7}, {12, 3}, {8, 15},{14, 7}, {5, 15}};
        int[][] size2 = {{14, 4},{19,6}, {6, 16}, {18, 7}, {7, 11}};

        System.out.println(solution(size));
        System.out.println(solution(size1));
        System.out.println(solution(size2));
        }

    public static int solution(int[][] sizes) {

        int idx1 = 0;
        int idx2 = 0;
        for (int[] s : sizes) {
            if (s[0] < s[1]) { // 앞에 큰수가 오도록
                int temp = s[0];
                s[0] = s[1];
                s[1] = temp;
            }
            if (s[0] > idx1) idx1 = s[0]; // 앞 수중 가장 큰 값
            if (s[1] > idx2) idx2 = s[1]; // 뒷 수중 가장 큰 값
          
        }
        return idx1*idx2;
    }
}
