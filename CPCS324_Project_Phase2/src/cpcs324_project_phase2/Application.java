/*
CPCS324 - Algorithms and Data Structures 2
Project Part 2
Group Members:
Renad Saud Alsulami - 1905991 - DAR
Rimas Ali Alqahtani - 1905479 - DAR
Hanan Abdullah Tayeb - 1905913 - BAR
 */
package cpcs324_project_phase2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        int choiceAlgo;
        int choiceG;
        double startTime;
        double finishTime;
        Scanner input = new Scanner(System.in);

        while (true) {
            //Print menu
            System.out.println("-------------------- WELCOME --------------------------");
            System.out.println("Choose from the menu:");
            System.out.println("-Enter 1 for Floyd-Warshall Algorithm");
            System.out.println("-Enter 2 for Dijkstra Algorithm");
            System.out.println("-Enter 0 to Quit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter Your Choice: ");
            choiceAlgo = input.nextInt();
            while (choiceAlgo < 0 || choiceAlgo > 2) {
                System.out.println("Invalid input!");
                System.out.print("-Enter Your Choice: ");
                choiceAlgo = input.nextInt();
            }
            if (choiceAlgo == 0) {
                System.out.println("\n----------------------------------------------");
                System.out.println("             -- Thank You --");
                System.out.println("----------------------------------------------");
                // Terminate while loop
                break;
            }
            System.out.println("----------------------------------------------");
            System.out.println("-Enter 1 for you want the graph from file");
            System.out.println("-Enter 2 for randomly generated graphs");
            System.out.println("----------------------------------------------");
            System.out.print("Enter Your Choice: ");
            choiceG = input.nextInt();
            while (choiceG < 1 || choiceG > 2) {
                System.out.println("Invalid input!");
                System.out.print("-Enter Your Choice: ");
                choiceG = input.nextInt();
            }
            if (choiceG == 1) {//The graph from file
                Graph.chooseGraph();
                switch (choiceAlgo) {
                    case 1: {//Floyd-Warshal algorithm
                        System.out.println("\n ---- Graph Floyd-Warshal ---- \n");
                        startTime = System.currentTimeMillis();
                        ShortestPathAlgorithm FloydWarshall = new SingleSourceSPAlg(); // Call the Floyd-Warshall algorithm and make graph
                        SingleSourceSPAlg.computeFloydWarshalAlg();//Compute the result of the Floyd-Warshal algorithm
                        finishTime = System.currentTimeMillis();
                        double totalTime = finishTime - startTime;
                        System.out.println("----------------------------------------------");
                        System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                        break;
                    }
                    case 2: {//Dijkstra algorithm
                        startTime = System.currentTimeMillis();
                        ShortestPathAlgorithm Dijkstra = new AllSourceSPAlg(); // Call the Dijkstra algorithm and make graph
                        AllSourceSPAlg.computeDijkstraAlg();//Compute the result of the Dijkstra algorithm
                        finishTime = System.currentTimeMillis();
                        System.out.println("----------------------------------------------");
                        double totalTime = finishTime - startTime;
                        System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                        break;
                    }
                    default:
                        System.out.println("\n-- Wrong input, please try again --\n");
                        break;
                }
            } else if (choiceG == 2) {//Randomly generated graphs
                System.out.println(">>Test  cases : (where n is the number of vertices "
                        + "and m is the number of edges: ");
                System.out.println(" 1:  n=5,000 ,  m=25,000");
                System.out.println(" 2:  n=10,000 ,  m=50,000");
                System.out.println(" 3:  n=15,000 ,  m=75,000");
                System.out.println(" 4:  n=20,000 ,  m=100,000");
                System.out.println(" 5:  n=25,000 ,  m=125,000");
                System.out.print(">> Enter a case to test: ");
                //UserChoiceCase to choice case number from 1 to 5 by user
                int UserChoiceCase = input.nextInt();
                int n = 0, m = 0;

                while (UserChoiceCase < 1 || UserChoiceCase > 5) {
                    System.out.println("Invalid input!");
                    System.out.print("> Enter a case to test: ");
                    UserChoiceCase = input.nextInt();
                }
                // switch for all avaliable cases of the test 
                switch (UserChoiceCase) {
                    case 1: {
                        n = 4000;
                        m = 20000;
                    }
                    break;
                    case 2: {
                        n = 6000;
                        m = 30000;
                    }
                    break;
                    case 3: {
                        n = 8000;
                        m = 40000;
                    }
                    break;
                    case 4: {
                        n = 10000;
                        m = 50000;
                    }
                    break;
                    case 5: {
                        n = 12000;
                        m = 60000;
                    }
                    break;

                    default: {
                        System.out.println("Invalid input!");
                        break;
                    }
                }

                Graph graph2 = new Graph(n, m);
                System.out.print("Is the graph directed?\n>> enter T for true or F for false:");
                String isDigraph = input.next();
                if (isDigraph.equalsIgnoreCase("T")) {
                    Graph.setDigraph(true);
                    graph2.makeGraph(graph2);
                    switch (choiceAlgo) {
                        case 1: {
                            System.out.println("\n ---- Graph Floyd-Warshal ---- \n");
                            startTime = System.currentTimeMillis();
                            ShortestPathAlgorithm FloydWarshall = new SingleSourceSPAlg(); // Call the Floyd-Warshall algorithm and make graph
                            SingleSourceSPAlg.computeFloydWarshalAlg();//Compute the result of the Floyd-Warshal algorithm
                            finishTime = System.currentTimeMillis();
                            double totalTime = finishTime - startTime;
                            System.out.println("----------------------------------------------");
                            System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                            break;
                        }
                        case 2: {
                            startTime = System.currentTimeMillis();
                            ShortestPathAlgorithm Dijkstra = new AllSourceSPAlg(); // Call the Dijkstra algorithm and make graph
                            AllSourceSPAlg.computeDijkstraAlg();//Compute the result of the Dijkstra algorithm
                            finishTime = System.currentTimeMillis();
                            System.out.println("----------------------------------------------");
                            double totalTime = finishTime - startTime;
                            System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                            break;
                        }
                        default:
                            System.out.println("\n-- Wrong input, please try again --\n");
                            break;

                    }

                } else {
                    Graph.setDigraph(false);
                    graph2.makeGraph(graph2);

                    switch (choiceAlgo) {
                        case 1: {
                            System.out.println("\n ---- Graph Floyd-Warshal ---- \n");
                            startTime = System.currentTimeMillis();
                            ShortestPathAlgorithm FloydWarshall = new SingleSourceSPAlg(); // Call the Floyd-Warshall algorithm and make graph
                            SingleSourceSPAlg.computeFloydWarshalAlg();//Compute the result of the Floyd-Warshal algorithm
                            finishTime = System.currentTimeMillis();
                            double totalTime = finishTime - startTime;
                            System.out.println("----------------------------------------------");
                            System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                            break;
                        }
                        case 2: {
                            startTime = System.currentTimeMillis();
                            ShortestPathAlgorithm Dijkstra = new AllSourceSPAlg(); // Call the Dijkstra algorithm and make graph
                            AllSourceSPAlg.computeDijkstraAlg();//Compute the result of the Dijkstra algorithm
                            finishTime = System.currentTimeMillis();
                            System.out.println("----------------------------------------------");
                            double totalTime = finishTime - startTime;
                            System.out.println("Runtime (in Milliseconds) : " + totalTime + "\n\n");
                            break;
                        }
                        default:
                            System.out.println("\n-- Wrong input, please try again --\n");
                            break;

                    }

                }
            }

        }

    }
}
