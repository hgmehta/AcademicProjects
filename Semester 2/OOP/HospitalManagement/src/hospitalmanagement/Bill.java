/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;
import java.io.*;
import java.util.*;

/**
 *
 * @author Harsh Mehta
 */
interface SetersAndGeters extends Serializable
{
    public void setAppointmentCharges();
    public void setOperationCharges();
    public void setTestCharges(); 
    public void setGeneralWardCharges ();
    public void setPrivateWardCharges();
    public void setICUWardCharges();
    public void setICCUWardCharges();
    public double getAppointmentCharges();
    public double getOperationCharges();
    public double getTestCharges();
    public double getGeneralWardCharges();
    public double getPrivateWardCharges();
    public double getICUWardCharges();
    public double getICCUWardCharges();
}

class Bill implements Serializable,SetersAndGeters
{
    transient Scanner scan = new Scanner(System.in);
    private double appointmenCharge;
    private double operationCharge;
    private double testCharge;
    private double generalWardCharge;
    private double privateWardCharge;
    private double icuWardCharge;
    private double iccuWardCharge;
    private double finalbill = 0;
    
    Bill()
    {
        appointmenCharge = 500;
        testCharge = 700;
        generalWardCharge = 1000;
        privateWardCharge = 1500;
        icuWardCharge = 25000;
        iccuWardCharge = 30000;
        
    }
    
    public void setAppointmentCharges()
    {
        System.out.print("\nEnter new Appointment Charge: ");
        appointmenCharge = scan.nextDouble();
    }
    
    public void setOperationCharges()
    {
        System.out.print("\nEnter new operation Charge: ");
        operationCharge = scan.nextDouble();
    }
    
    public void setTestCharges()
    {
        System.out.print("\nEnter new test Charge: ");
        testCharge = scan.nextDouble();
    }
    
    public void setGeneralWardCharges ()
    {
        System.out.print("\nEnter new Charge for general ward: ");
        generalWardCharge = scan.nextDouble();
    }
    
    public void setPrivateWardCharges ()
    {
        System.out.print("\nEnter new Charge for private ward: ");
        privateWardCharge = scan.nextDouble();
    }
    
    public void setICUWardCharges ()
    {
        System.out.print("\nEnter new Charge for ICU ward: ");
        icuWardCharge = scan.nextDouble();
    }
    
    public void setICCUWardCharges ()
    {
        System.out.print("\nEnter new Charge for ICCU ward: ");
        iccuWardCharge = scan.nextDouble();
    }
    
    public double getGeneralWardCharges()
    {
        return generalWardCharge;
    }
    
    public double getPrivateWardCharges ()
    {
        return privateWardCharge;
    }
    
    public double getICUWardCharges ()
    {
        return icuWardCharge;
    }
    
    public double getICCUWardCharges ()
    {
       return iccuWardCharge;
    }
    
    public double getAppointmentCharges()
    {
        return appointmenCharge;
    }
    
    public double getOperationCharges()
    {
        return operationCharge;
    }
    
    public double getTestCharges()
    {
        return testCharge;
    } 
    
    public void finalBill(double charge)
    {
        finalbill = finalbill + charge;
    }
    
    public double getfinalbill()
    {
        return finalbill;
    }
    
}
