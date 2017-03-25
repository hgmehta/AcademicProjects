/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityroutmapping;

/**
 *
 * @author harsh
 */
public class Vertex {

//----------Initialization-----------------------------------------------------------------------------------------------
    private int label;
    private boolean wasVisited;
//----------End of initialization----------------------------------------------------------------------------------------
    

//---------------Start of constructor------------------------------------------------------------------------------------    
    public Vertex(int lab){
        label = lab;
        wasVisited = false;
    }
//------------------End of constructor-----------------------------------------------------------------------------------
 

//----------------------Start of int getLabel()--------------------------------------------------------------------------
    public int getLabel(){
        return label;
    }
//--------------------------End of int getLabel()------------------------------------------------------------------------
    

//--------------------Start of boolean getWasVisited()-------------------------------------------------------------------
    public boolean getWasVisited(){
        return wasVisited;
    }
//---------------------------End of boolean getWasVisited()--------------------------------------------------------------
    

//--------------------------Start of setWasVisited(boolean visited)------------------------------------------------------
    public void setWasVisited(boolean visited){
        wasVisited = visited;
    }
//------------------------------End of setWasVisited(boolean visited)---------------------------------------------------

}//end of class Vertex..
