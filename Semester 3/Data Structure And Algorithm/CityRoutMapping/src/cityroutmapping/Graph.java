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

public class Graph {

//----------Initialization-----------------------------------------------------------------------------------------------    
    private int max_vertex;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVertex;
    private Queue theQueue;
    private Stack theStack,printStack;
//----------End of initialization---------------------------------------------------------------------------------------
    
    
//---------------Start of constructor-----------------------------------------------------------------------------------
    public Graph(int vertex){
        max_vertex = vertex;
        vertexList = new Vertex[max_vertex];
        
        adjMat = new int[max_vertex][max_vertex];
        nVertex = 0;
        for(int i=0;i<max_vertex;i++){
            for(int j=0;j<max_vertex;j++){
                adjMat[i][j]=0;
            }
        }
        //theQueue = new Queue(max_vertex);
        theQueue = new Queue();
        theStack = new Stack();
        printStack = new Stack();
// theStack = new Stack();
    }//end of constructor..
//----------------------------End of constructor------------------------------------------------------------------------

    
//-------------------Start of addVertex(int lab)------------------------------------------------------------------------    
    public void addVertex(int lab){
        nVertex = lab;
        vertexList[nVertex] = new Vertex(lab);
    }
//----------------End of addVertex(int lab)----------------------------------------------------------------------------
    
    
//-------------Start of addEdge(int start,int end,int weight)----------------------------------------------------------    
    public void addEdge(int start,int end,int weight){
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }
//--------------End of addEdge(int start,int end,int weight)-----------------------------------------------------------    
    
    
//------------Start of displayVertex(int v)-----------------------------------------------------------------------------     
    public void displayVertex(int v){
        System.out.print(vertexList[v].getLabel());
    }
//-------------------End of displayVertex(int v)-----------------------------------------------------------------------
    
    
//----------------Start of printGraph()--------------------------------------------------------------------------------   
    public void printGraph(){
            for(int j=0;j<max_vertex;j++){
                System.out.print(j + "\t");
            }//end of for..
            
            System.out.print("\n");
            
            for(int i=0;i<max_vertex;i++){
                for(int j=0;j<max_vertex;j++){
                    System.out.print(adjMat[i][j]+"\t");
                }//end of inner for..
                System.out.print("\n");
            }//end of outter for..
    }//end of printGraph..
//-----------------End of printGraph()---------------------------------------------------------------------------------    
    
    public int[][] getAjdMatrix(){
        return adjMat;
    }
    
//------------start of breadthFirstSearch(int start,int end , BusStands bus)-------------------------------------------     
    public String breadthFirstSearch(int start,int end , BusStands bus){
        //theStack = new Stack();
        vertexList[start].setWasVisited(true);// = true;
        int i=0;
        theQueue.insert(start);
        printStack.push(start);
        String s = ""; 
        int v2;
        
        while(!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            v2 = getAdjUnvisitedVertex(v1);
            while(v2 != -1){
                if(v2 != end){
                    vertexList[v2].setWasVisited(true);// = true;
                    printStack.push(v2);
                    theQueue.insert(v2);
                    v2 = getAdjUnvisitedVertex(v1);
                }else if(v2 == end){
                    printStack.push(v2);
                    break;
                }//end of (v2 != end)..else if(v2 == end)..
            }//end of while(v2 != -1)..
                if(v2 == end){
                    break;
                }//end of if(v2 == end)..
        }//end of (!theQueue.isEmpty())..
        
        for(int j=0;j<nVertex;j++){
            vertexList[j].setWasVisited(false);// = false;
        }//end of for..
        
        theQueue.makeQueueEmpty();

        int first = printStack.peek();
        s = s + bus.splitName(first);
        printStack.pop();
        double dist=0;
        while(!printStack.isEmpty()){
            boolean isAdj = isAdjcent(first,printStack.peek());
            if(isAdj){
                dist = dist + adjMat[first][printStack.peek()];
                s = bus.splitName(printStack.peek())+ "\n" + s;
                first = printStack.peek();
                printStack.pop();
            }else{
                if(!printStack.isEmpty()){
                    printStack.pop();
                }//end of if(!theStack.isEmpty())..
            }//end of if(isAdj).. else..
        }//end of while(!theStack.isEmpty())..
        
        printStack.makeStackEmpty();
        
        s = s + "\n\n Distance from\n " + bus.splitName(start) + "\n" + " to\n " + bus.splitName(end) + "\n" + " is : " + dist + " m" + "(" + dist/1000 + " Km)";
        return s;
    }//end of breadthFirstSearch..
//---------------------End of breadthFirstSearch(int start,int end , BusStands bus)-----------------------------------
    
    
//-------------------Start of depthFirstSearch(int start,int end , BusStands bus)-------------------------------------
    public String depthFirstSearch(int start,int end , BusStands bus){
        //Stack theStack = new Stack(); 
        vertexList[start].setWasVisited(true);// = true;
        //int i=0;
        printStack.push(start);
        theStack.push(start);
        String s = ""; 
        int v2;
        
        while(!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            while(v != -1){
               if(v == end){
                    printStack.push(v);
                    break;
                }else{
                    vertexList[v].setWasVisited(true);// = true;
                    theStack.push(v);
                    printStack.push(v);
                    //theStack.pop();
                    v = getAdjUnvisitedVertex(theStack.peek());
                } 
            }//end of while(v != -1) 
            if(v == end){
                printStack.push(v);
                break;
            }//end of if(v == end)
            theStack.pop();
        }//end of (!theQueue.isEmpty())..
        
        for(int j=0;j<nVertex;j++){
            vertexList[j].setWasVisited(false);// = false;
        }//end of for..

        theStack.makeStackEmpty();
        
        int first = printStack.peek();
        s = s + bus.splitName(first);
        printStack.pop();
        double dist = 0;
        while(!printStack.isEmpty()){
            boolean isAdj = isAdjcent(first,printStack.peek());
            if(isAdj){
                dist = dist + adjMat[first][printStack.peek()];
                s = s + "\n" + bus.splitName(printStack.peek());// + "\n" + s;
                first = printStack.peek();
                printStack.pop();
            }else{
                if(!printStack.isEmpty()){
                    printStack.pop();
                }//end of if(!theStack.isEmpty())..
            }//end of if(isAdj).. else..
        }//end of while(!theStack.isEmpty())..
        
        printStack.makeStackEmpty();
        s = s + "\n\n Distance from\n " + bus.splitName(start) + "\n" + " to\n " + bus.splitName(end) + "\n" + " is : " + dist + " m" + "(" + dist/1000 + " Km)"; 
        return s;
        //System.out.print("\nDistance from " + end + " to " + start + " is: " + dist + " m" + "(" +dist/1000 + " Km)");//
         
    }//end of depthFirstSearch..
//-------------------End of depthFirstSearch(int start,int end , BusStands bus)--------------------------------------- 
    
    
//--------------Start of int getAdjUnvisitedVertex(int v)-------------------------------------------------------------
    public int getAdjUnvisitedVertex(int v){
        for(int j=0;j<nVertex;j++){
            if(adjMat[v][j] !=0 && vertexList[j].getWasVisited() == false){
               
                return j;
            }//end of if..
        }//end of for..
        return -1;
    }//end of getAdjUnvisitedVertex..
//--------------End of int getAdjUnvisitedVertex(int v)----------------------------------------------------------------
    
    
//--------------Start of boolean isAdjcent(int first,int second)-------------------------------------------------------   
    public boolean isAdjcent(int first,int second){
        for(int j=0;j<nVertex;j++){
            if(adjMat[first][second] !=0){
             return true;
            }//end of if(adjMat[first][second] !=0)..
        }//end of for..
        return false;
    }//end of isAdjcent..
//--------------------End of boolean isAdjcent(int first,int second)----------------------------------------------------    
     
}//end of class Graph.
