package 백준알고리즘.Algorithm_UsingJava;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class Boy{
	int x;
	int y;
	Boy(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class 백준물통2251 {
	static int A,B,C,total;
	static int array[];
	static List<Integer> answer;
	static Queue<Boy> queue;
	static boolean check[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A=sc.nextInt();  //8
		B=sc.nextInt(); // 9
		C=sc.nextInt(); //10
		total = C;
		check = new boolean[201][201];
		answer = new LinkedList<>();
		
		queue = new LinkedList<>();
		bfs(0,0,C);
		Collections.sort(answer);
		for(int i=0;i<answer.size();i++) {
			System.out.print(answer.get(i));
			if(i==answer.size()-1) break;
			System.out.print(" ");
		}
	}
	static void bfs(int a,int b,int c) {
		queue.add(new Boy(a,b));
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			int z = total-(x+y);
			queue.poll();
			
			if(check[x][y]) continue;
			if(x==0) {
				answer.add(z);
			}
			check[x][y] = true;
			//A->B
			if(x+y<=B) {
				queue.add(new Boy(0,x+y));
			}else {
				queue.add(new Boy(x+y-B,B));
			}
			//A->C
			if(x+z<=C) {
				queue.add(new Boy(0,y));
			}else {
				queue.add(new Boy(x+z-C,y));
			}
			//B->A
			if(x+y<=A) {
				queue.add(new Boy(x+y,0));
			}else {
				queue.add(new Boy(A,x+y-A));
			}
			//B->C
			if(y+z<=C) {
				queue.add(new Boy(x,0));
			}else {
				queue.add(new Boy(x,y+z-C));
			}
			//C->A
			if(x+z<=A) {
				queue.add(new Boy(x+z,y));
			}else {
				queue.add(new Boy(A,y));
			}
			//C->B
			if(y+z<=B) {
				queue.add(new Boy(x,y+z));
			}else {
				queue.add(new Boy(x,B));
			}
		}
		
	}

}
