package KSY;

import java.util.*;
import java.io.*;

public class S2847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int answer=0;
		for(int i=N-1; i>0; i--) {
			while(nums[i] <= nums[i-1]) {
				nums[i-1]--;
				answer++;
			}
		}
		System.out.println(answer);
	}

}
