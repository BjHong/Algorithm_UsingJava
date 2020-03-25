package 백준알고리즘.Algorithm_UsingJava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import 백준알고리즘.Boy;


public class 백준열쇠9328 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int h, w;
	static char array[][];
	static ArrayList<Character> small_alphabet, big_alphabet , keys;
	// bfs
	static boolean check[][];
	static Queue<Boy> queue;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		small_alphabet = new ArrayList<>();
		big_alphabet = new ArrayList<>();
		//all of alphabets contain
		for (int i = 0; i < 26; i++) {
			small_alphabet.add((char) ('a' + i));
			big_alphabet.add((char) ('A' + i));
		}
		//testcase start!
		for (int tc = 1; tc <= testcase; tc++) {
			h = sc.nextInt();
			w = sc.nextInt();
			array = new char[h][w];
			keys = new ArrayList<>();   //collecting keys
			count = 0; //potential answer
			for (int i = 0; i < h; i++) { //put the letter of question
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					array[i][j] = str.charAt(j);
				}
			}
			
			String firstKey = sc.next(); //put firstKey into keys
			if(!firstKey.equals("0")) {
				for(int i=0;i<firstKey.length();i++) {
					keys.add(firstKey.charAt(i));
				}
			}
//			System.out.println(keys); //checking keys list
			boolean flag = true; //flag roll
			while(flag) {
				int alpha=count; 
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (i == 0 || i == h - 1) {
							if (array[i][j] == '.' || small_alphabet.contains(array[i][j])
									|| big_alphabet.contains(array[i][j]) || array[i][j]=='$') {
								if(big_alphabet.contains(array[i][j])) {
									if(!keys.contains((char)(array[i][j]+32))) continue;
								}
//								System.out.println(i+" "+j);
								queue = new LinkedList<>();
								check = new boolean[h][w];
								bfs(i, j);
							}
						}
						if (j == 0 || j == w - 1) {
							if (array[i][j] == '.' || small_alphabet.contains(array[i][j])
									|| big_alphabet.contains(array[i][j]) ||array[i][j]=='$') {
								if(big_alphabet.contains(array[i][j])) {
									if(!keys.contains((char)(array[i][j]+32))) continue;
								}
//								System.out.println(i+" "+j);
								queue = new LinkedList<>();
								check = new boolean[h][w];
								bfs(i, j);
							}
						}
					}
				}
				if(count==alpha) flag=false;
				
			}
			System.out.println(count);

		}
	}

	static void bfs(int a, int b) {
		if (small_alphabet.contains(array[a][b])) {
			if (!keys.contains(array[a][b])) keys.add(array[a][b]);
		}
		if(array[a][b]=='$') {
			count++;
			array[a][b]='.';
		}
		check[a][b] = true;
		queue.add(new Boy(a, b));
		while (!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				if (x + dr[i] < 0 || x + dr[i] > h - 1 || y + dc[i] < 0 || y + dc[i] > w - 1)
					continue;
				if (array[x + dr[i]][y + dc[i]] == '*')
					continue;
				if (array[x + dr[i]][y + dc[i]] == '$') {
					count++;
					array[x + dr[i]][y + dc[i]] = '.';
					check[x + dr[i]][y + dc[i]] = true;
					queue.add(new Boy(x + dr[i], y + dc[i]));
//					for(int k=0;k<h;k++) {
//						for(int p=0;p<w;p++) {
//							System.out.print(array[k][p]+" ");
//						}
//						System.out.println();
//					}
//					System.out.println(keys);
				} else if (!check[x + dr[i]][y + dc[i]]
						&& (array[x + dr[i]][y + dc[i]] == '.' || small_alphabet.contains(array[x + dr[i]][y + dc[i]])
						|| big_alphabet.contains(array[x + dr[i]][y + dc[i]]) )) {
					if(big_alphabet.contains(array[x + dr[i]][y + dc[i]])) {
						if(!keys.contains((char)(array[x + dr[i]][y + dc[i]]+32))) continue;
						else {
							check[x + dr[i]][y + dc[i]] = true;
							queue.add(new Boy(x + dr[i], y + dc[i]));
							continue;
						}
					}
					if (small_alphabet.contains(array[x + dr[i]][y + dc[i]])) {
						if (!keys.contains(array[x + dr[i]][y + dc[i]])) {
							keys.add(array[x + dr[i]][y + dc[i]]);
							queue = new LinkedList<>();
							check = new boolean[h][w];							
						}
							
					}
					check[x + dr[i]][y + dc[i]] = true;
					queue.add(new Boy(x + dr[i], y + dc[i]));
				}
			}
		}
	}

}
