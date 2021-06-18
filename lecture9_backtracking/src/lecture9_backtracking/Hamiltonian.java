package lecture9_backtracking;

public class Hamiltonian {
	int n; // �׷����� ������ ��
	int[] path; // �ع���Ͼ� ȸ�� ���� ���� ���� �迭

	public static void main(String[] args) {
		Hamiltonian hamil = new Hamiltonian();
		hamil.path = new int[10]; // �׷����� ���� ��ķ� ��Ÿ��
		int[][] G = { {0, 1, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0}, {1, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0}};
		hamil.n = 6;
		hamil.path[0] = 1; // ���� ������ ���� 1
		hamil.hamiltonian(G, 0); } // �ع���Ͼ� ȸ�θ� ã��

	public void hamiltonian(int G[][], int i) { // ������ �׷��� G ���� ��� �ع���Ͼ� ȸ�θ� ã�Ƽ� ���
		int j;
		if (valid(G, i))
			if (i == n - 1) { // ã�� �ع���Ͼ� ȸ�� path[0..n-1] ���
				System.out.print("ã�� �ع���Ͼ� ȸ��: ");
				for (i = 0; i < n; i++)
					System.out.print(path[i] + "->");
				System.out.println(path[0]);
				System.out.println("��µ� ���� ���ٸ� �ع���Ͼ� ȸ�δ� �������� ����");
				return;	}
			
			else { // i ��°�� �湮�� �������� ���� ������ ������ ��� ������ �õ�
				for (j = 2; j <= n; j++) {
					path[i + 1] = j;
					hamiltonian(G, i + 1); } }
	}

	public boolean valid(int G[][], int i) { // ��λ��� i��° ������ ��ȿ�� �������� Ȯ��
		int j;
		if (i == n - 1 && G[path[n - 1] - 1][path[0] - 1] == 0) // ������ ������ ù ��° ������ �������� ���� ���
			return false;
		else if (i > 0 && G[path[i - 1] - 1][path[i] - 1] == 0) // i ��° ������ (i-1)��° ������ �������� ���� ���
			return false;
		else { // i��° ������ �̹� ���õǾ����� Ȯ��
			j = 1;
			while (j < i) {
				if (path[i] == path[j])
					return false;
				j++; } }
		return true;
	}
}