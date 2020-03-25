package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//골5
class Bad{
	int x;
	int y;
	Bad(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class A형기출_인구이동16234 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N,L,R;
	static int array[][];
	static boolean check[][];
	static Queue<Bad> queue;
	static int gogo[][];
	static int k;
	static int answer;
	
	static int karray[];
	static int kcount[];
	static int kavg[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		L=sc.nextInt();
		R=sc.nextInt();
		array = new int[N][N];
		queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				array[i][j] = sc.nextInt();
			}
		}
		answer = 0;
		while(true) {
			k=1;
			gogo = new int[N][N];
			check = new boolean[N][N];
			karray = new int[N*N+1];
			kcount = new int[N*N+1];
			kavg = new int[N*N+1];
			int alpha=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!check[i][j]) {
						alpha++;
						dfs(i,j);
						k++;
					}
				}
			}
			if(alpha==N*N) break;
			for(int i=1;i<k;i++) {
//				int avg = 0;
//				avg = karray[i] / kcount[i];
				for(int j=0;j<N;j++) {
					for(int p=0;p<N;p++) {
						if(gogo[j][p]==i) {
							array[j][p] = kavg[i];
						}
					}
				}
			}
			
			answer++;
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(answer);
	}
	static void bfs(int a,int b) {
		check[a][b] = true;
		gogo[a][b] = k;
		karray[k]+=array[a][b];
		kcount[k]++;
		kavg[k] = karray[k]/kcount[k];
		queue.add(new Bad(a,b));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for(int i=0;i<4;i++) {
				if(x+dr[i]<0||y+dc[i]<0||x+dr[i]>N-1||y+dc[i]>N-1) continue;
				if(!check[x+dr[i]][y+dc[i]]&&gogo[x+dr[i]][y+dc[i]]==0 && L<=(int)Math.abs(array[x][y] - array[x+dr[i]][y+dc[i]])
						&&(int)Math.abs(array[x][y] - array[x+dr[i]][y+dc[i]])<=R ) {
					gogo[x+dr[i]][y+dc[i]]=k;
					karray[k]+=array[x+dr[i]][y+dc[i]];
					kcount[k]++;
					kavg[k] = karray[k]/kcount[k];
					check[x+dr[i]][y+dc[i]] = true;
					queue.add(new Bad(x+dr[i],y+dc[i]));
				}
			}
		}
	}
	static void dfs(int a,int b) {
		check[a][b] = true;
		gogo[a][b] = k;
		karray[k]+=array[a][b];
		kcount[k]++;
		kavg[k] = karray[k]/kcount[k];
		for(int i=0;i<4;i++) {
			if(a+dr[i]<0||b+dc[i]<0||a+dr[i]>N-1||b+dc[i]>N-1) continue;
			if(!check[a+dr[i]][b+dc[i]]&&gogo[a+dr[i]][b+dc[i]]==0 && L<=(int)Math.abs(array[a][b] - array[a+dr[i]][b+dc[i]])
					&&(int)Math.abs(array[a][b] - array[a+dr[i]][b+dc[i]])<=R ) {
				dfs(a+dr[i],b+dc[i]);
			}
		}
	}

}
