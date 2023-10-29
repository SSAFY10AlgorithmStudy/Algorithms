package d1030;

import java.io.*;
import java.util.*;

public class bj2357 {

    static class Node {
        int mini, maxi;
        Node(){}
        Node(int mini, int maxi) {
            this.mini = mini;
            this.maxi = maxi;
        }
    }

    static int n, m;
    static int[] arr;
    static Node[] tree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 읽기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] ranges = new int[m][2];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            ranges[i][0] = Integer.parseInt(st.nextToken());
            ranges[i][1] = Integer.parseInt(st.nextToken());
        }

        tree = new Node[n*4]; // 사실 2n-1 크기 만큼만 필요한데, 이렇게 만들면 메모리 효율적으로 상용한다고함
        createTree(1, n, 1);

        for (int[] range: ranges) {
            Node r = findSeg(1, n, 1, range[0], range[1]);
            sb.append(r.mini).append(" ").append(r.maxi).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // start = 구간시작, end = 구간 끝, node = 트리에 노드 인덱스
    static Node createTree(int start, int end, int node) {
        tree[node] = new Node();
        if (start == end) {
            // 리프 노드
            tree[node].mini = arr[start];
            tree[node].maxi = arr[start];
            return tree[node];
        }
        int mid = (start + end) / 2;

        Node left = createTree(start, mid, node*2);
        Node right = createTree(mid+1, end, node*2+1);
        tree[node].mini = Math.min(left.mini, right.mini);
        tree[node].maxi = Math.max(left.maxi, right.maxi);
        return tree[node];
    }

    static Node findSeg(int left, int right, int node, int segLeft, int segRight) {
        if (left > segRight || right < segLeft) return new Node(Integer.MAX_VALUE, 0);
        if (left >= segLeft && right <= segRight) return tree[node];
        int mid = (left + right) / 2;
        Node l = findSeg(left, mid, node*2, segLeft, segRight);
        Node r = findSeg(mid+1, right, node*2+1, segLeft, segRight);
        return new Node(Math.min(l.mini, r.mini), Math.max(l.maxi, r.maxi));
    }

}