package 백준알고리즘.Algorithm_UsingJava;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Girl{
	int x,y;
	Girl(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class 백준숨바꼭질1697 {
	static int N, K, count;
	static int dr[] = { -1, 1, 2 };
	static int beta[];
	static boolean check[];
	static Queue<Girl> queue;
	static int min;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		count = 0;
		check = new boolean[100001];
		queue = new LinkedList<>();
		min = Integer.MAX_VALUE;
		if (K < N) {
			while (true) {
				count++;
				N--;
				if (N == K)
					break;
			}
			System.out.println(count);
		} else {
			bfs(N);
			System.out.println(min);
		}

	}

	static void bfs(int a) {
		check[a] = true;
		queue.add(new Girl(a,0));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int count = queue.peek().y;
			queue.poll();
			if(x==K) {
				min = Math.min(count, min);
			}
			else {
				for(int i=0;i<3;i++) {
					if(i==0) {
						if(x-1<0) continue;
						else if(!check[x-1]) {
							check[x-1] = true;
							queue.add(new Girl(x-1 , count+1));
						}
					}
					else if(i==1) {
						if(x+1>100000) continue;
						else if(!check[x+1]) {
							check[x+1] = true;
							queue.add(new Girl(x+1 , count+1));
						}
					}
					else {
						if(x*2>100000) continue;
						else if(!check[x*2]) {
							check[x*2] = true;
							queue.add(new Girl(x*2,count+1));
						}
					}
				}
			}
		}
	}
}
