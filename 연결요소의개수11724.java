package 백준알고리즘.Algorithm_UsingJava;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 연결요소의개수11724 {
	static Scanner sc = new Scanner(System.in);
	static int N=sc.nextInt();
	static int M=sc.nextInt();
	static int array[][] = new int[N+1][N+1];
	static boolean check[] = new boolean[N+1];
	static Queue<Integer> queue = new LinkedList<>();
	static int num = 1;
	static int count=0;
	static int answer = 1;
	public static void main(String[] args) {
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			array[a][b] = 1;
			array[b][a] = 1;
		}
		while(count!=1) {
			bfs(num);
			int memory = 0;
			int alpha = 0;
			for(int i=1;i<=N;i++) {
				if(check[i] == false) {
					alpha = 1;
					memory = i;
					answer++;
					break;
				}
			}
			if(alpha == 0) {
				count=1;
			}
			else {
				num = memory;
			}
		}
		System.out.println(answer);
	}
	static void bfs(int V) {
		check[V] = true;
		queue.add(V);
		while(!queue.isEmpty()) {
			int x = queue.peek();
			queue.poll();
			for(int i=1;i<=N;i++) {
				if(array[x][i] == 1 && check[i]==false) {
					check[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
