package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//실행시 아래 줄은 지워야댐!
import 백준알고리즘.Girl;
//이건살리고!
//class Girl{
//	int x,y;
//	Girl(int x,int y){
//		this.x=x;
//		this.y=y;
//	}
//}

public class 백준유기농배추1012 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int M,N,K;
	static int array[][];
	static boolean check[][];
	static Queue<Girl> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1;tc<=testcase;tc++) {
			M=sc.nextInt();
			N=sc.nextInt();
			K=sc.nextInt();
			array = new int[N][M];
			check = new boolean[N][M];
			queue = new LinkedList<>();
			int bug = 0;
			for(int i=0;i<K;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				array[b][a] = 1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!check[i][j] && array[i][j]==1) {
						bfs(i,j);
						bug++;
					}
				}
			}
			System.out.println(bug);
			
		}
	}
	static void bfs(int a,int b) {
		check[a][b] = true;
		queue.add(new Girl(a,b));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for(int i=0;i<4;i++) {
				if(x+dr[i]<0||y+dc[i]<0||x+dr[i]>N-1||y+dc[i]>M-1) continue;
				if(!check[x+dr[i]][y+dc[i]] && array[x+dr[i]][y+dc[i]]==1) {
					check[x+dr[i]][y+dc[i]] = true;
					queue.add(new Girl(x+dr[i],y+dc[i]));
				}
			}
		}
	}

}
