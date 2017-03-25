/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

/**
 *
 * @author Harsh Mehta
 */
import java.util.*;
import java.io.*;
class Ward implements Serializable
{
                long generalWardCharge,icuWardCharge,privateWardCharge,iccuWardCharge;
		ArrayList general_ward = new ArrayList();
		//ArrayList generalward = new ArrayList();
		ArrayList Private_room = new ArrayList();
		//ArrayList Privateroom = new ArrayList();
		ArrayList icu_room = new ArrayList();
		//ArrayList icuroom = new ArrayList();
		ArrayList iccu_room = new ArrayList();
		//ArrayList iccuroom = new ArrayList();
                
                Ward()
                {
                    generalWardCharge = 1500;
                    privateWardCharge = 2500;
                    icuWardCharge = 4000;
                    iccuWardCharge = 5000;
                }
                
               public void setGeneralWardCharge(long charge)
               {
                   generalWardCharge = charge;
               }
               
               public void setPrivateWardCharge(long charge)
               {
                   privateWardCharge = charge;
               }
               
               public void setIcuWardCharge(long charge)
               {
                   icuWardCharge = charge;
               }
               
               public void setIccuWardCharge(long charge)
               {
                   iccuWardCharge = charge;
               }
               
               public long getGenaralWardCharge()
               {
                   return generalWardCharge;
               }
               
               public long getPrivateWardCharge()
               {
                   return privateWardCharge;
               }
               
               public long getIcuWardCharge()
               {
                   return icuWardCharge;
               }
               
               public long getIccuWardCharge()
               {
                   return iccuWardCharge;
               }
}