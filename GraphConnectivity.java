package school;
import java.util.*;

class GraphConnectivity {
    private int vertices;
    private LinkedList<Integer> adj[];

    GraphConnectivity(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFS(int v, boolean visited[]) {
        visited[v] = true;
        for (int n : adj[v]) if (!visited[n]) DFS(n, visited);
    }

    boolean isConnected() {
        boolean visited[] = new boolean[vertices];
        DFS(0, visited);
        for (boolean visit : visited) if (!visit) return false;
        return true;
    }

    int connectedComponents() {
        boolean visited[] = new boolean[vertices];
        int count = 0;
        for (int v = 0; v < vertices; ++v) {
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        GraphConnectivity g = new GraphConnectivity(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        
        if (g.isConnected())
            System.out.println("Graph is connected");
        else {
            System.out.println("Graph is not connected");
            System.out.println("Number of connected components: " + g.connectedComponents());
        }
    }
}
