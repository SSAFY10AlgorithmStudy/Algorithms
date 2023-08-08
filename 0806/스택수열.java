import java.util.*;
import java.io.*;

public class 스택수열 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\user\\Documents\\CAREER\\SSAFY\\Algorithms\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        for (int i=0; i<n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int sPointer = 0;
        for (int i=1; i<=n; i++) {
            // 스택의 꼭대기가 수열의 다음과 맞는지 확인
            while (!stack.isEmpty() && stack.peek() == sequence[sPointer]) {
                stack.pop();
                sPointer++;
                sb.append("-").append("\n");
            }

            stack.add(i);
            sb.append("+").append("\n");
        }

        while (!stack.isEmpty() && stack.peek() == sequence[sPointer]) {
            stack.pop();
            sPointer++;
            sb.append("-").append("\n");
        }

        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }

    }

}
