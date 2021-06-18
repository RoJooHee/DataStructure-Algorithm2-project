//���� 11404�� �÷��̵� �ͼ� �˰��� ����.
//https://velog.io/@pandahun/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%A0%95%EB%A6%AC-%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%8C%EC%85%9C-%EB%B0%B1%EC%A4%80-11404-java#%ED%92%80%EC%9D%B4
//https://pangsblog.tistory.com/90
//https://data-make.tistory.com/394

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class three {
    public static int cityCount;
    public static int[][] distance;
    public static final int INF = 1000000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        cityCount = Integer.parseInt(br.readLine());
        
        int busCount = Integer.parseInt(br.readLine());
        
        distance = new int[cityCount+1][cityCount+1];
        
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }
        
        while(busCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            distance[start][end] = Math.min(distance[start][end], time);    
        }
 
        floydWarshall();
        print();
    }
    
    public static void floydWarshall() {
        // ������ �Ǵ� ���İ��� ��� K
        for(int k = 1; k <= cityCount; k++) {
            // ����ϴ� ��� i
            for(int i=1; i <= cityCount; i++) {
                // �����ϴ� ��� j
                for(int j=1; j <= cityCount; j++) {
                    //i���� k�� ���ƴٰ� k���� j ���� ���� �Ÿ��� i���� j ���� ���� �Ÿ��� ���ؼ� ���� ���� �ּҰŸ��̴�.
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
    
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(distance[i][j] >= INF) sb.append("0 ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
