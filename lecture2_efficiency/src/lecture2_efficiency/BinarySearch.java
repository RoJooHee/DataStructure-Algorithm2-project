package lecture2_efficiency;

import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(int[] A, int first, int last, int target) {
		int result;
		if (first > last) return -1;// 잘못된 예
		else {
			int mid = (first + last) / 2;
			if (target == A[mid]) // target이 중간값이면 검색 끝
				result = mid;
			else if (target < A[mid]) // target이 중간값 보다 작으면
				result = binarySearch(A, first, mid - 1, target); // 작은 부분 이진탐색
			else // target이 중간값 보다 크면
				result = binarySearch(A, mid + 1, last, target); // 큰 부분 이진탐색
			return result; }
	}

	public static void main(String[] args) {
		int[] A = { 10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47 };
		Scanner s = new Scanner(System.in);
		for (;;) {
			System.out.print("검색을 원하는 숫자 : ");
			int target = s.nextInt();
			int n = A.length;
			int location;

			location = binarySearch(A, 0, n - 1, target);
			if (location == -1) {
				System.out.println("탐색값이 존재하지 않습니다.");
			} else
				System.out.println(target + "의 index = " + location); }
	}
}
