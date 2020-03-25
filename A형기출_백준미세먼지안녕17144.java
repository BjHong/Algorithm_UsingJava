package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class A형기출_백준미세먼지안녕17144 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	
	static int dru[] = {0,-1,0,1};
	static int dcu[] = {1,0,-1,0};
	
	static int drd[] = {0,1,0,-1};
	static int dcd[] = {1,0,-1,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		int array[][] = new int[R + 1][C + 1];
		int check[][] = new int[R + 1][C + 1];
		int chung_u = 0;
		int chung_d = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				array[i][j] = sc.nextInt();
				if (array[i][j] == -1) {
					if (chung_u == 0) {
						chung_u = i;
					} else
						chung_d = i;
				}
			}
		}
		for (int time = 1; time <= T; time++) {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (array[i][j] != 0 && array[i][j] != -1) {
						int alpha = array[i][j] / 5;
						int count = 0;
						for (int k = 0; k < 4; k++) {
							if (i + dr[k] < 1 || i + dr[k] > R || j + dc[k] < 1 || j + dc[k] > C
									|| array[i + dr[k]][j + dc[k]] == -1)
								continue;
							check[i + dr[k]][j + dc[k]] = check[i + dr[k]][j + dc[k]] + alpha;
							count++;
						}
						check[i][j] = check[i][j] + (array[i][j] - alpha * count);
					}
				}
			}
			check[chung_u][1] = -1;
			check[chung_d][1] = -1;

			int u = chung_u;
			int tmpa = 0;
			int tmpb = 0;
			int k=2;
			int p = 0;
			for(int i=0;i<4;i++) {
				while(true) {
					if(u+dru[i]*p>R||u+dru[i]*p<1||k+dcu[i]*p>C||k+dcu[i]*p<1) break;
					tmpa = check[u+dru[i]*p][k+dcu[i]*p];
					check[u+dru[i]*p][k+dcu[i]*p] = tmpb;
					if(tmpa ==-1)break;
					int tmp = tmpa;
					tmpa = tmpb;
					tmpb = tmp;
					p++;
				}
				if(i==0) {
					k=C;
					p=1;
				}
				else if(i==1) {
					k=C;
					p=1;
					u=1;
				}
				else if(i==2) {
					u=1;
					k=1;
					p=1; 
				}
			}
			
			int d = chung_d;
			tmpa=0;tmpb=0;
			p=0;k=2;
			for(int i=0;i<4;i++) {
				while(true) {
					if(d+drd[i]*p>R||d+drd[i]*p<1||k+dcd[i]*p>C||k+dcd[i]*p<1) break;
					tmpa = check[d+drd[i]*p][k+dcd[i]*p];
					check[d+drd[i]*p][k+dcd[i]*p] = tmpb;
					if(tmpa ==-1)break;
					int tmp = tmpa;
					tmpa = tmpb;
					tmpb = tmp;
					p++;
				}
				if(i==0) {
					k=C;
					p=1;
				}
				if(i==1) {
					k=C;
					d=R;
					p=1;
				}
				if(i==2) {
					d=R;
					k=1;
					p=1;
				}
			}
			check[chung_u][1] = -1;
			check[chung_d][1] = -1;

			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					array[i][j] = check[i][j];
					check[i][j] = 0;
				}
			}
			
		}
		int good = 0;
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(array[i][j]!=-1) good+=array[i][j];
			}
		}
		System.out.println(good);

	}

}
