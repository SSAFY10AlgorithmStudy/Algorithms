package S_0916;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Swea_2948 {
    static int T, N,M;
    static String arrN[], arrM[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <=T ; test_case++) {
            String[] s = br.readLine().split(" ");
            int cnt = 0;
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            arrN = new String[N];
            arrM = new String[M];
            s = br.readLine().split(" ");
            for (int i = 0; i < arrN.length; i++) {
                arrN[i] = s[i];
            }

            s = br.readLine().split(" ");
            for (int i = 0; i < arrM.length; i++) {
                arrM[i] = s[i];
            }
            

            HashSet<String> setN= new HashSet<>(Arrays.asList(arrN));
            HashSet<String> setM= new HashSet<>(Arrays.asList(arrM));

            setN.retainAll(setM); // 두 집합의 교집합을 구함

            cnt=setN.size();
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
