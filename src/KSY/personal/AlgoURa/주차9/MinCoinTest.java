package KSY.personal.AlgoURa.주차9;

import java.util.Scanner;

public class MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); // 교환 금액
		
		int[] D = new int[money+1];
		D[0] = 0;
		
		for(int i=1; i<= money; i++) {
			//1원 시도
			D[i] = D[i-1]+1;
			//4원 시도
			if(i>=4 && D[i] > D[i-4]+1) D[i] = D[i-4]+1;
			//6원 시도 
			if(i>=6 && D[i] > D[i-6]+1) D[i] = D[i-6]+1;
		}

		System.out.println(D[money]);
	}

}
