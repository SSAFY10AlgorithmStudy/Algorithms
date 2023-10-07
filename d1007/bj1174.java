package d1007;

import java.util.*; // 자료구조 등 위해
import java.io.*; // 테스트케이스 입출력 위해

public class bj1174 { // 클래스 정의 시작

    static List<Long> decreasing = new ArrayList<>();
    static ArrayDeque<Integer> combStack = new ArrayDeque<>();
    static boolean[] visited = new boolean[10];


    public static void main(String[] args) throws Exception { // 메인 메서드 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 빠르게 읽기

        int n = Integer.parseInt(br.readLine());

        if (n >= 1024) {
            System.out.println(-1);
            return;
        }

        // 자리수 별로 조합 만들기
        for (int i=1; i<=10; i++) {
            dfs(0, 0, i);
        }

        Collections.sort(decreasing);
        System.out.println(decreasing.get(n-1));

    }


    // idx 이전 자리수의 값 - 여기부터 시작해서 큰수만 추가
    // cnt 현재까지 채운 자리수
    // lim 채워야할 자리수
    static void dfs(int idx, int cnt, int lim) {

        if (cnt == lim) {
            long tmp = 0;
            for (int x: combStack) {
                tmp += x;
                tmp *= 10;
            }
            tmp /= 10;
            decreasing.add(tmp);
            return;
        }

        for (int i=idx; i<10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combStack.offerFirst(i);
                dfs(i+1, cnt+1, lim);
                combStack.pollFirst();
                visited[i] = false;
            }

        }


    }

}