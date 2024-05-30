package school;

import java.util.*;

public class BipartiteGraph {
	private int vertices;
    private LinkedList<Integer> adj[];

    BipartiteGraph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isBipartiteUtil(int src, int colorArr[]) {
        colorArr[src] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                } else if (colorArr[v] == colorArr[u]) return false;
            }
        }
        return true;
    }

    boolean isBipartite() {
        int colorArr[] = new int[vertices];
        Arrays.fill(colorArr, -1);

        for (int i = 0; i < vertices; i++)
            if (colorArr[i] == -1)
                if (!isBipartiteUtil(i, colorArr)) return false;

        return true;
    }

    public static void main(String args[]) {
        BipartiteGraph g = new BipartiteGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        if (g.isBipartite())
            System.out.println("Graph is bipartite");
        else
            System.out.println("Graph is not bipartite");
    }
}

