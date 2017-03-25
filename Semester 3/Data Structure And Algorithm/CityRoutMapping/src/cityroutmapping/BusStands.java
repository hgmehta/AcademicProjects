/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityroutmapping;
import java.io.*;
import Exceptions.InvalidIndexException;
import java.util.*;
/**
 *
 * @author harsh
 */
public class BusStands {

//----intialization------------------------------------------------------------------------------------------------------    
    private String [] word;
    private int size;
//-----------------------------------------------------------------------------------------------------------------------

//--------Start of BusStands(int vertex)---------------------------------------------------------------------------------    
    public BusStands(int vertex){
        size = vertex;
        word = new String[size];
    }//end of cons..
//--------End of BusStands(int vertex)-----------------------------------------------------------------------------------
    
    
//---------Start of String[] getWord()-----------------------------------------------------------------------------------    
    public String[] getWord(){
                String readWord ="";
		try{  
			FileInputStream fin=new FileInputStream("BusStandDetails.txt");  
			int i=0,j=0;  
                            while((i=fin.read())!=-1){  
                                readWord = readWord + (char)i;
                                if((char)i == '\n'){
                                    word[j] = readWord;
                                    j++;
                                    readWord="";
                                }
                            }
			fin.close();
			}catch(Exception e){
				  System.out.print("\n"+e);
			}//end of try catch.
        return word;
    }//end of getWord function..
//---------End of String[] getWord()-------------------------------------------------------------------------------------    
    
    
//-------Start of selectStation()----------------------------------------------------------------------------------------    
    public void selectStation(){
        System.out.print("\n" + "code" + "\t" + "Bus stand");
        System.out.print("\n\n");
        for(int i = 0;i<size;i++){
            String name = "";
            for(int j=4;j<word[i].length()-1;j++){
                name = name + word[i].charAt(j);
            }
            String s = "";
            s = s + word[i].charAt(0) + word[i].charAt(1) + word[i].charAt(2);
            System.out.print("\n" + s + "\t" + name);
        }//end of for..
    }//end of selectStation..
//-----------End of selectStation()--------------------------------------------------------------------------------------    
    
    
//---------Start of String splitName(int index)--------------------------------------------------------------------------    
    public String splitName(int index){
        String name = "";
            for(int j=4;j<word[index].length()-1;j++){
                name = name + word[index].charAt(j);
            }
        return name;
    }
//--------End of String splitName(int index)-----------------------------------------------------------------------------
    
    
//--------Start of int[] enterStation()----------------------------------------------------------------------------------    
    public int[] enterStation(){
        int []index = new int[2];
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        selectStation();
        do{
            
                System.out.print("\nEnter code for departure station: ");
                index[0] = input.nextInt();
                System.out.print("\nEnter code for arrival station: ");
                index[1] = input.nextInt();
                if((index[0]>=0 || index[0]<=122) && (index[1]>=0 || index[1]<=122))
                    valid = false;
                else
				{
					valid = true;
					System.out.println("Please enter correct station")
				}
                    
        }while(valid);
        return index;
    }//end of enterStation..
//---------End of int[] enterStation()-----------------------------------------------------------------------------------    
 
    
//----------Start of String getBusStandName(String name)-----------------------------------------------------------------
    public String getBusStandName(String name){
        String busStand = "";
        for(int j=4;j<name.length()-1;j++){
                    busStand = busStand + name.charAt(j);
                }//end of for..
        return busStand;
    }//end of getBusStandName..
//---------End of String getBusStandName(String name)--------------------------------------------------------------------

}//end of class..