package 백준알고리즘.Algorithm_UsingJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class A형기출_두배열의합2143 {
	static int T,N,M;
	static int array_N[];
	static int array_M[];
	static ArrayList<Integer> nlist;
	static ArrayList<Integer> mlist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		N=sc.nextInt();
		array_N = new int[N];
		for(int i=0;i<N;i++) {
			array_N[i] = sc.nextInt();
		}
		M=sc.nextInt();
		array_M = new int[M];
		for(int i=0;i<M;i++) {
			array_M[i] = sc.nextInt();
		}
		nlist = new ArrayList<>();
		mlist = new ArrayList<>();
		
		//start!
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=i;j<N;j++) {
				sum+=array_N[j];
				nlist.add(sum);
			}
		}
		for(int i=0;i<M;i++) {
			int sum = 0;
			for(int j=i;j<M;j++) {
				sum+=array_M[j];
				mlist.add(sum);
			}
		}
		Collections.sort(nlist);
		Collections.sort(mlist);
		
		HashMap<Integer, Integer> m1 = new HashMap<>();
		for(int x : nlist) {
			if(m1.containsKey(x)) {
				m1.put(x, m1.get(x)+1);
			} else {
				m1.put(x, 1);
			}
		}
		
		long count = 0;
		for(int x : mlist) {
			if(m1.containsKey(T-x)) {
				count+=m1.get(T-x);
			}
		}
		System.out.println(count);
		
	}

}
