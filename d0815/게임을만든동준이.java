// https://www.acmicpc.net/problem/2847

package d0815;

import java.io.*;

public class 게임을만든동준이 {

    static int[] cookies;
    static int left, right, c;
    static int n, m, answer;
	
	public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        if (n==1) {
            System.out.println(0);
            return;
        }

        int[] points = new int[n]; // 레벨 점수 담은 배열

        for (int i=0; i<n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int prevLev = points[n-1]; // 최종 레벨의 최고점
        int res = 0; // 점수를 몇번 감소했는지 세기

        for (int i=n-2; i>=0; i--) {
            if (points[i] < prevLev) {
                prevLev = points[i];
                continue;
            }
            prevLev = prevLev-1;
            res += points[i] - prevLev;
        }

        System.out.println(res);
    }

}