package lecture4_graph;

import java.util.List;

public class DepthFirstSearch { 
//깊이 우선 탐색은 스택(LIFO)으로 비재귀적으로 구현. 방문할 때 정점을 스택에 넣고, 인접한 방문X정점 없을 떄 다시 스택에서 끄집어냄
	public static void DFS(Node v) {
		System.out.print(v.info+" "); //v.info = 정점v에 대응된 데이터 출력
		v.visited=true; //v.visited = 정점v를 '방문함'으로 표기
		List<Node> neighbours=v.getNeighbours(); //v.getNeighbours = 정점v에 인접한 정점들의 연결목록 끄집어내어 리스트로 넣음.
		
		for (int i=0; i<neighbours.size(); i++) { 
			Node w= neighbours.get(i); //정점v에 인접하며 방문하지 않은 모든 정점들에 대해 깊이우선탐색
			if(w!=null && !w.visited) DFS(w); } //만약 위에서 탐색하여 w가 하나라도 있으면서 방문하지 않은 정점이 있는 경우 또 DFS(w)진행
	}
	
	public static void main(String[] args) {  //비방향 그래프를 연결목록으로 표현
		Node[] node=new Node[6]; //정점 6개 표현
		//int[] distance = {1, 2, 5, 10};
		//for (int i = 0; i < 4; i++)
		//	System.out.println(distance[i]);
		for (int i=0; i<6; i++)
			node[i]=new Node(i+1);
		
		
		node[0].addNeighbours(node[1]); //간선들 만들어 표현
		node[0].addNeighbours(node[2]);
		//node[0].addNeighbours(node[3]);
		node[1].addNeighbours(node[0]);
		node[1].addNeighbours(node[4]);
		//node[1].addNeighbours(node[3]);
		node[2].addNeighbours(node[0]);
		node[2].addNeighbours(node[3]);
		//node[2].addNeighbours(node[3]);
		node[3].addNeighbours(node[2]);
		node[3].addNeighbours(node[5]);
		node[4].addNeighbours(node[1]);
		node[5].addNeighbours(node[3]);
		
		System.out.println("재귀를 사용한 깊이 우선 탐색 실행 결과 ");
		DFS(node[0]); //node[0]정점부터 깊이 우선 탐색 실행
	}
}

// 무방향/방향 그래프 G= (V, E)  정점 V= {a, b, c...}  간선 E= {(a,b), (a,c)..} / {<a,b>, <a,c>...}
// 그래프의 간선에 가중치 부여되어있음 : '가중그래프'.    모든 정점들이 상호연결(간선 모두 존재) 되어있음 : '연결그래프/비연결그래프'
// 두 정점의 경로 구성하는 간선의 수 : '경로의 길이'
// 어떤 간선도 중복되지 않음 : '닫힌 경로=순환그래프'  v1, v2..vn  v1=vn

//비방향(방향)그래프를 프로그램에 표현하는 대표적 방법 -> 인접목록, 인접행렬
/* '인접 목록' : 각 정점의 이웃정점들을 연결목록으로 표현  ex) 정점 1이 정점 2,4,5로 가는 간선 가짐 = 1->2->4->5로 표현. 
	연결목록에 있는 노드 수=정점 수+간선 수. 간선 수 적은 저밀도 그래프 나타낼 때 좋음 */
/* '인접 행렬' : 두 정점들 사이에 간선이 있는지 행렬로 표현. 간선 있으면 1, 없으면 0 표시
	무방향그래프인 경우 인접행렬은 대칭행렬. 작은 그래프나 고밀도 그래프, 간선 존재유무 빠르게 알 때 사용 */

//'깊이 우선 탐색' : 한 정점에서 탐색 시작하고 인접한 것 중 방문 안한 정점 임의로 선택해 방문. 더이상 인접한게 없으면 바로 전에 방문했던 정점으로 돌아가 인접한 것 탐색
// -> 시작정점과 연결된 모든 정점들 다 문함. 종료후 방문 안한 정점 남아있으면 그 중 한 정점에서 다시 깊이우선검색 시작.
// => 그래프가 연결돼있으면 간선들로 '깊이 우선 신장 트리'를 만들 수 있음(/깊이 우선 신장 숲). 탐색 시작정점은 트리의 루트노드, 한 정점에서 처음으로 방문한 인접 정점은 자식노드가 됨. 
// 부모에서 자식으로 간선은 '트리 간선', 이미 방문한 정점으로 가는 간선은 '뒤간선'이며 점선으로 표시.