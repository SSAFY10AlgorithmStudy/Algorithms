package d0916;

import java.io.*;
import java.util.*;

public class bj2179 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        Map<String, Integer> order = new HashMap<>();

        for (int i=0; i<n; i++) {
            words[i] = br.readLine();
            order.put(words[i], i);
        }

        // in case no similar
        String o1 = words[0];
        String o2 = words[1];

        Arrays.sort(words);
        List<String> similar = new ArrayList<>();
        int length = 0;
        String common = "";

        for (int i=0; i<n-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];

            int l = Math.min(s1.length(), s2.length());
            StringBuilder sb = new StringBuilder();
            int tmpcnt = 0;
            for (int j=0; j<l; j++) {
                if (s1.charAt(j) == s2.charAt(j)) {
                    tmpcnt++;
                    sb.append(s1.charAt(j));
                } else {
                    break;
                }
            }

            if (tmpcnt > length) {
                length = tmpcnt;
                common = sb.toString();
                similar.clear();
                similar.add(s1);
                similar.add(s2);
            } else if (tmpcnt == length) {
                if (common.contentEquals(sb)) {
                    similar.add(s2);
                } else {
                    int porder = n;
                    for (String s: similar) {
                        porder = Math.min(porder, order.get(s));
                    }
                    int norder = Math.min(order.get(s1), order.get(s2));
                    if (norder<porder) { // reset
                        common = sb.toString();
                        similar.clear();
                        similar.add(s1);
                        similar.add(s2);
                    }
                }
            }
        }

        if (common.equals("")) {
            System.out.println(o1 + "\n" + o2);
        } else {
            Collections.sort(similar, (e1, e2) -> order.get(e1) - order.get(e2));
            System.out.println(similar.get(0) + "\n" + similar.get(1));
        }
//        System.out.println(common);

    }

}