package Java;
import java.util.*;


public class sumOfDistances {
    
    public class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        private int RESULT;

        // Constructor
        @SuppressWarnings("unchecked") Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
            }
        }

        // Add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        // Helper function for DFS
        void DFSHelper(int v, boolean visited[]) {
            // Mark the current node as visited and add it to result
            visited[v] = true;
            RESULT += v;

            // Recur for all vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) DFSHelper(n, visited);
            }
        }

        // Function for DFS traversal 
        // Using recursive DFSHelper
        int DFS(int v) {
            RESULT = 0;
            boolean visited[] = new boolean[V];
            DFSHelper(v, visited);
            return RESULT;
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Graph g =  new Graph(n);
        for(int edge[] : edges) {
            g.addEdge(edge[0], edge[1]);
        }
        int[] result = new int[n];
        for(int i = 0; i < n; ++i) {
            result[i] = g.DFS(i);
        }
        return result;
    }
}
