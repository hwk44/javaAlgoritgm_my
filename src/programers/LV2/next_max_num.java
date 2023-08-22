package src.programers.LV2;

public class next_max_num {

    public static void main(String[] args) {

        int n = 78;
        System.out.println(solution(n));

    }
    public static int solution(int n) {
        String s = Integer.toBinaryString(n);
        int count_1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '1') count_1 ++;
        }
//        System.out.println(count_1);

        while(true) {
            n++;
            String s1 = Integer.toBinaryString(n);
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if ( s1.charAt(i) == '1') cnt ++;
            }
            if (cnt == count_1) break;
        }
//        System.out.println(n);
        return n;
    }
}
