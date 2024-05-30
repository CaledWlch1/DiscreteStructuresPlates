package school;

import java.util.*;

public class GraphIsomorphism {
	private int vertices;
    private int[][] adjMatrix;

    GraphIsomorphism(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int v, int w) {
        adjMatrix[v][w]++;
        adjMatrix[w][v]++;
    }

    boolean areIsomorphic(GraphIsomorphism g) {
        if (this.vertices != g.vertices) return false;

        int[] degreeSeq1 = getDegreeSequence(this.adjMatrix);
        int[] degreeSeq2 = getDegreeSequence(g.adjMatrix);

        return Arrays.equals(degreeSeq1, degreeSeq2);
    }

    private int[] getDegreeSequence(int[][] matrix) {
        int[] degreeSeq = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            int degree = 0;
            for (int j = 0; j < vertices; j++) degree += matrix[i][j];
            degreeSeq[i] = degree;
        }
        Arrays.sort(degreeSeq);
        return degreeSeq;
    }

    public static void main(String args[]) {
        GraphIsomorphism g1 = new GraphIsomorphism(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);

        GraphIsomorphism g2 = new GraphIsomorphism(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 0);

        if (g1.areIsomorphic(g2))
            System.out.println("Graphs are isomorphic");
        else
            System.out.println("Graphs are not isomorphic");
    }
}

