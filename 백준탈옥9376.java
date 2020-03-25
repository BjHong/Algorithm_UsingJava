package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 백준탈옥9376 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1;tc<=testcase;tc++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			char prison[][] = new char[h][w];
			for(int i=0;i<h;i++) {
				String str = sc.next();
				for(int j=0;j<w;j++) {
					prison[i][j] = str.charAt(j);
				}
			}
			
		}
	}

}
