package d1007;

import java.util.*; // 자료구조 등 위해
import java.io.*; // 테스트케이스 입출력 위해

public class bj1655 { // 클래스 정의 시작

    public static void main(String[] args) throws Exception { // 메인 메서드 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); // 문자열 모아서 출력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(Integer.parseInt(br.readLine()));
        int mid = maxHeap.peek();
        sb.append(mid).append("\n");
        for (int i=1; i<n; i++) {
            int next = Integer.parseInt(br.readLine());

            // add to heap
            if (next > mid) {
                minHeap.add(next);
            } else {
                maxHeap.add(next);
            }

            // balance heap
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size()+1) {
                minHeap.offer(maxHeap.poll());
            }

            // update mid
            mid = maxHeap.peek();
            sb.append(mid).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();

    }

}