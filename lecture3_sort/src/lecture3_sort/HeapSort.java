package lecture3_sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] Array = { 0, 1, 2, 6, 4, 8, 7 };
		System.out.print("정렬 전 배열 : ");
		for (int i = 1; i < Array.length; i++) System.out.print(Array[i] + " ");

		heapSort(Array);

		System.out.print("\n정렬 후 배열 : ");
		for (int i = 1; i < Array.length; i++) System.out.print(Array[i] + " "); }

	public static void heapSort(int[] A) { //힙정렬
		int eh = A.length - 1;
		buildHeap(A, eh);

		while (eh > 1) {
			int temp = A[1];     A[1] = A[eh];     A[eh] = temp;
			eh = eh - 1;
			pushDown(A, 1, eh / 2, eh); } }

	public static void buildHeap(int[] A, int eh) { //힙으로 만들기
		int bh = (A.length - 1) / 2 + 1; //힙의 마지막 요소의 지수
		while (bh > 1) {
			bh = bh - 1;
			int x = bh;
			pushDown(A, x, bh, eh); } }

	public static void pushDown(int[] A, int x, int bh, int eh) { //힙속성 만족할 때 까지 A[x]를 트리 아래층으로 내려보내기
		int y = findLarger(A, x, eh);

		while (A[x] < A[y]) {
			int temp = A[x];     A[x] = A[y];     A[y] = temp;
			x = y;
			y = findLarger(A, x, eh); } }

	public static int findLarger(int[] A, int x, int eh) { //A[x]보다 더 큰값 가지는 x의 자식노드의 지수 구하기
		int y = 0;
		if (2 * x + 1 <= eh) {
			if (A[2 * x] > A[x] || A[2 * x + 1] > A[x]) {
				if (A[2 * x] >= A[2 * x + 1]) y = 2 * x;
				else y = 2 * x + 1; }
			} else if (2 * x <= eh && A[2 * x] > A[x]) y = 2 * x;
		return y; }
}
