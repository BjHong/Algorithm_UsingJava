package 백준알고리즘.Algorithm_UsingJava;

import java.util.Scanner;

public class 소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int next = sc.nextInt();
		
		boolean check[] = new boolean[next+1];
		check[0] = true; check[1] = true;
		
		for(int i=2;i<=next;i++) {
			if(check[i]==true) {
				continue;
			}
			for(int j=i*2;j<=next;j+=i) {
				check[j] = true;
			}
		}
		for(int i=first;i<=next;i++) {
			if(check[i]==false) {
				System.out.println(i);
			}
		}

	}
}
//import java.util.Scanner;
//
//public class 소수구하기
//{
//	public static void main(String[] args) {
//		long beforeTime = System.currentTimeMillis();
//	    Scanner sc = new Scanner(System.in);
//	    int n = sc.nextInt();
//	    int m = sc.nextInt();
//	    boolean[] check = new boolean[m+1];
//	    check[0] = true; check[1] = true;
//	    for(int i=2; i<=m; i++){
//	        if(check[i] == true){
//	            continue;
//	        }
//	        for(int j=i*2; j<=m; j+=i){
//	            check[j] = true;
//	        }
//	    }
//	    for(int i=n; i<=m; i++){
//	        if(check[i] == false){
//	            System.out.println(i);
//	        }
//	    }
//	    long afterTime = System.currentTimeMillis(); 
//	    long secDiffTime = (afterTime - beforeTime)/1000;
//	    System.out.println("시간차이(m) : "+secDiffTime);
//	}
//}