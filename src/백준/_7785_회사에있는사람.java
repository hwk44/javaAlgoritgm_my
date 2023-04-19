package src.백준;

import java.io.*;
import java.util.*;

public class _7785_회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String ,String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            map.put(s1,s2);
        }


        List<String> remain = new ArrayList<>();
        for(Map.Entry<String,String> en: map.entrySet()) {
           if (en.getValue().equals("enter")) remain.add(en.getKey());
        }

        Collections.sort(remain,Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < remain.size(); i++) {
            bw.write(remain.get(i) + "\n");
        }
        bw.close();
        // 입력 확인
//        for (int i = 0; i < n; i++) {
//            System.out.println(nlist.get(i));
//        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(mlist.get(i));
//        }

    }
}
