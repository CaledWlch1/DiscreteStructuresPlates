package school;

import java.util.*;

public class VertexDegree {
	private int vertices;
    private LinkedList<Integer> adj[];

    VertexDegree(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void printDegrees() {
        for (int v = 0; v < vertices; ++v) {
            System.out.println("Vertex " + v + " has degree " + adj[v].size());
        }
    }

    public static void main(String args[]) {
        VertexDegree g = new VertexDegree(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        
        g.printDegrees();
    }
}

