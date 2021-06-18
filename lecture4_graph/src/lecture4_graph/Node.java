package lecture4_graph;

import java.util.ArrayList;
import java.util.List;

public class Node { //그래프의 한 정점 나타냄
	int info; //정점에 대응된 데이터
	boolean visited; //방문여부
	List<Node> neighbours; //정점에 인접한 정점들의 연결목록
	
	public Node(int info) { //Node 객체 생성
		this.info=info;
		this.visited=false; //일단 방문한 적 없는 것으로
		this.neighbours=new ArrayList<>(); }
	
	public void addNeighbours(Node neighboursNode) { //정점에 인접한 정점들의 연결목록에 새 정점 추가
		this.neighbours.add(neighboursNode); }
	
	public List<Node> getNeighbours(){ //정점에 인접한 정점들의 연결목록 반환
		return neighbours; 	}
	
	public void setNeighbours(List<Node> neighbours) { //정점에 인접한 정점들의 연결목록을 주어진 연결목록으로 변경
		this.neighbours=neighbours; }
	
	public String toString() { //정점에 대응된 데이터 반환
		return ""+info;	}
}
