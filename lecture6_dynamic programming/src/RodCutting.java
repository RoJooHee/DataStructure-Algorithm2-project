public class RodCutting {
	/*길이n인 막대를 양의정수 크리고 잘라 얻을 수 있는 최대판매가격을 동적계획 이용해 계산
	입력 : n(막대길이).  price[0~~n-1]은 다른 길이의 막대들의 가격 배열
	출력 : 최대 판매가격(반환값) */
	static int cutRod_DP(int price[], int n) {
		int maxSell[] = new int[n+1]; //0번 인덱스 사용하지 않아서, n개 활용 위해 n+1크기로 만듦
		maxSell[0]=0; //0번인덱스는 사용하지 않기 때문
		
		for (int j=1; j<=n; j++) {
			int max_val=0;
			for(int k=1 ;k<=j; k++)
				max_val=Math.max(max_val, price[k-1]+maxSell[j-k]);
			maxSell[j]=max_val; }
		return maxSell[n]; }

	public static void main(String[] args) {
		int[] A = new int[] {2, 5, 9, 10};
		int size=A.length;
		System.out.println("동적계획 이용해 구한 최대 판매 금액 : "+cutRod_DP(A, size));
	}
}
