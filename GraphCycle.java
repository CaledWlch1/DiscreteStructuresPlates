package school;

import java.util.*;

public class GraphCycle {
	private int vertices;
    private LinkedList<Integer> adj[];

    GraphCycle(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) return true;
            } else if (i != parent) return true;
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) if (!visited[i] && isCyclicUtil(i, visited, -1)) return true;
        return false;
    }

    public static void main(String args[]) {
        GraphCycle g = new GraphCycle(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}

