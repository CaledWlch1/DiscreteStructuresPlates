package school;

import java.util.*;

public class IncidenceMatrix {
	private int vertices;
    private List<int[]> edges;

    IncidenceMatrix(int v) {
        vertices = v;
        edges = new ArrayList<>();
    }

    void addEdge(int v, int w) {
        edges.add(new int[]{v, w});
    }

    void printIncidenceMatrix() {
        int[][] incidenceMatrix = new int[vertices][edges.size()];

        for (int i = 0; i < edges.size(); i++) {
            int v = edges.get(i)[0];
            int w = edges.get(i)[1];
            incidenceMatrix[v][i] = 1;
            incidenceMatrix[w][i] = 1;
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        IncidenceMatrix g = new IncidenceMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printIncidenceMatrix();
    }
}

