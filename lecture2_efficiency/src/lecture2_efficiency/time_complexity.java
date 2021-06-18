package lecture2_efficiency;

import java.util.Scanner;

public class time_complexity {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("계산 원하는 수 입력 : ");
		int num1 = 0;
		int n = s.nextInt();
		int square = n * n;
		num1= num1+1;
		System.out.println("계산 결과 : "+square);
		System.out.println("계산 횟수 : "+num1);

		int num3=0;
		square=0;
				for(int i=1; i<=n; i++) {
					for (int j=1; j<=n; j++) {
						num3= num3+1;
						square=square+1;}
						return square;
				}
	}
}
