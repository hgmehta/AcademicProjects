/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityroutmapping;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
/**
 *
 * @author harsh
 */
public class CityRoutMapping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//---------------------------initialization part..-------------------------------------------------------------------
    int lines = 0;
    int s=0,e=0,w=0;
    Scanner input = new Scanner(System.in);
    String []busStandsName;
    int adjacency_matrix[][];
    int departure_0_arrival_1[] = new int[2];
    //int departure_0_arrival_1[];
//-------------------------------------------------------------------------------------------------------------------
    
    
//-------------------------Start of try catch block..----------------------------------------------------------------
//      This block counts a busStands and acording to that number it will make an 2D array of that size..
        try{
            File file = new File("BusStandDetails.txt");
            Scanner in = new Scanner(file);
            while(in.hasNextLine()){
                lines++;
                        String line = in.nextLine();
                }
        }catch (Exception ex){
                System.out.print("\nThere is an error in your program");	
        }     
//----------------ending of try catch block..-------------------------------------------------------------------------        
        
        
        //Making an object of BusStands class..
        BusStands get = new BusStands(lines);
        busStandsName = new String[lines];
        busStandsName = get.getWord();
        
        
        Graph theGraph = new Graph(lines);
        
        for(int i =0;i<lines;i++){
            theGraph.addVertex(i);
        }
        
        
//--------------Starting of try catch block..-------------------------------------------------------------------------    
//      This block will make a graph by reading a text file..
        try{  
                FileInputStream fin=new FileInputStream("CoadAndDistance.txt");  
                int i=0;  
                String readWord ="",data="";
                String start="",end="",distance="";
                    while((i=fin.read())!=-1){  
                        readWord = readWord + (char)i;
                        if((char)i == '\n'){
                            data = readWord;
                            readWord="";
                            for(int d=0;d<=2;d++){
                                start = start + data.charAt(d);
                                
                            }//end of for..
                            s = Integer.parseInt(start);
                            for(int d=4;d<=6;d++){
                                end = end + data.charAt(d);    
                            }//end of for.. 
                            e = Integer.parseInt(end);
                            for(int d=8;d<=11;d++){
                                distance = distance + data.charAt(d);
                            }//end of for..
                            w = Integer.parseInt(distance);
                            start = "";
                            end = "";
                            distance ="";
                            theGraph.addEdge(s,e,w);
                        }//end of if..
                    }//end of while..
                fin.close();
                }catch(Exception error){
                          System.out.print("\n"+error);
                }//end of try catch.
        
//------------------End of try catch block----------------------------------------------------------------------------- 

        
//--------------Start of while loop..Menu------------------------------------------------------------------------------
        //This part give shortest path acording to selected algorithm..
        
        while(true){
            System.out.print("\n1.BFS");
            System.out.print("\n2.DFS");
            System.out.print("\n3.Dijkstra Algorithm");
            System.out.print("\n4.Exit");
            System.out.print("\nChoose algorithm: ");
            int select = input.nextInt();
            switch(select){
                case 1:
                    departure_0_arrival_1 = get.enterStation();
                    //this sentences print the name of the bustands
                    System.out.print("\nYour departure station is: " + get.splitName(departure_0_arrival_1[0]));
                    System.out.print("\nYour arrival station is: " + get.splitName(departure_0_arrival_1[1]) + "\n");
                    System.out.print("\n" + theGraph.breadthFirstSearch(departure_0_arrival_1[0],departure_0_arrival_1[1],get));
                    System.out.print("\n");
                    break;
                case 2:
                    departure_0_arrival_1 = get.enterStation();
                    //this sentences print the name of the bustands
                    System.out.print("\nYour departure station is: " + get.splitName(departure_0_arrival_1[0]));
                    System.out.print("\nYour arrival station is: " + get.splitName(departure_0_arrival_1[1]) + "\n");
                    System.out.print("\n" + theGraph.depthFirstSearch(departure_0_arrival_1[1],departure_0_arrival_1[0],get));
                    System.out.print("\n");
                    break;
                case 3:
                    adjacency_matrix = new int[lines][lines];
                    adjacency_matrix = theGraph.getAjdMatrix();
                    for (int i = 0; i < lines; i++){
                        for (int j = 0; j < lines; j++){
                            //adjacency_matrix[i][j] = scan.nextInt();
                            if (i == j){
                                adjacency_matrix[i][j] = 0;
                                continue;
                            }
                            if (adjacency_matrix[i][j] == 0){
                                adjacency_matrix[i][j] =  Integer.MAX_VALUE;
                            }
                        } 
                    } 
                    departure_0_arrival_1 = get.enterStation();
                    DijkstraAlgorithm dij = new DijkstraAlgorithm(lines);
                    dij.dijkstra_algorithm(adjacency_matrix, departure_0_arrival_1[0]);           
                    System.out.println("The Shorted Path from " + get.splitName(departure_0_arrival_1[0]));	  
                    System.out.println("to " + get.splitName(departure_0_arrival_1[1]) + "\n" + "is " + (double)(dij.getDistances(departure_0_arrival_1[1]))/1000 + " Km");
                    //System.out.println("nodes :: " );
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.print("\nPlease select corect choice");
            }//end of switch(select)..
        }//end of while(true).. 
//--------end of while loop..-----------------------------------------------------------------------------------------        

        
//----------------Extra part------------------------------------------------------------------------------------------
        //System.out.print("\n Visites: ");
        //theGraph.breadthFirstSearch(departure_0_arrival_1[0],departure_0_arrival_1[1],get);
//---------------------------------------------------------------------------------------------------------------------        
                   
    }//end of main..
}//end of class..