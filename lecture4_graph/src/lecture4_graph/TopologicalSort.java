package lecture4_graph;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	Stack<Node> stack; //정점들을 방문한 역순으로 저장하는 스택
	
	public TopologicalSort() {
		stack=new Stack<>(); } //비어있는 스택 생성
	
	public void topologicalSort(Node v) { //정점v에서 위상정렬 시작함
		List<Node> neighbours = v.getNeighbours(); //인근 정점 목록 끄집어내어 list에 저장함
		for(int i=0; i<neighbours.size(); i++) {
			Node w=neighbours.get(i); //v에 인접한 정점w 들을 찾아냄.
			
			if(w!=null && !w.visited) { //만약 인접정점w가 존재하면서 방문한적이 없다면
				w.visited=true; //방문 했다고 하고
				topologicalSort(w);	} //w기준으로 위상정렬 시작함.
		}
		stack.push(v); //끝나면 v는 스택에 넣음(탐색 다 끝나면 스택에 있는 것들 출력하면 그게 바로 결과)
	}
	
	public static void main(String[] args) {
		TopologicalSort topological = new TopologicalSort();
		Node node0=new Node(0); //그래프에서 깊이우선탐색 시작하는 정점0을 추가함
		
		Node node1=new Node(1); Node node2=new Node(2); Node node3=new Node(3); //정점 생성
		Node node4=new Node(4); Node node5=new Node(5); Node node6=new Node(6); Node node7=new Node(7);
		
		node0.addNeighbours(node1); node0.addNeighbours(node3);//정점 0에서 진입간선이 없는 정점 1, 3으로 가는 간선 추가
		
		node1.addNeighbours(node2); node1.addNeighbours(node4); //간선들 만들어 표현
		node2.addNeighbours(node4); node2.addNeighbours(node6);
		node3.addNeighbours(node4); node3.addNeighbours(node5);
		node4.addNeighbours(node6);
		node5.addNeighbours(node6); node5.addNeighbours(node7);
		node6.addNeighbours(node7);
		
		System.out.println("위상정렬 순서 : ");
		
		node0.visited=true; //시작정점인 node0을 방문했다고 하고
		topological.topologicalSort(node0); //node0 기준으로 위상정렬 시작
		
		Stack<Node> resultStack = topological.stack; //결과들이 저장된 스택을 가져옴
		
		while(resultStack.empty() == false) //resultStack(결과 스택)에 결과값이 존재하는 동안
			System.out.print(resultStack.pop() + " "); //결과값을 차례로 꺼내서 출력함
	}
}

//위상정렬 : 선행조건들을 가진 일들의 수행순서를 정함. 선후수 관계를 만족시켜야함
//방향그래프로 나타내며 순환이 없어야함. 순환이 있는지는 깊이우선탐색을 통해 알아낼 수 있음(조상/부모노드로 가는 뒤간선이 있으면 순환 있는 것)
//깊이우선탐색과 스택 이용.
//한정점에 인접한 방문하지 않은 정점w에 대해 깊이우선탐색 계속함. w가 없으면 v를 스택에 넣음. 깊이우선탐색 종료되면 스택에 있는 정점들 하나씩 출력
//깊이우선탐색 시작하면 모든 정점 방문할 수 있도록 그래프에 시작정점 s 추가하고, 진입간선이 없는 정점으로 가는 간선 추가