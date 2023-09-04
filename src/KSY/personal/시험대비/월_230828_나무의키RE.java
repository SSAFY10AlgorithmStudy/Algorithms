package KSY.personal.시험대비;

import java.io.*;
import java.util.*;

public class 월_230828_나무의키RE {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/personal/시험대비/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int answer = 0;
			int max = 0;
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] trees = new int[N];
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(max < trees[i])
					max = trees[i];
			}
			
			int odd = 0, even = 0;
			for(int i=0; i<N; i++)
			{
				if(max == trees[i])
					continue;
				
				odd += (max - trees[i]) % 2;
				even += (max - trees[i]) / 2;
			}
			
			while(even > odd && Math.abs(even - odd) > 1) {
				even -= 1;
				odd += 2;
			}
			
			if(odd > even) {
				answer = odd*2 - 1;
			} else if(even > odd) {
				answer = even*2;
			} else {
				answer = odd + even;
			}
			
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
