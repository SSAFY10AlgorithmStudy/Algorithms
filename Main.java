import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for (int tc=0; tc<t; tc++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Long, Integer> counter = new HashMap<>();

            for (int qr=0; qr<k; qr++) {
                st = new StringTokenizer(br.readLine());
                String action = st.nextToken();
                long n = Long.parseLong(st.nextToken());
                if (action.equals("I")) { // insert
                    counter.putIfAbsent(n, 0);
                    counter.put(n, counter.get(n) + 1);
                    maxHeap.offer(n);
                    minHeap.offer(n);
                } else if (n == 1) { // delete top
                    while (!maxHeap.isEmpty() && counter.get(maxHeap.peek()) == 0) { // 최소힙에서 뺀 값을 버리기
                        maxHeap.poll();
                    }
                    if (!maxHeap.isEmpty()) {
                        long rm = maxHeap.poll();
                        counter.put(rm, counter.get(rm) - 1);
                    }
                } else { // delete bottom
                    while (!minHeap.isEmpty() && counter.get(minHeap.peek()) == 0) { // 최대힙에서 뺀 값을 버리기
                        minHeap.poll();
                    }
                    if (!minHeap.isEmpty()) {
                        long rm = minHeap.poll();
                        counter.put(rm, counter.get(rm) - 1);
                    }
                }
            }

            while (!minHeap.isEmpty() && counter.get(minHeap.peek()) == 0) { // 최대힙에서 뺀 값을 버리기
                minHeap.poll();
            }
            while (!maxHeap.isEmpty() && counter.get(maxHeap.peek()) == 0) { // 최소힙에서 뺀 값을 버리기
                maxHeap.poll();
            }

            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }
            sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}