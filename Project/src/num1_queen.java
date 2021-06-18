import java.util.Scanner;

class Queen {
	int row, col;
	
	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class num1_queen {
	public static int N = 0; // 체스판의 크기
	public static int[][] position_queen = null; // 체스판에서 queen이 있는 좌표
	public static int[][] check_position = null; // 퀸이 서로 공격 가능한 위치(좌표)인지 확인하기 위한 좌표
	public static int num_queen = 0; // 현재까지 queen이 배치된 row 수

	private static void dfs(Queen queen) {
		if (queen.row == N) return; // row가 N이면 끝나서 탐색할 것 없기에 return

		for (int i = 0; i < N; i++) {
			queen.col = i;

			if (check(queen)) { // 현재 좌표에 퀸을 배치해도 되는지 확인해서 가능하면(true),
				check_position[num_queen][0] = queen.row; // 현재 row 저장
				check_position[num_queen][1] = queen.col; // 현재 col 저장
				num_queen++; // 현재까지 배치된 퀸 수 증가
				
				position_queen[queen.row][queen.col] = 1; // 현재 좌표에 퀸을 놓음

				if (queen.row == N - 1) result_position_queen(); // 체스판 끝까지 탐색했으면 체스판 출력

				queen.row++; // 현재 좌표에 queen 을 배치한 후 다음 row에서 배치 가능한 좌표 찾기 위해 dfs 수행
				dfs(queen);

				queen.row--; // queen이 잡히는 배치라면 이전 위치에서 되돌아가 dfs 수행하도록 row 감소
				queen.col = i;
				num_queen--; // 현재까지 배치된 queen 수 감소
				position_queen[queen.row][queen.col] = 0; } // 이전에 배치했던 queen의 좌표 다시 초기화함
		}
	}

	private static boolean check(Queen queen) { // 놓을 수 있는 위치이면 true, 아니면 false 반환
		if (queen.row == 0) return true; // 처음 시작으로 0에 해당하는 row에서는 어느 col에도 배치 가능
			
		for (int i = 0; i < num_queen; i++) { // 현재까지 배치된 queen 수만큼 check_position(queen좌표들) 확인함
			if ((check_position[i][1] == queen.col) || // 같은 col 이거나 ( 같은 row는 dfs를 통해서 존재x)
					Math.abs(check_position[i][0] - queen.row) == Math.abs(check_position[i][1] - queen.col)) // 절댓값(x좌표-row) == 절댓값(y좌표-col)대각선이면
				return false; // 배치 불가능
		}
		return true; }

	private static void result_position_queen() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// row와 col이 둘다 짝수 or 둘다 홀수이면 하얀 블럭
				if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
					if (position_queen[i][j] == 0) System.out.print("□" + " "); // queen 배치 X
					else System.out.print("Q "); } // queen 배치 O
				else {// row와 col이 각각 짝수, 홀수에 해당하면 검은 블럭
					if (position_queen[i][j] == 0) System.out.print("■" + " "); // queen 배치 X
					else System.out.print("Q "); } // queen 배치 O
			}
			System.out.println();
		}
		System.out.println("--------"); }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("퀸의 개수는(n개의 퀸과 n*n의 체스 판을 생성합니다)? ");
		N = scanner.nextInt();
		System.out.println();

		num_queen = 0;
		position_queen = new int[N][N]; //체스판
		check_position = new int[N][2]; //queen 위치 좌표 저장 위함
		dfs(new Queen(0, 0)); // dfs로 queen 배치 탐색

		scanner.close();
	}
}