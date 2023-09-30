package S_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//35132kb	384ms
public class G_1655 {
    static int N;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> high = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> low = new PriorityQueue<>();

        while (N-- > 0) {

            int temp = Integer.parseInt(br.readLine());
            //사이즈 0 이면 하이에 추가 || 하이 꼭대기보다 작거나 같으면
            if(high.size() == 0 || high.peek() >= temp){
                high.add(temp);
            }
            else{
                low.add(temp);
            }
            //크기가 2이상 차이나면 1차이 나게 만들어주기
            if(high.size() > low.size()+1){
                low.add(high.poll());
            }

            else if(low.size() > high.size()){
                high.add(low.poll());
            }

            sb.append(high.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
