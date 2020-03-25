package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class DFS와BFS {
	static Scanner sc = new Scanner(System.in);
	static int N=sc.nextInt();
	static int M=sc.nextInt();
	static int V=sc.nextInt();
	static int array[][] = new int[N+1][N+1];
	static boolean check[] = new boolean[N+1];
	static boolean check_bfs[] = new boolean[N+1];
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			array[a][b] = 1;
			array[b][a] = 1;
		}
		dfs(V);
		System.out.println();
		bfs(V);

	}
	static void dfs(int V){
		check[V] = true;
		System.out.print(V+" ");
		for(int i=1;i<=N;i++) {
			if(check[i]==false && array[V][i]==1) dfs(i);
		}
	}
	static void bfs(int V) {
		check_bfs[V] = true;
		queue.add(V);
		while(!queue.isEmpty()) {
			int x = queue.peek();
			System.out.print(queue.poll()+" ");
			for(int i=1;i<=N;i++) {
				if(array[x][i] == 1 && check_bfs[i]==false) {
					check_bfs[i] =true;
					queue.add(i);
				}
			}
		}
	}
}
