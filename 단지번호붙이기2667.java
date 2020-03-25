package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int row;
	int col;
	Pair(int row,int col){
		this.row=row;
		this.col=col;
	}
}

public class 단지번호붙이기2667 {
	//This is test word..
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int array[][] = new int[N][N];
	static boolean check[][] = new boolean[N][N];
	static Queue<Pair> queue = new LinkedList<>();
	static Queue<Integer> answer = new LinkedList<>();
	
	static int cnt=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			String st = sc.next();
			for(int j=0;j<N;j++) {
				array[i][j] = st.charAt(j)-'0';
			}
		}
		int alpha=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(array[i][j] == 1) {
					bfs(i,j);
					if(cnt!=0) {
						answer.add(cnt);
						alpha++;
					}
					cnt=0;
				}
			}
		}
		int answer_array[] = new int[alpha];
		for(int i=0;i<alpha;i++) {
			answer_array[i] = answer.poll();
		}
		Arrays.sort(answer_array);
		System.out.println(alpha);
		for(int i=0;i<alpha;i++) {
			System.out.println(answer_array[i]);
		}
		
	}
	static void bfs(int a,int b) {
		if(check[a][b] == false) {
			check[a][b]=true;
			queue.add(new Pair(a,b));
			int count=0;
			while(!queue.isEmpty()) {
				int x = queue.peek().row;
				int y = queue.peek().col;
				queue.poll();
				cnt++;
				for(int i=y;i<N;i++) {
					for(int j=0;j<4;j++) {
						if(x+dr[j]<0||y+dc[j]<0||x+dr[j]>N-1||y+dc[j]>N-1) continue;
						if(check[x+dr[j]][y+dc[j]]==false && array[x+dr[j]][y+dc[j]]==1) {
							check[x+dr[j]][y+dc[j]]=true;
							queue.add(new Pair(x+dr[j],y+dc[j]));
						}
					}
				}
			}
		}
	}
}