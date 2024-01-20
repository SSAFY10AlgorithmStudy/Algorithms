package KSY;
import java.util.*;
import java.io.*;

public class S9461_파도반수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long [] nums = new long[101];  // ;;
		int index = 1;
		nums[1] = 1;
		nums[2] = 1;
		nums[3] = 1;
		
		nums[4] = 2;
		nums[5] = 2;
		
		for(int i=6; i<=100; i++) {
			nums[i] = nums[i-1] + nums[index++];
		}
//		System.out.println(Arrays.toString(nums));
		
		for(int test=0; test<N; test++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(nums[num]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
