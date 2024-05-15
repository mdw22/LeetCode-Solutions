package Java;

import java.util.LinkedList;
import java.util.Queue;

public class Graphs {
    int vertices;
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked") Graphs(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) { adjList[u].add(v); }

    void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        visited[startNode] = true;
        queue.add(startNode);

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for(int neighbor : adjList[currentNode]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        java.util.Iterator<Integer> i = adjList[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) dfsUtil(n, visited);
        }
    }

    void dfs(int v) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(v, visited);
    }
}
