/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    ////////////////////////////////**Constructor**////////////////////////////////////////////////////////////
    public SingleSourceSPAlg() {
        for (int i = 0; i < Graph.veticesNo; i++) {
            for (int j = 0; j < Graph.veticesNo; j++) {
                M[i][j] = Graph.Matrix[i][j];
            }
        }
    }

    public static void computeFloydWarshalAlg() {

        // Start the algorithm
        for (int k = 0; k < Graph.veticesNo; k++) {
            for (int i = 0; i < Graph.veticesNo; i++) {
                for (int j = 0; j < Graph.veticesNo; j++) {
                    M[i][j] = (Math.min(M[i][j], (M[i][k] + M[k][j])));
                }
            }
            // Print the graph after applying Floyd-Warshall's algorithm
            //printFloydWarshalGraph(M);
        }

    }

    static void printFloydWarshalGraph(int graph[][]) {

        //------ Print Header ----------------
        System.out.print("   ");
        for (int i = 0; i < Graph.veticesNo; i++) {
            System.out.printf("%-4s", (char) (i + 65));
        }
        System.out.println(); // Start new line

        // Print line
        for (int i = 0; i < Graph.veticesNo + 1; i++) {
            System.out.print("----");
        }
        System.out.println();//new line

        //---- Print Matrix -------------------
        for (int i = 0; i < Graph.veticesNo; i++) {
            System.out.print((char) (i + 65) + "| ");
            for (int j = 0; j < Graph.veticesNo; j++) {
                if (graph[i][j] == (999999)) {
                    System.out.print("∞ ,");
                } else {
                    System.out.printf("%-2d, ", graph[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
