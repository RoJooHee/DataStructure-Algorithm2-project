package lecture4_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	private Queue<Node> queue;
	
	public BreadthFirstSearch() {
		queue=new LinkedList<Node>(); }
	
	public void BFS(Node v) { //정점 v를 기준으로 element(큐)에 저장하고 이 근처 인접한 정점w를 방문하고 element에 넣고.. 모든 정점 방문하기
		v.visited=true; //처음 정점은 방문함
		queue.add(v); //방문한 정점은 큐에 넣음
		
		while(!queue.isEmpty()) { //만약 큐가 비어있지 않다면(방문한 정점이 있다면)
			Node element=queue.remove(); //큐의 맨 앞에 있는 정점을 꺼내서 element에 저장함
			System.out.print(element.info+" "); //element에 관한 정보 출력
			List<Node> neighbours = element.getNeighbours(); //element에 인접한 정점들의 연결목록들을 끄집어내어 리스트에 저장
			
			for(int i=0; i<neighbours.size(); i++) { //인접한 정점들에 대해 전부 for문 돌아감
				Node w=neighbours.get(i); //element에 인접한 정점을 w라 함
				if(w!=null && !w.visited) { //만약 인접한 정점이 존재하면서 방문하지 않았을 경우
					w.visited=true; //그 w를 방문함
					queue.add(w); }  }//그리고 방문했으니 큐에 넣음
		} }
	
	public static void main(String[] args) {
		Node node1=new Node(1); Node node2=new Node(2); Node node3=new Node(3); //정점 생성
		Node node4=new Node(4); Node node5=new Node(5); Node node6=new Node(6);
		
		node1.addNeighbours(node2); node1.addNeighbours(node3); node1.addNeighbours(node5);//간선들 만들어 표현
		node2.addNeighbours(node1); node2.addNeighbours(node3);
		node3.addNeighbours(node1); node3.addNeighbours(node2); node3.addNeighbours(node4); node3.addNeighbours(node5);
		node4.addNeighbours(node3); node4.addNeighbours(node6);
		node5.addNeighbours(node1); node5.addNeighbours(node3);
		node6.addNeighbours(node3); node6.addNeighbours(node4);
		
		BreadthFirstSearch bfsExample=new BreadthFirstSearch();
		
		System.out.println("너비 우선 탐색 실행 결과");
		bfsExample.BFS(node1);
	}
}

//너비 우선 탐색으로 간선들로 그래프 연결되면 '너비 우선 신장 트리'만듦 (/너비 우선 신장 숲)
//시작 정점은 루트노드, 인접정점 처음 방문할 때 인접정점은 자식노드, 간선은 트리 간선
//부모노드 아니면서 이미 방문한 정점으로 가는 간선은 '교차간선'이며 점선으로 표시
//재귀를 사용해 작성 불가. 큐 사용하면 쉬움(FIFO)
//정점으로 시작해 큐의 맨 앞에 들어감. 큐의 맨 앞에있는 정점에 인접한 정점들을 찾아내어 '방문함'으로 표시하고 큐의 끝에 추가함. 그럼 또다시 큐 맨앞 정점을 꺼냄 반복..