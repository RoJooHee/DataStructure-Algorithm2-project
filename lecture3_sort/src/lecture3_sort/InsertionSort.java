package lecture3_sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] intArray = { 45, 89, 67, 92, 53, 74, 26, 80 };
		System.out.print("정렬 전 배열: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");

		insertionSort(intArray);

		System.out.print("\n정렬 후 배열: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		}

	public static void insertionSort(int[] A) {
		int insertElement;
		int n = A.length;

		for (int i = 1; i < n; i++) {
			insertElement = A[i]; // 정렬안된 부분 가장 앞쪽 값으로 지금 정렬할 값.
			int j = i - 1; // 정렬된 부분의 가장 뒷쪽 값	-----j(i-1) 정렬o/정렬x insertelement(i)-----

			while (j >= 0 && A[j] > insertElement) {//j=0보다 크고 A[j]값은 insertelement보다 클 때.
													//즉, j=i-1~0(작아짐) & A[j]가 정렬할 값보다 큰 동안 계속
				A[j + 1] = A[j]; // A[j]의 하나 뒷쪽 값이 A[j]의 값 가지게 함 (값을 한칸 뒤로 이동)
				j=j-1; } // j-1 값 줄여서(하나 앞쪽 값) 다시 while문 조건대로 돌도록. 즉 계속 정렬된 부분의 값 하나씩 비교하며 뒤로 옮기기
			
			A[j + 1] = insertElement; }// wihle문 탈출했으면 A[j]가 insertelement보다 작다. 그래서 j+1위치에 insertelement값 삽입
	}
}