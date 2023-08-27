package KSY.personal.시험대비;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SoonJonBu {
	static int N;
	static int R;
	static int[] input, result;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();

	}
	
	public static void Permutation(int cnt, int flag) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag & (1 << i)) != 0)  // check
				continue;
			result[cnt] = input[i];
			Permutation(cnt+1, flag | 1 << i);  // check
		}
		
	}
	
	public static void NPP() {
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		} while(NP(input));
	}
	
	public static void Combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[cnt] = input[i];
			Combination(cnt+1, i+1);  // check
		}
		
	}
	
	public static void NPC() {
		int[] p = new int[N];
		int i=N-1;
		while(i>N-R) p[i--] = 1;  // i-- 주의 
		do {
			for(int j=0; j<N; j++) {
				if(p[i] == 1) {
					System.out.print(p[i]);
				}
				System.out.println();
			}
		} while(NP(p));
	}
	
	public static boolean NP(int[] p) {
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k= N-1;
		while(k > i)
			swap(p, k--, i++);
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
