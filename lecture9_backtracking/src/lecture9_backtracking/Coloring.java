package lecture9_backtracking;

public class Coloring {
	int N; // �׷����� �������� ��
	int m; // ������ ��
	int[] vcolor; // �����鿡 ĥ���� ������ �迭

	public static void main(String[] args) {
		Coloring col = new Coloring();
		col.vcolor = new int[10]; // �׷����� ���� ��ķ�
		int graph1[][] = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 0 } }; // �� ������ �ش��ϴ� �������� ������
		col.N = 5; // 5���� ����(A, B, C, D, E)
		col.m = 3; // 3���� ��(RED, GREEN, BLUE)
		col.m_coloring(graph1, 0); }
	
	public void m_coloring(int G[][], int i) { // ������ �׷��� G�� �������� ��ĥ�ϴ� ��� ����� ���
		int color[] = {1, 2, 3};
		if (valid(G, i)) // �����鿡 ĥ���� ������ �迭 vcolor[1..N]�� ���
			if (i == N) {
				System.out.println("��ĥ �ϱ�");
				for (i = 0; i < N; i++) {
					System.out.print("���� " + (char)(65+i) + "�� �� = "); // � �������� ���
					if (vcolor[i+1] == 1) System.out.print("RED / "); // 1�� ���� RED
					else if (vcolor[i+1] == 2) System.out.print("GREEN / "); // 2�� ���� GREEN
					else if (vcolor[i+1] == 3) System.out.print("BLUE / "); } // 3�� ���� BLUE
				System.out.println("\n");
				return;
			} else { // ���� ������ ��� ���� �õ�
				for (int j = 0; j < m; j++) {
					vcolor[i + 1] = color[j];
					m_coloring(G, i + 1); }	}
	}

	public boolean valid(int G[][], int i) { // ���� i�� ĥ���� ���� ��ȿ���� Ȯ��
		int j = 1;
		while (j < i) { // ���� i�� ���� ������ ����(��)�� ���� �������� Ȯ��
			if (G[i - 1][j - 1] == 1 && vcolor[i] == vcolor[j])
				return false;
			j++; }
		return true; }
}