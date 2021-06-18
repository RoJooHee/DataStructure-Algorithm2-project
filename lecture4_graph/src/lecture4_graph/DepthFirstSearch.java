package lecture4_graph;

import java.util.List;

public class DepthFirstSearch { 
//���� �켱 Ž���� ����(LIFO)���� ����������� ����. �湮�� �� ������ ���ÿ� �ְ�, ������ �湮X���� ���� �� �ٽ� ���ÿ��� �����
	public static void DFS(Node v) {
		System.out.print(v.info+" "); //v.info = ����v�� ������ ������ ���
		v.visited=true; //v.visited = ����v�� '�湮��'���� ǥ��
		List<Node> neighbours=v.getNeighbours(); //v.getNeighbours = ����v�� ������ �������� ������ ������� ����Ʈ�� ����.
		
		for (int i=0; i<neighbours.size(); i++) { 
			Node w= neighbours.get(i); //����v�� �����ϸ� �湮���� ���� ��� �����鿡 ���� ���̿켱Ž��
			if(w!=null && !w.visited) DFS(w); } //���� ������ Ž���Ͽ� w�� �ϳ��� �����鼭 �湮���� ���� ������ �ִ� ��� �� DFS(w)����
	}
	
	public static void main(String[] args) {  //����� �׷����� ���������� ǥ��
		Node[] node=new Node[6]; //���� 6�� ǥ��
		//int[] distance = {1, 2, 5, 10};
		//for (int i = 0; i < 4; i++)
		//	System.out.println(distance[i]);
		for (int i=0; i<6; i++)
			node[i]=new Node(i+1);
		
		
		node[0].addNeighbours(node[1]); //������ ����� ǥ��
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
		
		System.out.println("��͸� ����� ���� �켱 Ž�� ���� ��� ");
		DFS(node[0]); //node[0]�������� ���� �켱 Ž�� ����
	}
}

// ������/���� �׷��� G= (V, E)  ���� V= {a, b, c...}  ���� E= {(a,b), (a,c)..} / {<a,b>, <a,c>...}
// �׷����� ������ ����ġ �ο��Ǿ����� : '���߱׷���'.    ��� �������� ��ȣ����(���� ��� ����) �Ǿ����� : '����׷���/�񿬰�׷���'
// �� ������ ��� �����ϴ� ������ �� : '����� ����'
// � ������ �ߺ����� ���� : '���� ���=��ȯ�׷���'  v1, v2..vn  v1=vn

//�����(����)�׷����� ���α׷��� ǥ���ϴ� ��ǥ�� ��� -> �������, �������
/* '���� ���' : �� ������ �̿��������� ���������� ǥ��  ex) ���� 1�� ���� 2,4,5�� ���� ���� ���� = 1->2->4->5�� ǥ��. 
	�����Ͽ� �ִ� ��� ��=���� ��+���� ��. ���� �� ���� ���е� �׷��� ��Ÿ�� �� ���� */
/* '���� ���' : �� ������ ���̿� ������ �ִ��� ��ķ� ǥ��. ���� ������ 1, ������ 0 ǥ��
	������׷����� ��� ��������� ��Ī���. ���� �׷����� ���е� �׷���, ���� �������� ������ �� �� ��� */

//'���� �켱 Ž��' : �� �������� Ž�� �����ϰ� ������ �� �� �湮 ���� ���� ���Ƿ� ������ �湮. ���̻� �����Ѱ� ������ �ٷ� ���� �湮�ߴ� �������� ���ư� ������ �� Ž��
// -> ���������� ����� ��� ������ �� ����. ������ �湮 ���� ���� ���������� �� �� �� �������� �ٽ� ���̿켱�˻� ����.
// => �׷����� ����������� ������� '���� �켱 ���� Ʈ��'�� ���� �� ����(/���� �켱 ���� ��). Ž�� ���������� Ʈ���� ��Ʈ���, �� �������� ó������ �湮�� ���� ������ �ڽĳ�尡 ��. 
// �θ𿡼� �ڽ����� ������ 'Ʈ�� ����', �̹� �湮�� �������� ���� ������ '�ڰ���'�̸� �������� ǥ��.