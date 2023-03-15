package src.programers.Lv1;

public class 문자열내림차순 {

    /*문자열 s에 나타나는 문자를 큰것부터
    작은 순으로 정렬해 새로운 문자열을 리턴하는 함수 완성해주세요.
    s는 영문 대소문자로만 구성되어 있으며,
    대문자는 소문자보다 작은 것으로 간주합니다.*/


    public static void main(String[] args) {
        String s= "Zbcdefg";
        StringBuilder sb = new StringBuilder();
        int max= 0;
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            max = 0;
            max= s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
//                max= 0;
                if(max < (int) s.charAt(j)){
                    max = (int) s.charAt(j); // j 에 해당하는 문자값
//                    System.out.println(max);

//                    System.out.println(s);
                }
                s = s.replace(String.valueOf(s.charAt(j)),"");
                if (s.length() == 0) break;
            }
            sb.append((char)max);
            }
//        System.out.println(String.valueOf(s.charAt(1)));
//        System.out.println(max);
        System.out.println(sb);

    }
}
