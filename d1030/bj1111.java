package d1030;

import java.io.*;
import java.util.*;

public class bj1111 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 줄로 읽어 빠르게 토큰으로 나누기

        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println("A");
            return;
        }

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 2) {
            if (arr[0] == arr[1]) System.out.println(arr[0]);
            else System.out.println("A");
            return;
        }

        int d1 = arr[1] - arr[0];
        int d2 = arr[2] - arr[1];
        int a = 0;
        if (d1 != 0) {
            a = d2/d1;
        }
        int b = arr[1] - arr[0] * a;

        for (int i=2; i<arr.length; i++) {
            if (arr[i] != arr[i-1] * a + b) {
                System.out.println("B");
                return;
            }
        }

        System.out.println(arr[arr.length-1]*a + b);


    }

}
