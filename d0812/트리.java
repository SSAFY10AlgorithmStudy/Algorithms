// https://www.acmicpc.net/problem/1068
package d0812;

import java.io.*;
import java.util.*;

// memory 11605kb time 80ms
public class 트리 {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int root, leaves, ignore;
	
	public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 그래프 초기화
        for (int i=0; i<n; i++) { 
            graph.add(new ArrayList<Integer>());
        }

        // 그래프 입력
        for (int i=0; i<n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                graph.get(parent).add(i);
            } else {
                root = i;
            }
        }

        ignore = Integer.parseInt(br.readLine()); // 자르는 노드
        if (ignore == root) {
            System.out.println(0);
            return;
        }
        
        // 리프 노드 세기
        leaves = 0;
        countLeaves(root);
        System.out.println(leaves);
        
    }

    private static void countLeaves(int cur) {
        List<Integer> children = graph.get(cur);
        if (children.size() == 0) {
            leaves++;
        } else {
            for (int child: children) {
                if (child == ignore) {
                    if (children.size() == 1) leaves++;
                } else {
                    countLeaves(child);
                }
            }
        }
    }
	
}