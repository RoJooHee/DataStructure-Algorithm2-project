import java.util.Arrays;
import java.util.Scanner;

public class one {
	public static int cross_time(int[] people_time, int num, String string) {
		// ����� �Ѹ� �Ǵ�
		if (num > 3) {// ���� ������ �ش�
			int smallbig_move = Math.max(people_time[0], people_time[1]) + people_time[0]
					+ Math.max(people_time[num - 2], people_time[num - 1]) + people_time[1];
			int P1_move = Math.max(people_time[0], people_time[num - 1]) + people_time[0]
					+ Math.max(people_time[0], people_time[num - 2]) + people_time[0];

			int min_time = Math.min(smallbig_move, P1_move); //�ִܽð� �ҿ� ã��
			if (smallbig_move<=P1_move) string += "smallbig_move ";
			else if (smallbig_move>P1_move) string += "P1_move ";
			
			return cross_time(people_time, num - 2, string)+min_time; }
		
		else if (num == 3) { // 3 people_number
			System.out.println("\n����� ����� "+string+" �� 3�� �ǳʱ��̴�.");
			return people_time[0] + people_time[1] + people_time[2]; }
		
		else { // num<3 people_number
			if (num==2) {System.out.println("\n����� ����� "+string+" �� 2�� �ǳʱ��̴�."); return people_time[1]; }
			else if (num==1) return people_time[0];
			else return 0;
			}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("�� �ǳ� ��� �� : ");
		int people_number = s.nextInt(); // ��� ��

		int[] people_time = new int[people_number]; // ��� �� �ɸ��� �ð�
		for (int i = 0; i < people_time.length; i++) {
			System.out.print(i + 1 + "��° ��� �ɸ��� �ð� : ");
			people_time[i] = s.nextInt();
		}
		Arrays.sort(people_time); // ������ ���� �������� ����
		
		String string = "";
		System.out.println("\n���� ��� ����� �ǳʴ� �� �ɸ��� �� �ð��� <"+cross_time(people_time, people_number, string)+"> �� �̴�");
	}
}