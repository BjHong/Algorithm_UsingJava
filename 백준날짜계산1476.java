package 백준알고리즘.Algorithm_UsingJava;
import java.util.Scanner;

public class 백준날짜계산1476 {
	//해결
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int e=1,m=1,s=1;
		int year=1;
		
		int E,S,M;
		Scanner sc=new Scanner(System.in);
		E=sc.nextInt();
		S=sc.nextInt();
		M=sc.nextInt();
		
		while(!(E==e&&S==s&&M==m)) {
			e++;
			s++;
			m++;
			if(e==16) e=1;
			if(s==29) s=1;
			if(m==20) m=1;
			year++;
			
		}
		System.out.println(year);

	}

}

