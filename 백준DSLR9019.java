package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준DSLR9019 {
	static int A, B;
	static boolean check[];
	static Queue<Integer> queue;
	static String answer[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			check = new boolean[10001];
			answer = new String[10001];
			Arrays.fill(answer, "");
			queue = new LinkedList<>();
			bfs(A);
			System.out.println(answer[B]);
		}
	}

	static void bfs(int a) {
		check[a] = true;
		queue.add(a);
		while (!queue.isEmpty()) {
			int x = queue.peek();
			queue.poll();
			if(x == B) break;
			int alpha = (x * 2) % 10000;
			int beta = 0;
				if(x == 0) beta = 9999;
				else beta = x-1;
			int lamda = 0;
				int tmp = x;
				int d1 = tmp / 1000;
				tmp %= 1000;
				int d2 = tmp / 100;
				tmp %= 100;
				int d3 = tmp / 10;
				int d4 = tmp % 10;
			lamda = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
//			lamda = (x%1000)*10 + x/1000;
			int delta = 0;
				tmp = x;
				d1 = tmp / 1000;
				tmp %= 1000;
				d2 = tmp / 100;
				tmp %= 100;
				d3 = tmp / 10;
				d4 = tmp % 10;
			delta = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
//			delta = (x%10)*1000 + x/10;
			if(check[alpha]==false) {
				answer[alpha] = answer[x] + "D";
				check[alpha] = true;
				queue.add(alpha);
			}
			if(check[beta]==false) {
				answer[beta] = answer[x] + "S";
				check[beta] = true;
				queue.add(beta);
			}
			if(check[lamda]==false) {
				answer[lamda] = answer[x] + "L";
				check[lamda] = true;
				queue.add(lamda);
			}
			if(check[delta]==false) {
				answer[delta] = answer[x] + "R";
				check[delta] = true;
				queue.add(delta);
			}
			
		}
	}

}
