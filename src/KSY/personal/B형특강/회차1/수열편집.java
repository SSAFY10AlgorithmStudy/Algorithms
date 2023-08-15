package KSY.personal.B형특강.회차1;
import java.util.*;
import java.io.*;

public class 수열편집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			List<Integer> nums = new LinkedList<>();
			
			//수열 
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			
			//연산
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int x = Integer.parseInt(st.nextToken()), y;
				switch(op) {
				case "I":
					y = Integer.parseInt(st.nextToken());
					nums.add(x, y);
					break;
				case "D":
					nums.remove(x);
					break;
				case "C":
					y = Integer.parseInt(st.nextToken());
					nums.set(x, y);
					break;
				}
			}
			if(nums.size() > L) {
				System.out.println("#"+test+" " + nums.get(L));
			} else {
				System.out.println("#"+test+" -1");
				
			}
		}

	}

}
