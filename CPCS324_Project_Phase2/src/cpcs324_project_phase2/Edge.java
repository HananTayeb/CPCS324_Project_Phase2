/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

public class Edge {

    /**
     * source Vertex
     */
    private int source;

    /**
     * target vertex;
     */
    private int target;

    /**
     * parent of the vertex
     */
    public static int[] parent;

    /**
     * weight of the edge
     */
    public static int weight;

    ////////////////////////////////**Constructor**////////////////////////////////////////////////////////////
    Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    ////////////////////////////////**makeSet**////////////////////////////////////////////////////////////
    public static void makeSet(int[] parent) {
        //Make set: creating a new element with a parent pointer to itself.
        for (int i = 0; i < Graph.veticesNo; i++) {
            parent[i] = i;
        }
    }

    ////////////////////////////////**getSource**////////////////////////////////////////////////////////////
    public int getSource() {
        return source;
    }

    ////////////////////////////////**setSource**////////////////////////////////////////////////////////////
    public void setSource(int source) {
        this.source = source;
    }
////////////////////////////////**getTarget**////////////////////////////////////////////////////////////

    public int getTarget() {
        return target;
    }

    ////////////////////////////////**setTarget**////////////////////////////////////////////////////////////
    public void setTarget(int target) {
        this.target = target;
    }

    ////////////////////////////////**getWeight**////////////////////////////////////////////////////////////
    public int getWeight() {
        return weight;
    }

    ////////////////////////////////**setWeight**////////////////////////////////////////////////////////////
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
