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
public class Stack {

//----------Initialization-----------------------------------------------------------------------------------------------    
        private Node head,last;
//----------End of initialization----------------------------------------------------------------------------------------        


//-----------Start of counstuctor----------------------------------------------------------------------------------------        
	public Stack(){
		head = null;
		last = null;
	}//end of Constructor.
//-----------End of counstructor-----------------------------------------------------------------------------------------


//-----------------Start of int peek()-----------------------------------------------------------------------------------	
	public int peek(){
            if(!isEmpty()){
                return head.data;
            }
		return 0;
	}
//--------------------End of int peek()----------------------------------------------------------------------------------

        
//---------------------Start of int push(int data)-----------------------------------------------------------------------    	
	public void push(int data){
            Node newLink = new Node(data);
            if(head == null){
                    head = newLink;
                    last = head;
            }else{
                    newLink.next = head;
                    head = newLink;
            }
	}//end of insertAtFirst
//----------------------End of int push(int data)-----------------------------------------------------------------------    


//---------------------Start of boolean isEmpty()------------------------------------------------------------------------    	
	public boolean isEmpty(){
		return (head == null);
	}
//-----------------------End of boolean isEmpty()------------------------------------------------------------------------

        
//-----------------------Start of int pop()--------------------------------------------------------------------------------
	public int pop(){
		if(isEmpty()){
			System.out.print("\nList is empty!");
		}//end of if..
		int temp = head.data;
		head = head.next;
		return temp;
	}//end of pop..
//-----------------------End of int pop()--------------------------------------------------------------------------------

//------------------------Start of makeStackEmpty()----------------------------------------------------------------------
        public void makeStackEmpty(){
            while(!isEmpty()){
                pop();
            }//end of while(!isEmpty())
        }
//------------------------End of makeStackEmpty()----------------------------------------------------------------------        
        
        
}//end of class..
