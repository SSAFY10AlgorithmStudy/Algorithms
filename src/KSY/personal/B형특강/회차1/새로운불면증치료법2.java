package KSY.personal.B형특강.회차1;
import java.util.*;
import java.io.*;

// Set, BitMasking ... 등의 방법으로 풀이할 수 있음 

public class 새로운불면증치료법2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int index = 1;
			boolean[] checkArr = new boolean[10];
			
			while(true) {
				int temp = N*index++;
				while(temp > 0) {
					if(!checkArr[temp%10]){
						checkArr[temp%10] = true;
						temp /= 10;
					}
				}
				boolean flag = false;
				for(int j=1; j<=9; j++) {
					if(checkArr[j] == false)
						continue;
					flag = true;
				}
				if(flag)
					break;
			}
			System.out.println(index);
			
		}
		

	}

}
