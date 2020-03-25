package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Nono{
	int row;
	int col;
	Nono(int row,int col){
		this.row=row;
		this.col=col;
	}
}

public class 섬의개수4963 {
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	static Queue<Nono> queue;
	static boolean check[][];
	
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int M = sc.nextInt();
			int alpha=0;
			if(!(N==0&&M==0)) {
				queue=new LinkedList<>();
				int array[][] = new int[M][N];
				check=new boolean[M][N];
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						array[i][j] = sc.nextInt();
					}
				}
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						if(array[i][j] == 1) {
							bfs(i,j,M,N,check,array);
//							cnt++;
//							System.out.println(cnt);
							if(cnt!=0) {
								alpha++;
							}
							cnt=0;
						}
					}
				}
				System.out.println(alpha);
				cnt=0;
			}else break;
			
		}
		
	}
	static void bfs(int a,int b,int M,int N,boolean check[][],int array[][]) {
		if(check[a][b] == false) {
			check[a][b]=true;
			queue.add(new Nono(a,b));
			while(!queue.isEmpty()) {
				int x = queue.peek().row;
				int y = queue.peek().col;
				queue.poll();
					for(int j=0;j<8;j++) {
						if(x+dr[j]<0||y+dc[j]<0||x+dr[j]>M-1||y+dc[j]>N-1) continue;
						if(check[x+dr[j]][y+dc[j]]==false && array[x+dr[j]][y+dc[j]]==1) {
							check[x+dr[j]][y+dc[j]]=true;
							queue.add(new Nono(x+dr[j],y+dc[j]));
						}
					}
			}
			cnt++;
		}
	}
}