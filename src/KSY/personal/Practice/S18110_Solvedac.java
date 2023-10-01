package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

// 36816KB	320ms

public class S18110_Solvedac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		if(N == 0)
			sb.append(0);
		else if(N == 1)
			sb.append(Integer.parseInt(br.readLine()));
		else {
			int[] nums = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(nums);
			
			int index = (int)Math.round(N*0.15);
			double answer=0;
			for(int i=index; i<N-index; i++) {
				answer += nums[i];
			}
			
			sb.append((int)Math.round(answer/(N-index*2)));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
