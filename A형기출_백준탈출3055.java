package 백준알고리즘.Algorithm_UsingJava;

import java.util.Arrays;
import java.util.Scanner;

public class A형기출_백준탈출3055 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int R,C;
	static char array[][];
	static char new_array[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		array = new char[R][C];
		int bieber_x=0; 
		int bieber_y=0;
		//예상경로를 저장할 배열 new_array
		new_array = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = sc.next();
			for(int j=0;j<C;j++) {
				array[i][j] = str.charAt(j);
				if(array[i][j] == 'D') {
					bieber_x=i;
					bieber_y=j;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				new_array[i][j] = '.';
			}
		}
		new_array[bieber_x][bieber_y] = 'D';
		int beta = 0; // 혹시 비버가 듸져버리면 1로 바꿔서 출력값을 다른걸로 준당
		int answer = 0;
		int time = 0;
		boolean flag = true;
		while(flag) {
			time++;
			//skill is activated
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(array[i][j]=='*') {
						new_array[i][j] = '*';
						for(int k=0;k<4;k++) {
							if(i+dr[k]<0||j+dc[k]<0||i+dr[k]>R-1||j+dc[k]>C-1) continue;
							if(array[i+dr[k]][j+dc[k]] == 'X' || array[i+dr[k]][j+dc[k]] == 'D') continue;
							if(array[i+dr[k]][j+dc[k]] == '.' || array[i+dr[k]][j+dc[k]] == 'S') {
								new_array[i+dr[k]][j+dc[k]] = '*';
							}
						}
					}
					else if(array[i][j] == 'X') {
						new_array[i][j] = 'X';
					}
				}
			}
			//animal should run
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(array[i][j]=='S') {
						for(int k=0;k<4;k++) {
							if(i+dr[k]<0||j+dc[k]<0||i+dr[k]>R-1||j+dc[k]>C-1) continue;
							if(array[i+dr[k]][j+dc[k]] == 'X' || array[i+dr[k]][j+dc[k]] == '*' || new_array[i+dr[k]][j+dc[k]] == '*') continue;
							if(array[i+dr[k]][j+dc[k]] == 'D') {
								flag = false;
								answer = time;
								new_array[i+dr[k]][j+dc[k]] = 'S';
								break;
							}
							if(array[i+dr[k]][j+dc[k]] == '.') {
								new_array[i+dr[k]][j+dc[k]] = 'S';
							}
						}
					}
				}
			}
			//
			int alpha = 0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(new_array[i][j] == 'S'){
						alpha = 1;
						break;
					}
				}
			}
			if(alpha == 0) {
				flag = false;
				beta = 1;
			}
			
			array = new_array;
			//예상경로를 저장할 배열 new_array
			new_array = new char[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					new_array[i][j] = '.';
				}
			}
			new_array[bieber_x][bieber_y] = 'D';
			
		}
		
		if(beta == 0) {
			System.out.println(answer);
		}else {
			System.out.println("KAKTUS");
		}
		
	}

}
