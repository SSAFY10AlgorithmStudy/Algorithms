package KSY;

import java.util.*;
import java.io.*;

//	16684	180

public class S4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		while(!str.equals(".")) {
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			
			for(int i=0; i<str.length(); i++) {
				char op = str.charAt(i);
				if(op == '(') {
					stack.add(op);
				} else if(op == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = true;
						break;
					}
					else
						stack.pop();
				} else if(op == '[') {
					stack.add(op);
				} else if(op == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = true;
						break;
					}
					else
						stack.pop();
				}
			}
			if(flag || !stack.isEmpty())
				sb.append("no");
			else
				sb.append("yes");
			sb.append("\n");
			str = br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();;
	}

}
