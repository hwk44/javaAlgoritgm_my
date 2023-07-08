package src.programers.Lv1.solved;

/*
* 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다.
*  약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
*  당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다.
*  수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

예를 들어, A라는 약관의 유효기간이 12 달이고,
*  2021년 1월 5일에 수집된 개인정보가 A약관으로
*  수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며
* 2022년 1월 5일부터 파기해야 할 개인정보입니다.
* 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
모든 달은 28일까지 있다고 가정합니다.*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/*
* 풀이 로직
* terms 가 String 배열인데 Map 으로 만들기
*
* privacies 배열 순회하면서 유효기간 확인 => 오늘 날짜랑 비교
*
* * */
public class personal_information {
/* String to Date
    스트링을 포맷에 맞추어 Date 객체 생성하는 법
    // 포맷터
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

    // 문자열 -> Date
    Date date = formatter.parse(dateStr);
*/
    public static void main(String[] args) throws ParseException {
        // test1
//        String today = "2022.05.19";
//        String [] terms = {"A 6", "B 12", "C 3"};
//        String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        // test2
        String today = "2020.01.01";
        String [] terms = {"Z 3", "D 5"};
        String [] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};



        int[] s = solution(today, terms, privacies);
        for (int i :s) {
            System.out.println("i = " + i);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");


    }
    public static int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> answer = new ArrayList<>();

        Date privaciesDates[] = new Date[privacies.length];

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

        for (int i = 0; i < privacies.length; i++) {
            privaciesDates[i] = formatter.parse(privacies[i].split(" ")[0]);
        }

        // Date 객체 확인
//        for (Date d : privaciesDates) {
//            System.out.println(d);
//        }

        // terms 배열 => key : Value  map 으로 만들기
        Map<String, Integer> map = Arrays.stream(terms)
                .map(term -> term.split(" ")) // 공백 기준으로 String[] 생성
                .collect(Collectors.toMap(split -> split[0], split -> Integer.parseInt(split[1]))); // split[0] : split[1]

        // 맵 순회 키 : 밸류 확인
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " +entry.getValue());
//        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(today)); // 오늘 날짜를 캘린더로

        for (int i = 0; i <privaciesDates.length ; i++) {
            // 수집 날짜
            String[] temp = privacies[i].split(" ");
            Date validate_date = formatter.parse(temp[0]);
            String key = temp[1];


            Calendar c1 = Calendar.getInstance();
            c1.setTime(validate_date);
            c1.add(Calendar.MONTH, map.get(key));
            c1.add(Calendar.DATE, -1);
            // 오늘이랑 비교

            if (cal.after(c1)) { // 캘린더 객체 비교 오늘 날짜가 보관기간 이후라면 정답 추가
                answer.add(i+1);
            }

        }
        int[] nums = new int[answer.size()];
        for (int i = 0 ; i < answer.size() ; i++)
            nums[i] = answer.get(i).intValue();

        return nums;
    }
}
