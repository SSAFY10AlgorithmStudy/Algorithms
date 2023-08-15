// https://www.acmicpc.net/problem/16401
package d0815;

import java.io.*;
import java.util.*;

// memory 169628kb time 1004ms
public class 과자나눠주기 {

    static int[] cookies;
    static int left, right, c;
    static int n, m, answer;
	
	public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cookies = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(cookies); // 과자 길이 오름차순 정렬

        left = 1;
        right = cookies[n-1];
        answer = 0;
        while(left <= right) {
            c = (right+left)/2;
            countCookies();
        }
        System.out.println(answer);
        
    }

    static void countCookies() {
        int count = 0;
        for (int i=cookies.length-1; i>=0; i--) {
            count += cookies[i]/c;
            if (count >= m) {
                left = c+1;
                answer = c;
                return;
            }
            if (cookies[i] < c && count < m) {
                right = c-1;
                return;
            }
        }
        if (count >= m) { // m = 조카 수
            left = c+1;
            answer = c;
        } else {
            right = c-1;
        }
    }

}