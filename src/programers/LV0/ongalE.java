package src.programers.LV0;

public class ongalE {

    /*
    * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
    *  조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩
    * 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
    *  문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가
    * 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
    * */



    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(solution2(babbling));

    }

    public static int solution2(String[] babbling) {
        int answer = 0;
        for (String s: babbling) {
//             String s = "ayaae";
            String temp = s;
            if(s.contains("aya")){
                temp = s.replace("aya",",");
                System.out.println(temp);
            }
            if (s.contains("ye")){
                temp = temp.replace("ye",",");
                System.out.println(temp);
            }
            if (s.contains("woo")){
                temp = temp.replace("woo",",");
                System.out.println(temp);
            }
            if (s.contains("ma")){
                temp = temp.replace("ma",",");
                System.out.println(temp);
            }
            if(temp.contains(",")){
                temp = temp.replace(",", "");
            }
            if(temp.length() == 0) answer++;


        }
        return answer;
    }
}
