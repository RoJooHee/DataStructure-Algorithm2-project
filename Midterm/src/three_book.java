
public class three_book {
	final static int INF=9999;
	
	void find_all_pair_shortest_path(int graph[][], int n) {
		int dist[][]=new int[n][n]; //�ִܰ�� ���
		int i, j, k;
		
		for (i=0; i<n; i++)
			for (j=0; j<n; j++)
				dist[i][j]=graph[i][j]; //dist[i][j]�� graph[i][j] ������ �ʱ�ȭ
		
		for (k=0; k<n; k++) { //�����ؾ� �ϴ� k����
			for(i=0; i<n; i++) { //����� i����
				for(j=0; j<n; j++) { //������ j����
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		} //��� ������� �������� ���ؼ� �������� �ʴ� ���, k���� �����ϴ� ��츦 ���� �ִܰ�� ã�� ����
			
		printSolution(dist, n);
		}
		
		void printSolution(int dist[][], int n) {
			int i, j;
			System.out.println("�����(1)���� ������(16)���� �ּ� ���� ���\n");
			System.out.println("         ������   1 2 3 4 5 6 7 8 9 10111213141516 ����");
			for (i=0; i<n; ++i) {
				if (i>=9) System.out.print("������� "+(i+1)+" ���� || ");
				else System.out.print("������� "+(i+1)+"  ���� || ");
				
				for(j=0; j<n; ++j) {
					if(dist[i][j]==INF) //�� �� �ִ� ��� ������ ���
						System.out.print("X ");
					else
						System.out.print(dist[i][j]+" "); //��ΰ� �����ߴ� ���
				}
				System.out.println();
			}
			System.out.print("\n���� ���� 1���� 16���� ���� �ּ� ���� ����� <"+dist[0][15]+"> �̴�"); //�迭�� 0 ���� �����ؼ� -1����
		}
	public static void main(String[] args) {
		int graph[][]= {{0, 1, INF, INF, 1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, 0, 2, INF, INF, 2, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, INF, 0, 1, INF, INF, 1, INF, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, INF, INF, 0, INF, INF, INF, 3, INF, INF, INF, INF, INF, INF, INF, INF},
				{INF, INF, INF, INF, 0, 2, INF, INF, 2, INF, INF, INF, INF, INF, INF, INF},
				{INF, INF, INF, INF, INF, 0, 1, INF, INF, 1, INF, INF, INF, INF, INF, INF},
				{INF, INF, INF, INF, INF, INF, 0, 4, INF, INF, 4, INF, INF, INF, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, 2, INF, INF, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, 0, 3, INF, INF, 3, INF, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 1, INF, INF, 1, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 2, INF, INF, 2, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, 3},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 2, INF, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 3, INF},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 2},
				{INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0}
		}; //graph[][]�� ������ ���ں� �׷����� ���� ����ġ ����̴�.
		int n=16; //n�� �� ������ ���� �ǹ��Ѵ�.
		three_book a= new three_book(); //Ŭ���� ���� a ����
		a.find_all_pair_shortest_path(graph, n);
		}
	}
