package KSY.personal.B형특강.회차1;
import java.util.*;
import java.io.*;

// Set, BitMasking ... 등의 방법으로 풀이할 수 있음 

public class 새로운불면증치료법 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int flag = 0,index = 1;
			int mask = (1 << 10) - 1;
			int answer = 0;
			
			while(true) {
				int temp = N*index++;
				answer = temp;
				while(temp > 0) {
					if((flag & (1 << temp%10)) == 0){
						flag = flag | (1 << temp%10);
					}
					temp/=10;
				}
				if(flag == mask){
					break;
				}
			}
			sb.append("#").append(i).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);

	}

}
