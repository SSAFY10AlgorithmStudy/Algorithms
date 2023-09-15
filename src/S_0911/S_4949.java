package S_0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
public class S_4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean chk = true;

            for (int i =0; i< s.length();i++) {
                char ch = s.charAt(i);
                if (ch == '[' || ch == '(') {
                    stack.push(ch);
                } else {
                    if (ch == ')')  {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            chk = false;
                            break;
                        }
                    }
                        else if (ch ==  ']') {

                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            chk = false;
                            break;
                        }

                    }
                }

                if (!chk) break;
            }
            if (!stack.isEmpty()) chk = false;

            sb.append(chk ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
