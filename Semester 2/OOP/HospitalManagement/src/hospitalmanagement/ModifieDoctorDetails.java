/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;
import java.util.*;
import java.io.*;
/**
 *
 * @author Harsh Mehta
 */
public class ModifieDoctorDetails  extends DoctorDetails implements Serializable
{
    int choice;
    Scanner input = new Scanner(System.in);
    public void addDoctor()
    {
        System.out.print("\nEnter name of the doctor: ");
        String Name = input.nextLine();
        name.add(Name);
        System.out.print("\nEnter gender of the doctor: ");
        String Gender = input.nextLine();
        gender.add(Gender);
        System.out.print("\nEnter address of the doctor: ");
        String Address = input.nextLine();
        address.add(Address);
        System.out.print("\nEnter speacility of the doctor: ");
        String Speacility = input.nextLine();
        speciality.add(Speacility);
        System.out.println("Enter the salary of"+ Speacility +"the the Doctor ");
        double Salary = input.nextDouble();
        salary.add(Salary);
    }
    
    public void addStaffDetails()
    {
        do
        {
                System.out.print("\nWhich staff do you want do add: ");
                System.out.print("\n1.Nurse\n2.Wardboy\nEnter your choice: ");
                choice = input.nextInt();
                switch(choice)
                {
                    case 1:
                            System.out.print("\nEnter name of the nurse: ");
                            String Name = input.nextLine();
                            Nursename.add(Name);
                            Nursegender.add("Female");
                            System.out.print("\nEnter address of the nurse: ");
                            String Address = input.nextLine();
                            Nurseaddress.add(Address);
                            Nursesalary.add(500);
                            break;
                    case 2:
                            System.out.print("\nEnter name of the wardboy: ");
                            Name = input.nextLine();
                            Wardboyname.add(Name);
                            WardboyGender.add("Male");
                            System.out.print("\nEnter address of the nurse: ");
                            Address = input.nextLine();
                            Wardboyaddress.add(Address);
                            Wardboysalary.add(300);
                            break;
                    default:
                            System.out.print("\nPlease select correct choice");
                            break;
                }
        }while(choice !=1 & choice !=2);
    }
    
    public void deleteDoctor()
    {
        int temproryIndex = -1;
        System.out.print("\nEnter Id of the doctor: ");
        String Id = input.nextLine();
        for(int i = 0;i < id.size();i++)
        {
            if(Id.equals(id.get(i)))
            {
                temproryIndex = i;
            }
            else
            {
                temproryIndex = -1;
            }
        }
        if(temproryIndex == -1)
        {
            System.out.print("\nNo id found");
        }
        else
        {
            name.remove(temproryIndex);
            address.remove(temproryIndex);
            speciality.remove(temproryIndex);
            gender.remove(temproryIndex);
            salary.remove(temproryIndex);
            id.remove(temproryIndex);
        }
    }
    
    public void deleteStaff()
    {
        do
        {
        System.out.print("\nWhich staff do you want to remove: ");
        System.out.print("\n1.Nurse\n2.Wardboy");
        choice = input.nextInt();
        int temproryIndex = -1;
        if(choice == 1)
        {
            System.out.print("\nEnter Id of the nurse: ");
            String Id = input.nextLine();
            for(int i = 0;i < Nurseid.size();i++)
            {
                if(Id.equals(Nurseid.get(i)))
                {
                    temproryIndex = i;
                }
                else
                {
                    temproryIndex = -1;
                }
            }
            if(temproryIndex == -1)
            {
                System.out.print("\nNo id found");
            }
            else
            {
                Nursename.remove(temproryIndex);
                Nurseaddress.remove(temproryIndex);
                Nursegender.remove(temproryIndex);
                Nursesalary.remove(temproryIndex);
                Nurseid.remove(temproryIndex);
            }
        }
        else if(choice == 2)
        {
            System.out.print("\nEnter Id of the wardboy: ");
            String Id = input.nextLine();
            for(int i = 0;i < Wardboyid.size();i++)
            {
                if(Id.equals(Wardboyid.get(i)))
                {
                    temproryIndex = i;
                }
                else
                {
                    temproryIndex = -1;
                }
            }
            if(temproryIndex == -1)
            {
                System.out.print("\nNo id found");
            }
            else
            {
                Wardboyname.remove(temproryIndex);
                Wardboyaddress.remove(temproryIndex);
                WardboyGender.remove(temproryIndex);
                Wardboysalary.remove(temproryIndex);
                Wardboyid.remove(temproryIndex);
            }
        }
        else
        {
            System.out.print("\nPlease select correct choice");
        }
        }while(choice != 1 & choice !=2);
    }
}
