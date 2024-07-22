// main.java
// Main class to test the Graph class
//
// Austin Stephens
// 07/21/2024
// Professor Kumar
// COT4530C
// Module 03 CP

//Instructions: To determine the dependencies of the classes/modules that make up the operating system,
// you are going to create a module that implements a directed graph.
// This module should be able to read a list of vertices along with their edges from a text file and return the adjacency
// lists for the involved module.

// Your output will resemble the following:
//Output:
//Adjacency list of vertex 0
//head -> 1-> 4
//Adjacency list of vertex 1
//head -> 0-> 2-> 3-> 4
//Adjacency list of vertex 2
//head -> 1-> 3
//Adjacency list of vertex 3
//head -> 1-> 2-> 4
//Adjacency list of vertex 4
//head -> 0-> 1-> 3


import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        // Create a graph with 5 nodes
        String filename = "graph.txt";
        Graph graph = new Graph(5);

        // Read the graph from a file
        File file = new File(filename);
        //If the file does not exist, print an error message and return
        if (!file.exists()) {
            System.err.println("File " + filename + " does not exist.");
            return;
        }

        // Read the graph from the file
        try {
            graph.readFromFile(filename);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Print the adjacency list
        System.out.println("Initial adjacency list:");
        graph.printList();

        // add some edges, just to test the addEdge method
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);

        // Print the adjacency list again
        System.out.println("Updated adjacency list:");
        graph.printList();
    }
}