package src.programers.Lv1;

import java.util.*;

public class result_of_report {

    /*신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다.
     무지가 개발하려는 시스템은 다음과 같습니다.

        각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
        신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
        한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
        k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
        다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

        각 유저가 메일을 받는 횟수를 리턴해야함.
        신고한 사람이 신고가 되면 +1

        2 <= id_list <= 1000
        3 <= report <= 200000
*/



    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;



        int[] answer = solution(id_list,report,k);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 아이디 별로 신고 횟수 map
        Map<String, Integer> countOfReport = new HashMap<>();

        // 신고당한 사람 리스트
        List<String> members = new ArrayList<>();

        // 동일한 신고 제거
        Set<String> report_list = new HashSet<>(Arrays.asList(report));

        for (String s :report_list) { // report 순회하면서 신고횟수 누적
            String temp = s.split(" ")[1]; // 신고받은 사람
            
            if (countOfReport.containsKey(temp)) { // Map 객체에 있으면 +1
                int current_count = countOfReport.get(temp);
                countOfReport.put(temp, current_count + 1); // 신고받은 횟수 + 1
            }else countOfReport.put(temp,1); // 없으면 1
            
            // 신고횟수가 넘어가고 members 목록에 없으면 추가
            if ((countOfReport.get(temp) >= k) && !members.contains(temp)) members.add(temp);
        }

//        System.out.println("countOfReport");
//        for (Map.Entry<String, Integer> entry:countOfReport.entrySet()) {
//            System.out.println(entry);
//        }
//        System.out.println("member");
//        for (String s :members) {
//            System.out.println(s);
//        };

        // 정지 대상자 members
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            for (String s :report_list) {
                if (s.split(" ")[0].equals(user) && members.contains(s.split(" ")[1]))
                    answer[i]++;
            }
        }


        return answer;
    }
}
