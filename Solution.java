import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        while (s != null) {
            int n = s.length();
            Stack<Character> stack = new Stack<>();
            boolean match = true;
            for (int i=0; i<n; i++){
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.add(ch);
                } else if (ch == ')') {
                    if (stack.peek() != '(') {
                        match = false;
                        break;
                    }
                    stack.pop();
                } else if (ch == '[') {
                    stack.add(ch);
                } else if (ch == ']') {
                    if (stack.peek() != '[') {
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
        }

    }

}