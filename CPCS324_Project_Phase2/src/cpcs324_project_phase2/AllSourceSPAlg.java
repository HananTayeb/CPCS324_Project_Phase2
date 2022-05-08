/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

public class AllSourceSPAlg extends ShortestPathAlgorithm {

    static int size;
    static int INF;
    static boolean[] isVisited;
    static int[] distance;
    static String[] path;

    ////////////////////////////////**Constructor**////////////////////////////////////////////////////////////
    public AllSourceSPAlg() {

        // Check the size
        size = Graph.veticesNo;
        INF = 999999;
        // Prepare the other material we need
        isVisited = new boolean[size];
        distance = new int[size];
        path = new String[size];
        // Make all the vertices unvisited and distance as infinity
        for (int i = 0; i < size; i++) {
            isVisited[i] = false;
            distance[i] = INF;
        }
    }

    ////////////////////////////////**computeDijkstraAlg**////////////////////////////////////////////////////////////
    public static void computeDijkstraAlg() {

        // Take the source as the first vertix 'A', and prepare the paths
        distance[0] = 0;
        path[0] = "A --" + distance[0] + "--> ";

        // --- Start Dijkstra ---
        for (int i = 0; i < size; i++) {
            // Find the minium distance among all the vertices
            int u = -1;
            int minDistance = INF;
            for (int j = 0; j < size; j++) {
                if (isVisited[j] != true && distance[j] < minDistance) {
                    minDistance = distance[j];
                    u = j; // Min vertix index
                }
            }

            // Set u as visited
            isVisited[u] = true;

            for (int n = 0; n < Graph.veticesNo; n++) {
                for (int m = 0; m < Graph.veticesNo; m++) {
                    M[n][m] = Graph.Matrix[n][m];
                }
            }

            // Update the adjacent distances
            for (int v = 0; v < size; v++) {
                if (isVisited[v] != true && !(M[u][v] == (INF)) && !(M[u][v] == 0)) {
                    if ((distance[u] + M[u][v]) < distance[v]) {
                        distance[v] = distance[u] + M[u][v];
                        // Update the path by adding the parent path plus the current vertix path
                        path[v] = path[u] + (char) (v + 65) + " --" + (distance[v] - distance[u]) + "--> ";
                    }
                }
            }
        }

        printDijkstraGraph(M);
    }

    ////////////////////////////////**printDijkstraGraph**////////////////////////////////////////////////////////////
    static void printDijkstraGraph(int graph[][]) {
        // Print all the distances with the pathes
        System.out.println("\n----- Dijkstra Algorithm -----");
        System.out.println("All the shortest distances from vertex 'A' to other vertices in graph");
        for (int i = 0; i < size; i++) {
            System.out.println("  > Shortest Distance from 'A' to '" + (char) (i + 65) + "' is " + distance[i] + ", the Path: " + path[i] + " " + (char) (i + 65) + " " + distance[i]);
        }
        System.out.println();
    }
}
