package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준벽부수고이동하기2206 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N;
	static int M;
	static boolean check[][];
	static int array[][];
	static int beta[][];
	static Queue<Nono> queue;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		queue = new LinkedList<>();
		array= new int[N][M];
		beta = new int[N][M];
		check= new boolean[N][M];
		for(int i=0;i<N;i++) {
			String a = sc.next();
			for(int j=0;j<M;j++) {
				array[i][j] = a.charAt(j)-'0';
			}
		}
		beta[0][0] = 1;
		check[0][0] = true;
		Bfs(0,0);
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(beta[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void Bfs(int i,int j) {
		queue.add(new Nono(i,j));
		while(!queue.isEmpty()) {
			int x = queue.peek().row;
			int y = queue.peek().col;
			queue.poll();
			for(int a=0;a<4;a++) {
				if(x+dr[a]<0||y+dc[a]<0||x+dr[a]>N-1||y+dc[a]>M-1) continue;
				if(check[x+dr[a]][y+dc[a]] ==false && array[x+dr[a]][y+dc[a]] == 0) {
					check[x+dr[a]][y+dc[a]] =true;
					beta[x+dr[a]][y+dc[a]] +=beta[x][y];
					queue.add(new Nono(x+dr[a],y+dc[a]));
				}
			}
		}
	}

}
