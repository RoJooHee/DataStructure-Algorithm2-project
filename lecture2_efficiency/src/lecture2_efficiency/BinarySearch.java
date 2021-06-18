package lecture2_efficiency;

import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(int[] A, int first, int last, int target) {
		int result;
		if (first > last) return -1;// �߸��� ��
		else {
			int mid = (first + last) / 2;
			if (target == A[mid]) // target�� �߰����̸� �˻� ��
				result = mid;
			else if (target < A[mid]) // target�� �߰��� ���� ������
				result = binarySearch(A, first, mid - 1, target); // ���� �κ� ����Ž��
			else // target�� �߰��� ���� ũ��
				result = binarySearch(A, mid + 1, last, target); // ū �κ� ����Ž��
			return result; }
	}

	public static void main(String[] args) {
		int[] A = { 10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47 };
		Scanner s = new Scanner(System.in);
		for (;;) {
			System.out.print("�˻��� ���ϴ� ���� : ");
			int target = s.nextInt();
			int n = A.length;
			int location;

			location = binarySearch(A, 0, n - 1, target);
			if (location == -1) {
				System.out.println("Ž������ �������� �ʽ��ϴ�.");
			} else
				System.out.println(target + "�� index = " + location); }
	}
}
