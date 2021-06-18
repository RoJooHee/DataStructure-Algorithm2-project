package lecture2_efficiency;
public class CumulativeSum {
	public static void main(String[] args) {
		int[] FREQ = {1, 0, 7, 5, 4}; //등급의 빈도
		int[] CUME; //등급 순으로 누계 빈도
		
		CUME=ComputeCumulativeSum2(FREQ);
		System.out.print("배열 CUME : ");
		
		for(int i=0; i<CUME.length; i++)
			System.out.print(CUME[i]+"\t");
	}
	public static int[] ComputeCumulativeSum2(int[] FREQ) {
		int n=FREQ.length; //FREQ의 길이
		int[] CUME= new int[n];
		CUME[0]=FREQ[0];
		for(int i=1; i<n; i++){
			CUME[i]=CUME[i-1]+FREQ[i]; //FREQ를 통해 CUME에 누계빈도 더하기
		}
		return CUME; //다 구해진 누계빈도
	}
}
