package lecture4_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	private Queue<Node> queue;
	
	public BreadthFirstSearch() {
		queue=new LinkedList<Node>(); }
	
	public void BFS(Node v) { //���� v�� �������� element(ť)�� �����ϰ� �� ��ó ������ ����w�� �湮�ϰ� element�� �ְ�.. ��� ���� �湮�ϱ�
		v.visited=true; //ó�� ������ �湮��
		queue.add(v); //�湮�� ������ ť�� ����
		
		while(!queue.isEmpty()) { //���� ť�� ������� �ʴٸ�(�湮�� ������ �ִٸ�)
			Node element=queue.remove(); //ť�� �� �տ� �ִ� ������ ������ element�� ������
			System.out.print(element.info+" "); //element�� ���� ���� ���
			List<Node> neighbours = element.getNeighbours(); //element�� ������ �������� �����ϵ��� ������� ����Ʈ�� ����
			
			for(int i=0; i<neighbours.size(); i++) { //������ �����鿡 ���� ���� for�� ���ư�
				Node w=neighbours.get(i); //element�� ������ ������ w�� ��
				if(w!=null && !w.visited) { //���� ������ ������ �����ϸ鼭 �湮���� �ʾ��� ���
					w.visited=true; //�� w�� �湮��
					queue.add(w); }  }//�׸��� �湮������ ť�� ����
		} }
	
	public static void main(String[] args) {
		Node node1=new Node(1); Node node2=new Node(2); Node node3=new Node(3); //���� ����
		Node node4=new Node(4); Node node5=new Node(5); Node node6=new Node(6);
		
		node1.addNeighbours(node2); node1.addNeighbours(node3); node1.addNeighbours(node5);//������ ����� ǥ��
		node2.addNeighbours(node1); node2.addNeighbours(node3);
		node3.addNeighbours(node1); node3.addNeighbours(node2); node3.addNeighbours(node4); node3.addNeighbours(node5);
		node4.addNeighbours(node3); node4.addNeighbours(node6);
		node5.addNeighbours(node1); node5.addNeighbours(node3);
		node6.addNeighbours(node3); node6.addNeighbours(node4);
		
		BreadthFirstSearch bfsExample=new BreadthFirstSearch();
		
		System.out.println("�ʺ� �켱 Ž�� ���� ���");
		bfsExample.BFS(node1);
	}
}

//�ʺ� �켱 Ž������ ������� �׷��� ����Ǹ� '�ʺ� �켱 ���� Ʈ��'���� (/�ʺ� �켱 ���� ��)
//���� ������ ��Ʈ���, �������� ó�� �湮�� �� ���������� �ڽĳ��, ������ Ʈ�� ����
//�θ��� �ƴϸ鼭 �̹� �湮�� �������� ���� ������ '��������'�̸� �������� ǥ��
//��͸� ����� �ۼ� �Ұ�. ť ����ϸ� ����(FIFO)
//�������� ������ ť�� �� �տ� ��. ť�� �� �տ��ִ� ������ ������ �������� ã�Ƴ��� '�湮��'���� ǥ���ϰ� ť�� ���� �߰���. �׷� �Ǵٽ� ť �Ǿ� ������ ���� �ݺ�..