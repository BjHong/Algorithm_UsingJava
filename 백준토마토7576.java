package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준토마토7576 {
//실행시킬때는 섬의개수4963에 Nono가 있기때문에 Nono클래스를 지우고 실행한다.
//static class Nono{
//	int row;
//	int col;
//	Nono(int row,int col){
//		this.row=row;
//		this.col=col;
//	}
//}
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Queue<Nono> queue = new LinkedList<>();
	static boolean check[][];
	static int beta[][];	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		
		beta = new int[N+1][M+1];
		check = new boolean[N+1][M+1];
		int array[][] = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				int a = sc.nextInt();
				if(a == 1) {
					queue.add(new Nono(i,j));
					beta[i][j] = 1;
					check[i][j] = true;
				}
				else if(a==-1) {
					beta[i][j] = 1;
					check[i][j] = true;
				}
				array[i][j]=a;
			}
		}
		Bfs(queue.peek().row,queue.peek().col,N,M,array,beta);
		int max=0,alpha=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(beta[i][j] == 0) {
					max = 0;
					alpha = 1;
					break;
				}
				else if(beta[i][j]>max) {
					max = beta[i][j];
				}
			}
			if(alpha==1) break;
			
		}
		System.out.println(max-1);
	}
	
	static void Bfs(int x,int y,int N,int M,int array[][],int beta[][]) {
		while(!queue.isEmpty()) {
			int a = queue.peek().row;
			int b = queue.peek().col;
			queue.poll();
			for(int j=0;j<4;j++) {
				if(a+dr[j]<1||b+dc[j]<1||a+dr[j]>N||b+dc[j]>M) continue;
				if(check[a+dr[j]][b+dc[j]]==false && array[a+dr[j]][b+dc[j]]==0) {
					check[a+dr[j]][b+dc[j]]=true;
					array[a+dr[j]][b+dc[j]]=1;
					beta[a+dr[j]][b+dc[j]] = beta[a][b]+1;
					queue.add(new Nono(a+dr[j],b+dc[j]));
				}
				else if(check[a+dr[j]][b+dc[j]]==false && array[a+dr[j]][b+dc[j]]==-1) {
					check[a+dr[j]][b+dc[j]]=true;
					beta[a+dr[j]][b+dc[j]] = 1;
				}
			}
		}
	}
}
