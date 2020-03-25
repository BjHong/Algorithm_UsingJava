package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A형기출_숨바꼭질4_13913 {
	static int dr[] = {1,-1,2};
	static int N,K,large;
	static int array[];
	static boolean check[];
	static int count[];
	static String answer[];
	static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		answer = new String[100001];
		check = new boolean[100001];
		count = new int[100001];
		queue = new LinkedList<>();
		Arrays.fill(answer, "");
		bfs(N);
		System.out.println(count[K]);
		System.out.println(answer[K]);
	}
	static void bfs(int a) {
		check[a] = true;
		answer[a] = "a";
		count[a] = 1;
		queue.add(a);
		while(!queue.isEmpty()) {
			int x = queue.peek();
			queue.poll();
			if(x == K) break;
			int alpha = N-1;
			int beta = N+1;
			int lamda = N*2;
			if(check[alpha]==false) {
				check[alpha] = true;
				count[alpha] = count[x] +1;
				answer[alpha] = answer[x]+" alpha";
				queue.add(alpha);
			}
			if(check[beta]==false) {
				check[beta] = true;
				count[beta] = count[x] +1;
				answer[beta] = answer[x]+" beta";
				queue.add(beta);
			}
			if(check[lamda]==false) {
				check[lamda] = true;
				count[lamda] = count[x] +1;
				answer[lamda] = answer[x]+" lamda";
				queue.add(lamda);
			}
		}
	}
	

}
