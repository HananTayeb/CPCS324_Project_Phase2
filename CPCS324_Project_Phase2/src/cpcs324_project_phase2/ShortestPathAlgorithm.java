/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

public class ShortestPathAlgorithm {

    //Create matrix
    static int[][] M = new int[Graph.veticesNo][Graph.veticesNo];

////////////////////////////////**Constructor**////////////////////////////////////////////////////////////
    public ShortestPathAlgorithm() {
        for (int i = 0; i < Graph.veticesNo; i++) {
            for (int j = 0; j < Graph.veticesNo; j++) {
                M[i][j] = Graph.Matrix[i][j];
            }
        }
    }
}
