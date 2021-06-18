package lecture3_sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] intArray = { 45, 89, 67, 92, 53, 74, 26, 80 };
		System.out.print("���� �� �迭: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");

		insertionSort(intArray);

		System.out.print("\n���� �� �迭: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		}

	public static void insertionSort(int[] A) {
		int insertElement;
		int n = A.length;

		for (int i = 1; i < n; i++) {
			insertElement = A[i]; // ���ľȵ� �κ� ���� ���� ������ ���� ������ ��.
			int j = i - 1; // ���ĵ� �κ��� ���� ���� ��	-----j(i-1) ����o/����x insertelement(i)-----

			while (j >= 0 && A[j] > insertElement) {//j=0���� ũ�� A[j]���� insertelement���� Ŭ ��.
													//��, j=i-1~0(�۾���) & A[j]�� ������ ������ ū ���� ���
				A[j + 1] = A[j]; // A[j]�� �ϳ� ���� ���� A[j]�� �� ������ �� (���� ��ĭ �ڷ� �̵�)
				j=j-1; } // j-1 �� �ٿ���(�ϳ� ���� ��) �ٽ� while�� ���Ǵ�� ������. �� ��� ���ĵ� �κ��� �� �ϳ��� ���ϸ� �ڷ� �ű��
			
			A[j + 1] = insertElement; }// wihle�� Ż�������� A[j]�� insertelement���� �۴�. �׷��� j+1��ġ�� insertelement�� ����
	}
}