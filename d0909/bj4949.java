package d0909;

import java.io.*;
import java.util.*;

public class bj4949 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        while (!s.equals(".")) {
            int n = s.length();
            Stack<Character> stack = new Stack<>();
            boolean match = true;
            for (int i=0; i<n; i++){
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.add(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        match = false;
                        break;
                    }
                    stack.pop();
                } else if (ch == '[') {
                    stack.add(ch);
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        match = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                match = false;
            }
            if (match) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
            s = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();

    }

}