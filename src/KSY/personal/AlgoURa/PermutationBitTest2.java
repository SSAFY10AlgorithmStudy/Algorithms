package KSY.personal.AlgoURa;

import java.util.*;

// 순열을 구할 때 배열이 아닌 비트마스킹을 사용한다고 더 빠른 것은 아니다
// 하지만 이러한 구현이 가능하고, 비트마스킹을 활용해야하는 문제를 만날 수 있다.

public class PermutationBitTest2 {
	static int N, R, input[], numbers[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0, 0);  // flag는 초기에 아무것도 선택하지 않았기에 0
		
	}
	
	private static void permutation(int cnt, int flag) {  //cnt 자리에 들어갈 수를 뽑기
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; i++) {
			//중복 체크
			if((flag & 1<<i) != 0)  // !=0 이유 : 결과값이 2, 4, 8 .. 어떤 수인지 알 수 없다.
				continue;
			//수를 선택
			numbers[cnt] = input[i];
			//다음자리수 뽑기
			permutation(cnt+1, flag | 1<<i); // 선택 됨을 set
			//방문 흔적 지우기 : flag로 했기 때문에 진행할 필요 없음
		}
	}

}
