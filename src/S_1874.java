import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//	29008ms	296kb
public class S_1874 {
    static int n;
    static Stack<Integer> st;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        st = new Stack<>();
        boolean flag = true;
        int first = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (first < temp) {
                for (int j = first+1; j <= temp; j++) {
                    st.push(j);
                    sb.append("+").append("\n");
                }
                first = temp;

            } else if (st.peek() != temp) {
                flag = false;
                break;
            }
            st.pop();
            sb.append("-").append("\n");

        }
        if(flag) System.out.println(sb);
        else System.out.println("NO");


    }
}
