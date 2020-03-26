package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tell{
	int x,y,z;
	Tell(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

public class 백준점프게임15558 {
	static int N, K;
	static int dr[];
	static int array[][];
	static boolean check[][];
	static Queue<Tell> queue;
	
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		array = new int[2][N];
		check = new boolean[2][N];
		for (int i = 0; i < 2; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				array[i][j] = str.charAt(j) - '0';
			}
		}
		queue = new LinkedList<>();
		answer = 0;
		dr =new int[3];
		dr[0] = 1;
		dr[1] = -1;
		dr[2] = K;
		bfs(0,0);
		System.out.println(answer);
	}

	static void bfs(int a,int b) {
		check[a][b]=true;
		queue.add(new Tell(a,b,-1));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			int z = queue.peek().z;
			queue.poll();
			if(y<=z) continue;
			if(z!=-1) {
				array[0][z]=0;
				array[1][z]=0;
			}
			for(int i=0;i<3;i++) {
				if(y+dr[i]<0) continue;
				if(i==0) {
					if(y+dr[i]==N) {
						queue = new LinkedList<>();
						answer = 1;
						break;
					}
					else if(!check[x][y+dr[i]] && array[x][y+dr[i]]==1) {
						System.out.println(x+" "+(y+dr[i])+" "+(z+1));
						check[x][y+dr[i]]=true;
						queue.add(new Tell(x,y+dr[i],z+1));
					}
				}
				if(i==1) {
					if(!check[x][y+dr[i]] && array[x][y+dr[i]]==1) {
						System.out.println(x+" "+(y+dr[i])+" "+(z+1));
						check[x][y+dr[i]]=true;
						queue.add(new Tell(x,y+dr[i],z+1));						
					}
				}
				if(i==2) {
					if(y+dr[i]>=N) {
						queue = new LinkedList<>();
						answer = 1;
						break;
					}
					else {
						if(!check[1-x][y+dr[i]] && array[1-x][y+dr[i]]==1) {
							System.out.println(x+" "+(y+dr[i])+" "+(z+1));
							check[1-x][y+dr[i]]=true;
							queue.add(new Tell(1-x,y+dr[i],z+1));	
						}
					}
				}
			}
		}
	}
}
