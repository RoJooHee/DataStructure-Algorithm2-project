import java.util.Arrays;
import java.util.Scanner;

public class one {
	public static int cross_time(int[] people_time, int num, String string) {
		// 사람이 한명 또는
		if (num > 3) {// 현재 문제에 해당
			int smallbig_move = Math.max(people_time[0], people_time[1]) + people_time[0]
					+ Math.max(people_time[num - 2], people_time[num - 1]) + people_time[1];
			int P1_move = Math.max(people_time[0], people_time[num - 1]) + people_time[0]
					+ Math.max(people_time[0], people_time[num - 2]) + people_time[0];

			int min_time = Math.min(smallbig_move, P1_move); //최단시간 소요 찾기
			if (smallbig_move<=P1_move) string += "smallbig_move ";
			else if (smallbig_move>P1_move) string += "P1_move ";
			
			return cross_time(people_time, num - 2, string)+min_time; }
		
		else if (num == 3) { // 3 people_number
			System.out.println("\n사용한 방법은 "+string+" 과 3명 건너기이다.");
			return people_time[0] + people_time[1] + people_time[2]; }
		
		else { // num<3 people_number
			if (num==2) {System.out.println("\n사용한 방법은 "+string+" 과 2명 건너기이다."); return people_time[1]; }
			else if (num==1) return people_time[0];
			else return 0;
			}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("총 건널 사람 수 : ");
		int people_number = s.nextInt(); // 사람 수

		int[] people_time = new int[people_number]; // 사람 별 걸리는 시간
		for (int i = 0; i < people_time.length; i++) {
			System.out.print(i + 1 + "번째 사람 걸리는 시간 : ");
			people_time[i] = s.nextInt();
		}
		Arrays.sort(people_time); // 문제를 위해 오름차순 정렬
		
		String string = "";
		System.out.println("\n따라서 모든 사람이 건너는 데 걸리는 총 시간은 <"+cross_time(people_time, people_number, string)+"> 분 이다");
	}
}