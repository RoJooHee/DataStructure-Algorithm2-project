package lecture9_backtracking;

public class Hamiltonian {
	int n; // 그래프의 정점들 수
	int[] path; // 해밀토니안 회로 내의 정점 저장 배열

	public static void main(String[] args) {
		Hamiltonian hamil = new Hamiltonian();
		hamil.path = new int[10]; // 그래프는 인접 행렬로 나타냄
		int[][] G = { {0, 1, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0}, {1, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0}};
		hamil.n = 6;
		hamil.path[0] = 1; // 시작 정점은 정점 1
		hamil.hamiltonian(G, 0); } // 해밀토니안 회로를 찾기

	public void hamiltonian(int G[][], int i) { // 무방향 그래프 G 내의 모든 해밀토니안 회로를 찾아서 출력
		int j;
		if (valid(G, i))
			if (i == n - 1) { // 찾은 해밀토니안 회로 path[0..n-1] 출력
				System.out.print("찾은 해밀토니안 회로: ");
				for (i = 0; i < n; i++)
					System.out.print(path[i] + "->");
				System.out.println(path[0]);
				System.out.println("출력된 것이 없다면 해밀토니안 회로는 존재하지 않음");
				return;	}
			
			else { // i 번째로 방문할 정점으로 시작 정점을 제외한 모든 정점을 시도
				for (j = 2; j <= n; j++) {
					path[i + 1] = j;
					hamiltonian(G, i + 1); } }
	}

	public boolean valid(int G[][], int i) { // 경로상의 i번째 정점이 유효한 선택인지 확인
		int j;
		if (i == n - 1 && G[path[n - 1] - 1][path[0] - 1] == 0) // 마지막 정점이 첫 번째 정점과 인접하지 않은 경우
			return false;
		else if (i > 0 && G[path[i - 1] - 1][path[i] - 1] == 0) // i 번째 정점이 (i-1)번째 정점과 인접하지 않은 경우
			return false;
		else { // i번째 정점이 이미 선택되었는지 확인
			j = 1;
			while (j < i) {
				if (path[i] == path[j])
					return false;
				j++; } }
		return true;
	}
}
