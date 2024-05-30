package school;

import java.util.*;

public class AdjacencyMatrix {
	    public static void listEdges(int[][] matrix) {
	        int n = matrix.length;
	        Map<String, Integer> edgeCount = new HashMap<>();

	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) {
	                if (matrix[i][j] > 0) {
	                    String edge = i + "-" + j;
	                    edgeCount.put(edge, matrix[i][j]);
	                }
	            }
	        }

	        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
	            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times");
	        }
	    }

	    public static void main(String[] args) {
	        int[][] matrix = {
	            {0, 1, 1, 0},
	            {1, 0, 0, 1},
	            {1, 0, 0, 1},
	            {0, 1, 1, 0}
	        };

	        listEdges(matrix);
	    }
	}

