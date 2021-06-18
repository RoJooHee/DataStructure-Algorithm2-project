package lecture9_backtracking;

public class Coloring {
	int N; // 그래프의 정점들의 수
	int m; // 색들의 수
	int[] vcolor; // 정점들에 칠해진 색들의 배열

	public static void main(String[] args) {
		Coloring col = new Coloring();
		col.vcolor = new int[10]; // 그래프는 인접 행렬로
		int graph1[][] = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 0 } }; // 각 정점에 해당하는 간선들을 저장함
		col.N = 5; // 5개의 정점(A, B, C, D, E)
		col.m = 3; // 3개의 색(RED, GREEN, BLUE)
		col.m_coloring(graph1, 0); }
	
	public void m_coloring(int G[][], int i) { // 무방향 그래프 G의 정점들을 색칠하는 모든 방법을 출력
		int color[] = {1, 2, 3};
		if (valid(G, i)) // 정점들에 칠해진 색들의 배열 vcolor[1..N]을 출력
			if (i == N) {
				System.out.println("색칠 하기");
				for (i = 0; i < N; i++) {
					System.out.print("정점 " + (char)(65+i) + "의 색 = "); // 어떤 정점인지 출력
					if (vcolor[i+1] == 1) System.out.print("RED / "); // 1인 경우는 RED
					else if (vcolor[i+1] == 2) System.out.print("GREEN / "); // 2인 경우는 GREEN
					else if (vcolor[i+1] == 3) System.out.print("BLUE / "); } // 3인 경우는 BLUE
				System.out.println("\n");
				return;
			} else { // 다음 정점에 모든 색을 시도
				for (int j = 0; j < m; j++) {
					vcolor[i + 1] = color[j];
					m_coloring(G, i + 1); }	}
	}

	public boolean valid(int G[][], int i) { // 정점 i에 칠해질 색이 유효한지 확인
		int j = 1;
		while (j < i) { // 정점 i의 색이 인접한 정점(들)의 색과 같은지를 확인
			if (G[i - 1][j - 1] == 1 && vcolor[i] == vcolor[j])
				return false;
			j++; }
		return true; }
}