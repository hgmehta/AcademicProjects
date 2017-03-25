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
public class Queue {
//----------Initialization-----------------------------------------------------------------------------------------------
    private Node head,last;
//----------End of initialization----------------------------------------------------------------------------------------
    
//-----------Start of counstuctor----------------------------------------------------------------------------------------
    public Queue(){ //This constructor initialize the pointers..
        head = null;
        last = null;
    }//end of Constructor.
//-----------End of counstructor-----------------------------------------------------------------------------------------

//---------------Start of insert(int data)-------------------------------------------------------------------------------
    public void insert(int data){   //This function add data in queue..
        Node newLink = new Node (data);
            if(head == null){
                    head = newLink;
                    last = head;
            }else{
                if(last == null){
                    System.out.print("\nNull");
                }//end of if..
                last.next = newLink;
                last = newLink;
            }//end of else..
    }
//------------------End of insert(int data)------------------------------------------------------------------------------
    
//-----------------Start of int peek()-----------------------------------------------------------------------------------
    public int peek(){
        if(!isEmpty()){
            return head.data; //it returns the top most value of Queue..
        }
            return 0;
    }
//--------------------End of int peek()----------------------------------------------------------------------------------

//---------------------Start of int remove()-----------------------------------------------------------------------------    
    public int remove(){
        int temp = 0;
        
        if(isEmpty()){
            System.out.print("\nList is empty!");
        }else{
            temp = head.data;
            head = head.next;
        }
        
        return temp; //it returns the removed data..
    }
//----------------------End of int remove()------------------------------------------------------------------------------
    
//---------------------Start of boolean isEmpty()------------------------------------------------------------------------    
    public boolean isEmpty(){
        return head==null; //ir check Queue is empty or not..
    }
//-----------------------End of boolean isEmpty()------------------------------------------------------------------------
    
//------------------------Start of makeQueueEmpty()----------------------------------------------------------------------
        public void makeQueueEmpty(){
            while(!isEmpty()){
                remove();
            }//end of while(!isEmpty())
        }
//------------------------End of makeQueueEmpty()---------------------------------------------------------------------- 
}
