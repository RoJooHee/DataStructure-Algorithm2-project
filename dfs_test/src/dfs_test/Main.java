package dfs_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static int[][] map;
    public static int edge;
    public static int vertices;
    public static int V;
    public static int[] distance = {1, 2, 5, 10};
    public static int temp;
    public static boolean[] visited;
 
    public static void dfs(int start) {
 
        //System.out.print(start + " "); // 출력문
        visited[start] = true; // 시작점 방문
 
        temp = distance[start - 1];
        System.out.println(temp);
        
        for (int i = 1; i < map.length; i++) {
        	System.out.print(visited[i] + " ");
        }
        
        //if (start == 1) {
        //	visited[start] = false;
        //}
        
        for (int i = 1; i < map.length; i++) {
            if (map[start][i] == 1 && !visited[i]) { // 표시와 방문여부
                visited[i] = true; // 방문 표시
                dfs(i); // 재귀호출
            }
        }
 
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        edge = sc.nextInt(); // 정점
        vertices = sc.nextInt(); // 간선
        V = sc.nextInt(); // 탐색시작 정점
        map = new int[edge + 1][edge + 1];
        
        for (int i = 1; i <= vertices; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            map[row][col] = 1;
            map[col][row] = 1;
        }
 
        visited = new boolean[edge + 1];
        dfs(V);
       
    }
 
}