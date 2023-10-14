package S_1014;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//273372kb	1632ms
public class S_18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //최대 100만번 배열꺼내서 출력하는데 스트링빌더 안쓰면 시간초과??
        StringBuilder sb = new StringBuilder();

        //value 값으로 정렬
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x,o2.x);
            }
        });
        //정답리스트
        int answerList[];
        //N 입력받기
        int N = Integer.parseInt(br.readLine());
        answerList = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pq.add(new Point(Integer.parseInt(s[i]),i));
        }
        //cnt
        int cnt = 0;
        int beforeInt = Integer.MIN_VALUE;
        //작은수로 정렬된 것에서 같거나 다르거나
        while(!pq.isEmpty()){
            //가장 작은 수 부터 꺼내면서
            Point point = pq.poll();
            //같지 않으면 cnt 증가 후 가장 작은 수 갱신
            if(beforeInt != point.x){
                beforeInt = point.x;
                answerList[point.y] = cnt++;

            }
            //같으면 현재 카운트에서 -1한 값 저장
            else{
                answerList[point.y] = cnt-1;
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(answerList[i]).append(" ");
        }
        System.out.println(sb);
    }

}