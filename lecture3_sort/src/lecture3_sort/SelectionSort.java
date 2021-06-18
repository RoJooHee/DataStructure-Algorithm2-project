package lecture3_sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] intArray = { 89, 45, 67, 92, 39, 74, 26, 90 };
		System.out.print("정렬 전 배열: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");

		selectionSort(intArray);

		System.out.print("\n정렬 후 배열: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
	}

	public static void selectionSort(int[] A) {
		int min, temp;
		int n = A.length;
		
		for (int i = 0; i < n - 1; i++) { // i=n-1이면 끝이라 최솟값 탐색할게 없기 때문
			min = i; // 현재 최솟값을 i로 잡음 (i=0~n-2)
			for (int j = i + 1; j < n; j++) // (j=i+1~n-1) 그럼 i+1 부분부터 min보다 더 작은 값이 있는지 탐색
				if (A[j] < A[min]) min = j; // 있으면 min은 j의 값이 됨(위치정보)

			temp = A[min];
			A[min] = A[i]; // A[min=j]의 값은 A[i]의 값을 가지게 됨(최솟값이 있던 자리에는 정렬되지 않은부분의 맨 처음값이 들어감)
			A[i] = temp; // A[i]의 값은 A[min]의 값을 가지게 됨(정렬되지 않은부분의 맨 처음값에는 최솟값이 들어감)
		}
	}
}
