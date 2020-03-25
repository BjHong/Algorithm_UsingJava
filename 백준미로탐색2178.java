package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//실행시킬때는 섬의개수에 Nono가 있기때문에 Nono클래스를 지우고 실행한다.
//class Nono{
//	int row;
//	int col;
//	Nono(int row,int col){
//		this.row=row;
//		this.col=col;
//	}
//}
public class 백준미로탐색2178 {
	static Queue<Nono> queue;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static boolean check[][];
	static int beta[][];	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		queue = new LinkedList<>();
		beta = new int[N+1][M+1];
		check = new boolean[N+1][M+1];
		int array[][] = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String a = sc.next();
			for(int j=0;j<M;j++) {
				array[i][j+1] = a.charAt(j)-'0';
			}
		}
		int startx=1,starty=1;
		check[startx][starty] = true;
		beta[startx][starty] = 1;
		queue.add(new Nono(startx,starty));
		Bfs(startx,starty,N,M,array,beta);
		
		System.out.println(beta[N][M]);
	}
	static void Bfs(int x,int y,int N,int M,int array[][],int beta[][]) {
		while(!queue.isEmpty()) {
			int a = queue.peek().row;
			int b = queue.peek().col;
			queue.poll();
			for(int j=0;j<4;j++) {
				if(a+dr[j]<1||b+dc[j]<1||a+dr[j]>N||b+dc[j]>M) continue;
				if(check[a+dr[j]][b+dc[j]]==false && array[a+dr[j]][b+dc[j]]==1) {
					check[a+dr[j]][b+dc[j]]=true;
					beta[a+dr[j]][b+dc[j]] = beta[a][b]+1;
					queue.add(new Nono(a+dr[j],b+dc[j]));
				}
			}
		}
	}

}
