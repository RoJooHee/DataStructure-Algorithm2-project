package lecture4_graph;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	Stack<Node> stack; //�������� �湮�� �������� �����ϴ� ����
	
	public TopologicalSort() {
		stack=new Stack<>(); } //����ִ� ���� ����
	
	public void topologicalSort(Node v) { //����v���� �������� ������
		List<Node> neighbours = v.getNeighbours(); //�α� ���� ��� ������� list�� ������
		for(int i=0; i<neighbours.size(); i++) {
			Node w=neighbours.get(i); //v�� ������ ����w ���� ã�Ƴ�.
			
			if(w!=null && !w.visited) { //���� ��������w�� �����ϸ鼭 �湮������ ���ٸ�
				w.visited=true; //�湮 �ߴٰ� �ϰ�
				topologicalSort(w);	} //w�������� �������� ������.
		}
		stack.push(v); //������ v�� ���ÿ� ����(Ž�� �� ������ ���ÿ� �ִ� �͵� ����ϸ� �װ� �ٷ� ���)
	}
	
	public static void main(String[] args) {
		TopologicalSort topological = new TopologicalSort();
		Node node0=new Node(0); //�׷������� ���̿켱Ž�� �����ϴ� ����0�� �߰���
		
		Node node1=new Node(1); Node node2=new Node(2); Node node3=new Node(3); //���� ����
		Node node4=new Node(4); Node node5=new Node(5); Node node6=new Node(6); Node node7=new Node(7);
		
		node0.addNeighbours(node1); node0.addNeighbours(node3);//���� 0���� ���԰����� ���� ���� 1, 3���� ���� ���� �߰�
		
		node1.addNeighbours(node2); node1.addNeighbours(node4); //������ ����� ǥ��
		node2.addNeighbours(node4); node2.addNeighbours(node6);
		node3.addNeighbours(node4); node3.addNeighbours(node5);
		node4.addNeighbours(node6);
		node5.addNeighbours(node6); node5.addNeighbours(node7);
		node6.addNeighbours(node7);
		
		System.out.println("�������� ���� : ");
		
		node0.visited=true; //���������� node0�� �湮�ߴٰ� �ϰ�
		topological.topologicalSort(node0); //node0 �������� �������� ����
		
		Stack<Node> resultStack = topological.stack; //������� ����� ������ ������
		
		while(resultStack.empty() == false) //resultStack(��� ����)�� ������� �����ϴ� ����
			System.out.print(resultStack.pop() + " "); //������� ���ʷ� ������ �����
	}
}

//�������� : �������ǵ��� ���� �ϵ��� ��������� ����. ���ļ� ���踦 �������Ѿ���
//����׷����� ��Ÿ���� ��ȯ�� �������. ��ȯ�� �ִ����� ���̿켱Ž���� ���� �˾Ƴ� �� ����(����/�θ���� ���� �ڰ����� ������ ��ȯ �ִ� ��)
//���̿켱Ž���� ���� �̿�.
//�������� ������ �湮���� ���� ����w�� ���� ���̿켱Ž�� �����. w�� ������ v�� ���ÿ� ����. ���̿켱Ž�� ����Ǹ� ���ÿ� �ִ� ������ �ϳ��� ���
//���̿켱Ž�� �����ϸ� ��� ���� �湮�� �� �ֵ��� �׷����� �������� s �߰��ϰ�, ���԰����� ���� �������� ���� ���� �߰�