package src.programers.Lv1;

public class 둘만의암호 {

    /*s와 skip 할 문자열,
     그리고 자연수 index 가 주어질 때, */

    public static void main(String[] args) {
        String s = "a";
        String skip = "xbczq";
        int index = 20;

        char[] ch_s = s.toCharArray();
        for (int i = 0; i < ch_s.length; i++) {
            int cnt= 0;
            while(cnt != index) {
                if (ch_s[i] > 'z') ch_s[i] = (char) (int)(ch_s[i] - 26);

                do {
                    if (!skip.contains(String.valueOf(ch_s[i]))) { // 스킵 안해도 되면
                        ch_s[i] = (char) ((int) ch_s[i] + 1);
                        cnt ++;
                    }
                    else ch_s[i] = (char)((int) ch_s[i] + 1); // 스킵해야하면 카운트 하지말기
                }while(!skip.contains(String.valueOf(ch_s[i])));

                }
            }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch_s.length; i++) {
            sb.append(ch_s[i]);
        }
        System.out.println(sb.toString());


    }
    public static String solution(String s, String skip, int index) {
        String answer = "";
        char[] ch_s = s.toCharArray();
        char[] ch_skip = skip.toCharArray();

        for (int i = 0; i < ch_s.length; i++) {
            // 점프 할때 스킵 문자 있는지 확인 그만큼 더 뛰면 됨
            int cnt = 0;
            for (int j = 0; j < ch_skip.length; j++) {
                if(((int) ch_s[i] + index >= (int) ch_skip[j] &&
                        (int) ch_s[i] < (int) ch_skip[j]) ||
                        ((int) ch_s[i] + index > 122 && (int) ch_s[i] + index >= (int) ch_skip[j] + 26 &&
                                (int) ch_s[i] < (int) ch_skip[j] + 26)){
                    cnt ++;
                }
            }

            ch_s[i] =(char)((int)ch_s[i] +index + cnt);
            if((int) ch_s[i] > 122) ch_s[i] =(char) ((int) ch_s[i] - 26);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch_s.length; i++) {
            sb.append(ch_s[i]);
//            System.out.println(ch_s[i]);
        }

        return sb.toString();

    }
}
