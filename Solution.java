import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int[] study = new int[n];
            boolean[] connect = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                study[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(Arrays.toString(study));
        }


    }

}