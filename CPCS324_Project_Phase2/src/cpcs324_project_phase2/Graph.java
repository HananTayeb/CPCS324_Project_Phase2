/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Graph {

    /**
     * Vertices number
     */
    static int veticesNo;

    /**
     * Edges number
     */
    static int edgeNo;

    /**
     * Directed graph
     */
    public static boolean isDigraph;

    static String labels;
    public static int[][] Matrix;
    
////////////////////////////////**Constructor**////////////////////////////////////////////////////////////
    Graph(int veticesNo, int edgeNo) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        Vertex.adjList = new LinkedList[veticesNo];
        //initialize adjacency lists for all the verts
        for (int i = 0; i < veticesNo; i++) {
            Vertex.adjList[i] = new LinkedList<>();
        }
        Matrix = new int[veticesNo][veticesNo];
        for (int i = 0; i < Graph.veticesNo; i++) {
            for (int j = 0; j < Graph.veticesNo; j++) {
                Matrix[i][j] = 999999;
                if (i == j) {
                    Matrix[i][j] = 0;
                }
            }
        }
    }

////////////////////////////////**makeGraph**////////////////////////////////////////////////////////////
    public void makeGraph(Graph graph) {
        // object of Random class
        Random randm = new Random();
        // ensure that all verts are connected
        for (int i = 0; i < veticesNo - 1; i++) {
            int weight = randm.nextInt(20) + 1;//generate random edge weights between 1-20
            addEdge(i, i + 1, weight); //connect verts
        }

        // generate edges bewteen verts with the remaining edges
        int remEdges = edgeNo - (veticesNo - 1);

        for (int i = 0; i < remEdges; i++) {
            int source = randm.nextInt(graph.veticesNo);
            int target = randm.nextInt(graph.veticesNo);
            if (target == source || Vertex.isVisited(source, target, Vertex.adjList)) { // to avoid self loops and duplicate edges
                i--;
                continue;
            }
            // generate random weights in range 1 to 20
            int weight = randm.nextInt(20) + 1;
            // add edge to the graph
            addEdge(source, target, weight);

        }

    }

////////////////////////////////**addEdge**////////////////////////////////////////////////////////////
    private void addEdge(int source, int target, int weight) {
        Edge edge = new Edge(source, target, weight); //vertex instead?
        Vertex.adjList[source].addFirst(edge);

        edge = new Edge(target, source, weight);
        Vertex.adjList[target].addFirst(edge);//for undirected graph
        if (isDigraph == true) {
            Matrix[source][target] = weight;
        } else if (isDigraph == false) {
            Matrix[source][target] = weight;
            Matrix[target][source] = weight;
        }

    }

////////////////////////////////**setDigraph**////////////////////////////////////////////////////////////
    public static void setDigraph(boolean isDigraph) {
        Graph.isDigraph = isDigraph;
    }

////////////////////////////////**chooseGraph**////////////////////////////////////////////////////////////
    static void chooseGraph() throws FileNotFoundException {
        //Create File object
        File file = new File("fileName.txt");
        Scanner input = new Scanner(file);
        if (!file.exists()) {
            System.out.print("Input file does not exist");
            System.exit(0);
        }

        while (input.hasNext()) {//Read from File
            String g = input.nextLine();
            veticesNo = input.nextInt();
            if (g.equalsIgnoreCase("digraph 0")) {// if it is not directed graph
                Matrix = new int[veticesNo][veticesNo];
                for (int i = 0; i < Graph.veticesNo; i++) {
                    for (int j = 0; j < Graph.veticesNo; j++) {
                        Matrix[i][j] = 999999;
                    }
                }
                while (input.hasNext()) {
                    labels = input.next();
                    int i = input.nextInt();
                    int j = input.nextInt();
                    int weight = input.nextInt();
                    Matrix[i][j] = weight;
                    Matrix[j][i] = weight;
                }
            } else if (g.equalsIgnoreCase("digraph 1")) {// if it is directed graph
                Matrix = new int[veticesNo][veticesNo];
                for (int i = 0; i < Graph.veticesNo; i++) {
                    for (int j = 0; j < Graph.veticesNo; j++) {
                        Matrix[i][j] = 999999;
                    }
                }
                while (input.hasNext()) {
                    labels = input.next();
                    int i = input.nextInt();
                    int j = input.nextInt();
                    int weight = input.nextInt();
                    Matrix[i][j] = weight;
                }
            }
        }
        input.close();
    }

}
