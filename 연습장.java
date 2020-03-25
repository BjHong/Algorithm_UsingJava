package 백준알고리즘.Algorithm_UsingJava;

public class 연습장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rearr[] = {1,2,3};
		char charr[] = new char[rearr.length];
		for(int i=0;i<rearr.length;i++) {
			charr[i] = Integer.toString(rearr[i]).charAt(0);
	}
		for(int i=0; i<charr.length; i++) {
			System.out.print(charr[i]+" ");
		}

}
	}
