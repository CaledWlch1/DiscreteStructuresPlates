package school;

import java.util.*;

public class AdjacencyMatrixWithLoops {
	private int vertices;
    private int[][] adjMatrix;

    AdjacencyMatrixWithLoops(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int v, int w) {
        adjMatrix[v][w]++;
    }

    void printAdjMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        AdjacencyMatrixWithLoops g = new AdjacencyMatrixWithLoops(4);
        g.addEdge(0, 1);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 2); // self loop

        g.printAdjMatrix();
    }
}

