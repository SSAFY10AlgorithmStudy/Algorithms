package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

public class S1676_팩토리얼0의개수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		if(N % 10 != 0 || N % 5 != 0) sb.append(0);
		else {
			long sum = 1, answer=0;
			//팩토리얼
			for(int i=2; i<=N; i++) {
				sum *= i;
				if(sum > 1000)
					sum %= 1000;
			}
			//System.out.println(sum);
			//0이아닌 수 만날때까지 
			while(true) {
				if(sum % 10 == 0)
					answer++;
				else
					break;
				sum /= 10;
			}
			sb.append(answer);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
