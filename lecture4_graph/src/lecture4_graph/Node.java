package lecture4_graph;

import java.util.ArrayList;
import java.util.List;

public class Node { //�׷����� �� ���� ��Ÿ��
	int info; //������ ������ ������
	boolean visited; //�湮����
	List<Node> neighbours; //������ ������ �������� ������
	
	public Node(int info) { //Node ��ü ����
		this.info=info;
		this.visited=false; //�ϴ� �湮�� �� ���� ������
		this.neighbours=new ArrayList<>(); }
	
	public void addNeighbours(Node neighboursNode) { //������ ������ �������� �����Ͽ� �� ���� �߰�
		this.neighbours.add(neighboursNode); }
	
	public List<Node> getNeighbours(){ //������ ������ �������� ������ ��ȯ
		return neighbours; 	}
	
	public void setNeighbours(List<Node> neighbours) { //������ ������ �������� �������� �־��� ���������� ����
		this.neighbours=neighbours; }
	
	public String toString() { //������ ������ ������ ��ȯ
		return ""+info;	}
}
