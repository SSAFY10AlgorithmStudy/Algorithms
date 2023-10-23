package d1023;

import java.io.*;
import java.util.*;

public class bj1062 {

    static int n, k, ans;
    static boolean[] selected = new boolean[26];
    static List<Character> potential;
    static String[] words;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        k -= 5;

        words = new String[n];
        Set<Character> alpha = new HashSet<>();

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=4; j<s.length()-4; j++) {
                alpha.add(s.charAt(j));
            }
            words[i] = s;
        }

        char[]  common = {'a', 'n', 't', 'i', 'c'};
        for (char c: common) {
            selected[c-'a'] = true;
            alpha.remove(c);
        }
        potential = new ArrayList<>(alpha);

        // 가르칠 수 있는 글자수 k 보다 배울게 적을때 모든 단어 학습 가능
        if (k > potential.size()) {
            System.out.println(n);
            return;
        }

        ans = 0;
        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int cnt, int start) {
        if (cnt == k) {
            int tmp = 0;
            // 몇개 단어들 읽을 수 있는지 확인
            for (int i=0; i<n; i++) {
                String w = words[i];
                boolean know = true;
                for (int j=4; j<w.length()-4; j++) {
                    if (!selected[w.charAt(j)-'a']){
                        know = false;
                        break;
                    }
                }
                if (know) tmp++;
            }
            ans = Math.max(ans, tmp);
            return;
        }

        for (int i=start; i<potential.size(); i++) {
            char nc = potential.get(i);
            selected[nc-'a'] = true;
            dfs(cnt+1, i+1);
            selected[nc-'a'] = false;
        }

    }

}