import java.util.Scanner;

class Queen {
	int row, col;
	
	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class num1_queen {
	public static int N = 0; // ü������ ũ��
	public static int[][] position_queen = null; // ü���ǿ��� queen�� �ִ� ��ǥ
	public static int[][] check_position = null; // ���� ���� ���� ������ ��ġ(��ǥ)���� Ȯ���ϱ� ���� ��ǥ
	public static int num_queen = 0; // ������� queen�� ��ġ�� row ��

	private static void dfs(Queen queen) {
		if (queen.row == N) return; // row�� N�̸� ������ Ž���� �� ���⿡ return

		for (int i = 0; i < N; i++) {
			queen.col = i;

			if (check(queen)) { // ���� ��ǥ�� ���� ��ġ�ص� �Ǵ��� Ȯ���ؼ� �����ϸ�(true),
				check_position[num_queen][0] = queen.row; // ���� row ����
				check_position[num_queen][1] = queen.col; // ���� col ����
				num_queen++; // ������� ��ġ�� �� �� ����
				
				position_queen[queen.row][queen.col] = 1; // ���� ��ǥ�� ���� ����

				if (queen.row == N - 1) result_position_queen(); // ü���� ������ Ž�������� ü���� ���

				queen.row++; // ���� ��ǥ�� queen �� ��ġ�� �� ���� row���� ��ġ ������ ��ǥ ã�� ���� dfs ����
				dfs(queen);

				queen.row--; // queen�� ������ ��ġ��� ���� ��ġ���� �ǵ��ư� dfs �����ϵ��� row ����
				queen.col = i;
				num_queen--; // ������� ��ġ�� queen �� ����
				position_queen[queen.row][queen.col] = 0; } // ������ ��ġ�ߴ� queen�� ��ǥ �ٽ� �ʱ�ȭ��
		}
	}

	private static boolean check(Queen queen) { // ���� �� �ִ� ��ġ�̸� true, �ƴϸ� false ��ȯ
		if (queen.row == 0) return true; // ó�� �������� 0�� �ش��ϴ� row������ ��� col���� ��ġ ����
			
		for (int i = 0; i < num_queen; i++) { // ������� ��ġ�� queen ����ŭ check_position(queen��ǥ��) Ȯ����
			if ((check_position[i][1] == queen.col) || // ���� col �̰ų� ( ���� row�� dfs�� ���ؼ� ����x)
					Math.abs(check_position[i][0] - queen.row) == Math.abs(check_position[i][1] - queen.col)) // ����(x��ǥ-row) == ����(y��ǥ-col)�밢���̸�
				return false; // ��ġ �Ұ���
		}
		return true; }

	private static void result_position_queen() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// row�� col�� �Ѵ� ¦�� or �Ѵ� Ȧ���̸� �Ͼ� ��
				if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
					if (position_queen[i][j] == 0) System.out.print("��" + " "); // queen ��ġ X
					else System.out.print("Q "); } // queen ��ġ O
				else {// row�� col�� ���� ¦��, Ȧ���� �ش��ϸ� ���� ��
					if (position_queen[i][j] == 0) System.out.print("��" + " "); // queen ��ġ X
					else System.out.print("Q "); } // queen ��ġ O
			}
			System.out.println();
		}
		System.out.println("--------"); }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ������(n���� ���� n*n�� ü�� ���� �����մϴ�)? ");
		N = scanner.nextInt();
		System.out.println();

		num_queen = 0;
		position_queen = new int[N][N]; //ü����
		check_position = new int[N][2]; //queen ��ġ ��ǥ ���� ����
		dfs(new Queen(0, 0)); // dfs�� queen ��ġ Ž��

		scanner.close();
	}
}