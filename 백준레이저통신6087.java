package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class HIHI{
	int x,y,z;
	HIHI(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
public class 백준레이저통신6087 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int w, h;
	static char array[][];
	static int startCx, startCy;
	static int answer;
	static int check[][];
	static Queue<HIHI> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		array = new char[h][w];
		startCx = 0;
		startCy = 0; // startC setting
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == 'C') {
					if (startCx == 0 && startCy == 0) {
						startCx = i;
						startCy = j;
						array[i][j] = '.';
					}
				}
			}
		}
		queue = new LinkedList<>();
		check = new int[h][w];
		answer = 0;
		bfs(startCx, startCy);
		System.out.println(answer);

	}

	static void bfs(int a,int b) {
		check[a][b]=1;
		queue.add(new HIHI(a,b,0));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			int z = queue.peek().z;
			queue.poll();
			for(int i=0;i<4;i++) {
				if(x+dr[i]<0||x+dr[i]>h-1||y+dc[i]<0||y+dc[i]>w-1) continue;
				if(array[x+dr[i]][y+dc[i]]=='*') continue;
				if(array[x+dr[i]][y+dc[i]]=='C') {
					answer = z;
					queue = new LinkedList<>();
					break;
				}
				if(check[x+dr[i]][y+dc[i]]==0 && array[x+dr[i]][y+dc[i]]=='.') {
					if(i==1 || i==3) {
						if(z%2==0) {
							check[x+dr[i]][y+dc[i]] = z+1;
							queue.add(new HIHI(x+dr[i],y+dc[i],z+1));
						}
						else {
							check[x+dr[i]][y+dc[i]] = z;
							queue.add(new HIHI(x+dr[i],y+dc[i],z));
						}
					}
					else {
						if(z%2==1) {
							check[x+dr[i]][y+dc[i]] = z+1;
							queue.add(new HIHI(x+dr[i],y+dc[i],z+1));
						}
						else {
							check[x+dr[i]][y+dc[i]] = z;
							queue.add(new HIHI(x+dr[i],y+dc[i],z));
						}
					}
				}
			}
		}
	}

}
