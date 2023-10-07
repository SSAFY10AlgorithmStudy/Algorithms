package d1007;

import java.io.*;
import java.util.*;

public class bj9375 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int tc=0; tc<t; tc++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append(0).append("\n");
                continue;
            }

            Map<String, Integer> clothes = new HashMap<>();

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String c = st.nextToken();
                clothes.putIfAbsent(c, 0);
                clothes.put(c, clothes.get(c)+1);
            }

            System.out.println(clothes);

            int ans = 1;
            for(int x: clothes.values()) {
                ans *= x+1;
            }
            sb.append(ans-1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}