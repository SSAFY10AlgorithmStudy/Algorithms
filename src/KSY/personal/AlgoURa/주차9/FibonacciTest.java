package KSY.personal.AlgoURa.주차9;

import java.util.*;

public class FibonacciTest {
	
	static long totalCnt1, totalCnt2, callCnt1[], callCnt2[], memo[];
	
	private static long fibo1(int n) {  // 피보나치 n항 구하기 
		totalCnt1++;
		callCnt1[n]++;
		if(n<2) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	private static long fibo2(int n) {
		totalCnt2++;
		callCnt2[n]++;
		if(memo[n] != -1) return memo[n];
		return memo[n] = fibo2(n-1) + fibo2(n-2);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		totalCnt1 = totalCnt2 = 0;
		callCnt1 = new long[N+1];
		callCnt2 = new long[N+1];
		memo = new long[N+1];
		
		Arrays.fill(memo, -1);  // 메모되지 않은 상태를 나타내는 값으로 초기화 
		// 유도되어 값이 저장되지 않는 것 초기화 
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibo1(N));
		System.out.println("fibo1 : " + totalCnt1);  // fibo1 : 3672623805
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo1["+i+"] : " + callCnt1[i]);
		}
		System.out.println("=======================================");
		System.out.println(fibo2(N)); // fibo2 : 89
		System.out.println("fibo2 : " + totalCnt2);
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo2["+i+"] : " + callCnt2[i]);
		}
	}
}
