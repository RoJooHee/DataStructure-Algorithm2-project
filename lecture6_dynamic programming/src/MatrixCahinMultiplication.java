public class MatrixCahinMultiplication {
	/* M1 X M2 X .. X Mn�� ����ϱ� ���� �ּҰ���Ƚ���� ������ȹ �̿��� ����
	���� ��ĵ� ��:n  ��� Mi, i=1~n�� r[i-1] x r[i]���*/
	
	static int MatrixMult_DP(int r[], int n) {
		int m[][]=new int[n][n];
		int i, j, k, len, q;
		
		for(i=1; i<n; i++) m[i][i]=0;
		
		for(len=1; len<n-1; len++) {
			for(i=1; i<n-len; i++) {
				j=i + len;
				[i][j]=Integer.MAX_VALUE;
				
				for(k=i; k<j; k++) {
					q=m[i][k]+m[k+1][j]+r[i-1]*r[k]*r[j];
					if(q<m[i][j]) m[i][j]=q; }
				} }
		return m[1][n-1];
	}
	
	public static void main(String[] args) {
		int arr[]= {10, 20,  50, 1, 100};
		int size=arr.length;
		System.out.println("������ȹ �̿��� �ּҰ���Ƚ�� : "+ MatrixMult_DP(arr, size));
	}
}