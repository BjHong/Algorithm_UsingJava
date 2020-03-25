package 백준알고리즘.Algorithm_UsingJava;

import java.util.ArrayList;
import java.util.Scanner;
import 백준알고리즘.Girl;


public class 백준연구소14502 {
	static int N,M;
	static int array[][];
	static ArrayList<Girl> list;
	static Girl virus[];
	static Girl comb_array[];
	static Girl result[];
	static boolean check[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		list = new ArrayList<>();
		result = new Girl[3];
		array = new int[N][M];
		virus = new Girl[2];
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				array[i][j] = sc.nextInt();
				if(array[i][j]==2) {
					if(virus[0].x==0) {
						virus[1] = new Girl(i,j);
						continue;
					}
					else {
						virus[0] = new Girl(i,j);						
					}
					
				}
				else if(array[i][j]==0) {
					list.add(new Girl(i,j));
					count++;
				}
			}
		}
		comb_array = new Girl[list.size()];
		check = new boolean[list.size()];
		for(int i=0;i<list.size();i++) {
			comb_array[i] = new Girl(list.get(i).x , list.get(i).y);
		}
	}
	static void comb(int idx,int good) {
		if(good == result.length) {
			return;
		}
		if(idx == array.length) return;
		if(!check[idx]) check[idx]=true;
		result[good] = comb_array[idx];
		comb(idx+1,good+1);
		comb(idx+1,good);
		
	}

}
