package KSY.personal.시험대비;

import java.util.*;
import java.io.*;

public class 월_230828_A형_시험대비 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/personal/시험대비/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			
			int answer=0;
			int N = Integer.parseInt(br.readLine());
			
			// 나무 입력 받기
			int trees[] = new int[N];
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(trees[i] > max)
					max = trees[i];
			}
			
			int odd=0, even=0;
			for(int i=0; i<N; i++) {
				if(trees[i] == max) continue;
				
				odd += (max - trees[i]) % 2;
				even += (max - trees[i]) /2;
			}
			
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even -= 1;
					odd += 2;
				}				
			}
			
			if(odd > even)
				answer  = odd*2 - 1;
			else if(odd < even)
				answer = even*2;
			else
				answer = odd + even;
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	

}



//	int cnt = 0;
//	
//	int N = Integer.parseInt(br.readLine());
//	// 나무 입력 받기
//	List<Integer> trees = new ArrayList<>();
//	StringTokenizer st = new StringTokenizer(br.readLine());
//	for (int i = 0; i < N; i++) {
//		int tree = Integer.parseInt(st.nextToken());
//		trees.add(tree);
//	}
//	
//	Collections.sort(trees);
//	int max = trees.get(trees.size() - 1);
//	for(int i=trees.size()-1; i>=0; i--) {
//		if(trees.get(i) == max)
//			trees.remove(i);
//	}
//	
//	int plus = 1;
//	while (!trees.isEmpty()) {
//		Collections.sort(trees);
//		// 더할 값 정하기
//		if (++cnt % 2 == 0)
//			plus = 2;
//		else
//			plus = 1;
//		for (int i = trees.size() - 1; i >= 0; i--) { // 뒤부터 탐색
//			if (trees.get(i) + plus == max) {
//				trees.remove(i);
//				break;
//			}
//			if (trees.get(i) + plus < max) {
//				trees.set(i, trees.get(i) + plus);
//				break;
//			}
//		}
//	}