package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class A형기출_백준큐빙 {
	//아직못품
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1;tc<=testcase;tc++) {
			int N=sc.nextInt();
			char array_u[][]= {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			char array_d[][]= {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			char array_l[][]= {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			char array_f[][]= {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			char array_r[][]= {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
			char array_b[][]= {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			for(int i=0;i<N;i++) {
				String a = sc.next();
				switch(a) {
				case "U+":
					char array_check[][] =new char[3][3];
					for(int j=0;j<3;j++) {
						for(int k=0;k<3;k++) {
							array_check[j][k] = array_u[3-k][j];
						}
					}
					break;
				case "U-":
					break;
				case "D+":
					break;
				case "D-":
					break;
				case "F+":
					break;
				case "F-":
					break;
				case "B+":
					break;
				case "B-":
					break;
				case "L+":
					break;
				case "L-":
					break;
				case "R+":
					break;
				case "R-":
					break;
				}
			}
		}

	}

}
