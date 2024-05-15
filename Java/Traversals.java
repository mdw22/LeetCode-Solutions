package Java;

import java.util.*;
import java.io.*;

import javax.swing.event.ListDataEvent;
import javax.swing.text.html.HTMLDocument.Iterator;
import Java.Graphs;
import Java.sumOfDistances.Graph;


public class Traversals {

    public static void main(String[] args) {
        Graphs g = new Graphs(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        // Function call
        g.dfs(2);
        System.out.println();

        int vertices = 5;

        // Create a graph
        Graphs graph = new Graphs(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.println(
            "Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);
    }
}
