package 백준알고리즘.Algorithm_UsingJava;
//package 백준알고리즘;
//import java.util.ArrayList;
//import java.util.Scanner;
//import 백준알고리즘.Girl;
//
//class Triple {
//	int x, y, z;​
//	Triple(int x, int y, int z) {
//​		this.x = x;
//​		this.y = y;
//​		this.z = z;
//​	}
//}
//public class 백준로봇청소기4991_dfs {
//	static int dr[] = { -1, 0, 1, 0 };​
//	static int dc[] = { 0, 1, 0, -1 };​
//	static int w, h;​
//	static char array[][];​
//	static boolean check[][];​
//	static int robot_x, robot_y;​
//	static int min;​
//	static int alpha;​
//	static int answer;
//
//	​
//	static Girl start[];​
//	static Girl result[];​
//	static boolean perm_check[];​
//	static int perm_start;​
//	static int cnt;​
//	static char test[][];​
//	static int sample;
//
//	public static void main(String[] args) {
//
//​		Scanner sc = new Scanner(System.in);
//​		w = sc.nextInt();
//​		h = sc.nextInt();
//​		int minus = -1;
//​		boolean flag = true;
//​		while (flag) {
//​			array = new char[h][w];
//​			robot_x = 0;
//​			robot_y = 0;
//​			ArrayList<Girl> list = new ArrayList<>();
//​			for (int i = 0; i < h; i++) {
//​				String str = sc.next();
//​				for (int j = 0; j < w; j++) {
//​					array[i][j] = str.charAt(j);
//​					if (array[i][j] == 'o') {
//​						robot_x = i;
//​						robot_y = j;
//​					} else if (array[i][j] == '*') {
//​						list.add(new Girl(i, j));
//​					}
//​				}
//​			}
//​			test = array;
//​			start = new Girl[list.size()];
//​			result = new Girl[list.size()];
//​			for(int i=0;i<list.size();i++) {
//​				start[i] = new Girl(list.get(i).x,list.get(i).y);
//​			}
//​			perm_check = new boolean[list.size()];
//​			answer = Integer.MAX_VALUE;
//​			perm(0);
//
//​			if (alpha == 0) System.out.println(answer);
//​			else System.out.println(minus);
//	​		w = sc.nextInt();
//	​		h = sc.nextInt();
//​			if (w == 0 && h == 0) flag = false;
//		}	
//​		
//​	
//}
//
//	static void perm(int idx) {
//
//​		if(idx==result.length) {
//​			perm_start = 0;
//​			cnt = 0;
//​			test = array;
//​			for(int i=0;i<result.length;i++) {
//​				sample = 100000;
//​				check = new boolean[h][w];
//​				dfs(robot_x,robot_y,0);
//​				if(sample!=100000) {
//​					cnt+=sample
//​				}
//​				else break;
//​				perm_start++;
//​			}
//​			if(cnt==0) {
//​				alpha=1;
//​				return;
//​			}
//
//​			System.out.println();
//​			answer = Math.min(cnt, answer);
//​			return;
//​		}
//​		for(int i=0;i<start.length;i++) {
//​			if(!perm_check[i]) {
//​				perm_check[i]=true;
//​				result[idx] = start[i];
//​				perm(idx+1);
//​				perm_check[i]=false;
//​			}
//
//​		}
//
//​	}
//
//	​
//
//	static void dfs(int a,int b,int count) {
//
//​		check[a][b] = true;
//​		for(int i=0;i<4;i++) {
//
//​			if(a+dr[i]<0||b+dc[i]<0||a+dr[i]>h-1||b+dc[i]>w-1 || test[a+dr[i]][b+dc[i]]=='x') continue;
//
//​			if(!check[a+dr[i]][b+dc[i]]){
//
//​				if(a+dr[i]==result[perm_start].x && b+dc[i]==result[perm_start].y) {
//
//​					sample = Math.min(count+1, sample);
//
////					System.out.print(result[perm_start].x+" "+result[perm_start].y+" ");
//
//​					test[robot_x][robot_y] = '.';
//
//​					robot_x = a+dr[i];
//
//​					robot_y = b+dc[i];
//
//​					test[robot_x][robot_y] = 'o';
//
//​					return;
//
//​				}
//
//​				else {
//
//​					dfs(a+dr[i],b+dc[i],count+1);
//
//​				}
//
//​			}
//
//​		}
//
//​	}
//
//}