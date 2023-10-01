package KSY;

import java.util.*;
import java.io.*;

//12216KB/	88ms

public class S16928_뱀과사다리게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] map = new int[101];
		Arrays.fill(map, 100);
		map[1] = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수

		int[] ladders = new int[101];
		int[] snacks = new int[101];
		int answer = 100; // 이동 횟수(최악의 경우로 초기화)

		for (int i = 0; i < N; i++) { // 사다리
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladders[from] = to;
		}

		for (int i = 0; i < M; i++) { // 뱀
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			snacks[from] = to;
		}

		Queue<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 1));

		while (!que.isEmpty()) {
			Pos curr = que.poll();
			if (curr.cnt > map[curr.pos])
				continue;
			map[curr.pos] = curr.cnt;

			if(curr.pos == 100)  // 안 하면 메모리 초과
				break;

			for (int d = 1; d <= 6; d++) {
				if (curr.pos + d < 101) {
					if (curr.cnt + 1 < map[curr.pos + d]) {
//						boolean flag = false;
//						que.offer(new Pos(curr.cnt + 1, curr.pos + d));
						int point = curr.pos + d;
						Pos pos = new Pos(curr.cnt + 1, point);

						int ladder = ladders[curr.pos + d];
						int snack = snacks[curr.pos + d];

						if (ladder != 0) { // 사다리가 있다면
//							map[ladder] = curr.cnt + 1;
//							que.offer(new Pos(curr.cnt + 1, ladder));
//							flag = true;
							point = ladder;
						}

						if (snack != 0) { // 뱀이 있다면 (else-if -> if : 12% -> 22%)
//							map[snack] = curr.cnt + 1;
//							que.offer(new Pos(curr.cnt + 1, snack));
//							flag = true;
							point = snack;
						}
						
						map[point] = curr.cnt + 1;
						pos.pos = point;
						que.offer(pos);
					}
				}
			}
		}
		System.out.println(map[100]);
	}

}

class Pos {
	int cnt, pos;

	Pos(int cnt, int pos) {
		this.cnt = cnt;
		this.pos = pos;
	}
}