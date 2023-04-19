package src.백준;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class _1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] nlist =  new String[n];
        List<String> mlist =  new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nlist[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            mlist.add(br.readLine());
        }
//        Collections.sort(nlist);
        Arrays.sort(nlist);
//        Collections.sort(mlist);
        List<String> answer = new ArrayList<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            if(Arrays.binarySearch(nlist,mlist.get(i)) >= 0) {
                answer.add(mlist.get(i));
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");

        }

        bw.close();

    }
}
