package S_0930;

import java.util.*;

//나중에 다시 풀기
//13292kb	124ms
public class G_1174 {
    static ArrayList<Long> arr = new ArrayList<>();

    public static void make(String num) {
        if (!num.equals("")) {
            arr.add(Long.parseLong(num));
        }

        for (int i = 0; i <= 9; i++) {
            if (num.length() == 0 || num.charAt(num.length() - 1) - '0' > i) {
                make(num + (char)('0' + i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        make("");

        Collections.sort(arr);
        int n = sc.nextInt();

        if (n > arr.size())
            System.out.println(-1);
        else
            System.out.println(arr.get(n-1));
    }
}