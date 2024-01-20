package KSY;

import java.io.*;
import java.util.*;

//271808KB/	2376ms

public class S18870_좌표압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Node1> nums = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums.add(new Node1(i, Integer.parseInt(st.nextToken())));  // 인덱스와 값을 묶에서 저장 
		}

		// 값기준 정렬
		Collections.sort(nums, (a, b) -> {
			if (a.value > b.value)
				return 1;
			else {
				if (a.value < b.value)
					return -1;
				else
					return 0;
			}
		});

		int num = 0, front = nums.get(0).value; // 처음값(앞 값)
		for (int i = 0; i < N; i++) {
			Node1 curr = nums.get(i);
			if (curr.value != front) {  // 앞에 있는 값과 같지 않다(= 새로운 값 등장)
				num++;
				front = curr.value;
			}
			curr.value = num;
		}

		// 인덱스 기준 정렬
		Collections.sort(nums, (a, b) -> {
			if (a.idx > b.idx)
				return 1;
			else {
				if (a.idx < b.idx)
					return -1;
				else
					return 0;
			}
		});

		// 값 출력
		for (int i = 0; i < N; i++) {
			sb.append(nums.get(i).value).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

class Node1 {
	int idx, value;

	Node1(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}