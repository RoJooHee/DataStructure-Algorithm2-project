public class RodCutting {
	/*����n�� ���븦 �������� ũ���� �߶� ���� �� �ִ� �ִ��ǸŰ����� ������ȹ �̿��� ���
	�Է� : n(�������).  price[0~~n-1]�� �ٸ� ������ ������� ���� �迭
	��� : �ִ� �ǸŰ���(��ȯ��) */
	static int cutRod_DP(int price[], int n) {
		int maxSell[] = new int[n+1]; //0�� �ε��� ������� �ʾƼ�, n�� Ȱ�� ���� n+1ũ��� ����
		maxSell[0]=0; //0���ε����� ������� �ʱ� ����
		
		for (int j=1; j<=n; j++) {
			int max_val=0;
			for(int k=1 ;k<=j; k++)
				max_val=Math.max(max_val, price[k-1]+maxSell[j-k]);
			maxSell[j]=max_val; }
		return maxSell[n]; }

	public static void main(String[] args) {
		int[] A = new int[] {2, 5, 9, 10};
		int size=A.length;
		System.out.println("������ȹ �̿��� ���� �ִ� �Ǹ� �ݾ� : "+cutRod_DP(A, size));
	}
}
