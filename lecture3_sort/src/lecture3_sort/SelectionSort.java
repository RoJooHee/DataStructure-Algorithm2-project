package lecture3_sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] intArray = { 89, 45, 67, 92, 39, 74, 26, 90 };
		System.out.print("���� �� �迭: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");

		selectionSort(intArray);

		System.out.print("\n���� �� �迭: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
	}

	public static void selectionSort(int[] A) {
		int min, temp;
		int n = A.length;
		
		for (int i = 0; i < n - 1; i++) { // i=n-1�̸� ���̶� �ּڰ� Ž���Ұ� ���� ����
			min = i; // ���� �ּڰ��� i�� ���� (i=0~n-2)
			for (int j = i + 1; j < n; j++) // (j=i+1~n-1) �׷� i+1 �κк��� min���� �� ���� ���� �ִ��� Ž��
				if (A[j] < A[min]) min = j; // ������ min�� j�� ���� ��(��ġ����)

			temp = A[min];
			A[min] = A[i]; // A[min=j]�� ���� A[i]�� ���� ������ ��(�ּڰ��� �ִ� �ڸ����� ���ĵ��� �����κ��� �� ó������ ��)
			A[i] = temp; // A[i]�� ���� A[min]�� ���� ������ ��(���ĵ��� �����κ��� �� ó�������� �ּڰ��� ��)
		}
	}
}
