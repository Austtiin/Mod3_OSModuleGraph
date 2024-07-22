//Graph.java
// Graph class to represent a graph as an adjacency list
//
// Austin Stephens
// 07/21/2024
// Professor Kumar
// COT4530C
// Module 03 CP


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    //Constructor to create a graph with a given number of nodes
    private int nodes;
    //Adjacency list to store the edges
    private final ArrayList<List<Integer>> adjList;

    //Constructor to create a graph with a given number of nodes
    public Graph(int nodes) {
        //Initialize the graph with the given number of nodes
        this.nodes = nodes;
        //Create an adjacency list with the given number of nodes
        adjList = new ArrayList<>();

        //for each node, create an empty list to store the edges
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }


    //addEdge method to add an edge between two nodes
    public void addEdge(int src, int dest) {

        //Check if the source and destination nodes are valid
        //if the source and destination nodes are valid and the edge does not already exist, add the edge
        //to the adjacency list
        if (src >= 0 && src < nodes && dest >= 0 && dest < nodes && src != dest && !adjList.get(src).contains(dest)) {

            //Add the edge to the adjacency list
            adjList.get(src).add(dest);
        }
    }

    //readFromFile method to read the graph from a file
    public void readFromFile(String filename) throws IOException {
        //Read the graph from the file
        //The file should contain a list of edges in the format "src dest"
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            //Read each line from the file here
            while ((line = br.readLine()) != null) {
                //Split the line into two parts: the source and destination nodes
                String[] parts = line.split(" ");
                int src = Integer.parseInt(parts[0]);
                int dest = Integer.parseInt(parts[1]);

                //then add the edge to the graph
                addEdge(src, dest);
            }
        }
    }

    //printList method to print the adjacency list
    public void printList() {
        //Print the adjacency list

        for (int i = 0; i < nodes; i++) {
            //Print the adjacency list for each node
            System.out.print("Adjacency list of vertex " + i + " head -> ");
            for (int j : adjList.get(i)) {
                //Print the edges for each node
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}