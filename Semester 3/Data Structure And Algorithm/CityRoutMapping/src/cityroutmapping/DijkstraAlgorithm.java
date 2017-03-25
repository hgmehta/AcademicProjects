/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityroutmapping;

/**
 *
 * @author gaurang
 */
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.InputMismatchException;

public class DijkstraAlgorithm{
    
    private int distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];
    public int[] a ;
    public int set = 0 ;
    
    public DijkstraAlgorithm(int number_of_nodes){
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes][number_of_nodes];
        a = new int[number_of_nodes*number_of_nodes];  
	}
    
        public void dijkstra_algorithm(int adjacency_matrix[][], int source){
        int evaluationNode;
        for (int i = 0; i < number_of_nodes; i++)
            for (int j = 0; j < number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 0; i < number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
        
        unsettled.add(source);
        distances[source] = 0;		
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        } 
    }
        
        private int getNodeWithMinimumDistanceFromUnsettled(){
        int min ;
        int iterator_node = 0;
 
        Iterator<Integer> iterator = unsettled.iterator();
        iterator_node = iterator.next();
        min = distances[iterator_node];
        for (int i = 0; i < distances.length; i++)
        {
            if (unsettled.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    iterator_node = i;			
                        a[set]=iterator_node;                      
                        set++;
		}
            }
        }
        return iterator_node;
    }
        public int getDistances(int dest){
            return distances[dest];
        }
        
        private void evaluateNeighbours(int evaluationNode){
        int edgeDistance = -1;
        int newDistance = -1;
 
        for (int destinationNode = 0; destinationNode < number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
   					   
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
}
