package d1014;

import java.util.*; // 자료구조 등 위해
import java.io.*; // 테스트케이스 입출력 위해

public class bj18870 { // 클래스 정의 시작

    public static void main(String[] args) throws Exception { // 메인 메서드 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 문자열 모아서 출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] ord = new int[n];
        Set<Integer> srt = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            ord[i] = Integer.parseInt(st.nextToken());
            srt.add(ord[i]);
        }


        Map<Integer, Integer> compress = new HashMap<>();
        int cnt = 0;
        for (int i: srt) {
            compress.putIfAbsent(i, cnt);
            cnt++;
        }

        for (int i=0; i<n; i++) {
            int c = compress.get(ord[i]);
            sb.append(c).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

    }

}