// 백준 마인크래프트
package d0909;

import java.io.*;
import java.util.*;

public class bj18111 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 줄로 읽어 빠르게 토큰으로 나누기

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] soil = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                soil[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = Integer.MAX_VALUE;
        int level = -1;

        for (int mid=0; mid<=256; mid++) {
            int blocks = b; // reset blocks
            int tmptime = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    int dig = soil[i][j] - mid;
                    if (dig > 0) tmptime += dig*2; // positive means dig
                    else if (dig < 0) tmptime += Math.abs(dig); // negative means fill
                    blocks += dig;
                }
            }

            // if remaining blocks > map size
            // meaning we dug too much
            // we should dig less
            // min = mid + 1
            // if not enough blocks
            // impossible, cannot Rill that much
            // need to dig more
            // max = mid - 1
            if (blocks >= 0) {
                if (tmptime <= time) {
                    time = tmptime;
                    level = mid;
                }
            }

        }

        //출력
        System.out.println(time + " " + level);

    }

}