
public class three_book {
	final static int INF=9999;
	
	void find_all_pair_shortest_path(int graph[][], int n) {
		int dist[][]=new int[n][n]; //최단경로 행렬
		int i, j, k;
		
		for (i=0; i<n; i++)
			for (j=0; j<n; j++)
				dist[i][j]=graph[i][j]; //dist[i][j]를 graph[i][j] 값으로 초기화
		
		for (k=0; k<n; k++) { //경유해야 하는 k정점
			for(i=0; i<n; i++) { //출발지 i정점
				for(j=0; j<n; j++) { //도착지 j정점
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		} //모든 출발지와 도착지에 대해서 경유하지 않는 경우, k정점 경유하는 경우를 비교해 최단경로 찾아 갱신
			
		printSolution(dist, n);
		}
		
		void printSolution(int dist[][], int n) {
			int i, j;
			System.out.println("출발지(1)부터 도착지(16)까지 최소 숙박 비용\n");
			System.out.println("         도착지   1 2 3 4 5 6 7 8 9 10111213141516 도시");
			for (i=0; i<n; ++i) {
				if (i>=9) System.out.print("출발지가 "+(i+1)+" 도시 || ");
				else System.out.print("출발지가 "+(i+1)+"  도시 || ");
				
				for(j=0; j<n; ++j) {
					if(dist[i][j]==INF) //갈 수 있는 경로 없었던 경우
						System.out.print("X ");
					else
						System.out.print(dist[i][j]+" "); //경로가 존재했던 경우
				}
				System.out.println();
			}
			System.out.print("\n따라서 도시 1에서 16으로 가는 최소 숙박 비용은 <"+dist[0][15]+"> 이다"); //배열은 0 부터 시작해서 -1해줌
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
		}; //graph[][]는 도시의 숙박비 그래프에 대한 가중치 행렬이다.
		int n=16; //n은 총 도시의 수를 의미한다.
		three_book a= new three_book(); //클래스 변수 a 선언
		a.find_all_pair_shortest_path(graph, n);
		}
	}
