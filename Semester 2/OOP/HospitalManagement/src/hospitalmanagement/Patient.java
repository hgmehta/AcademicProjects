package hospitalmanagement;

import java.util.*;
import java.io.*;
/**
 *
 * @author Harsh Mehta
 */
class Patient implements Serializable
{
        Ward ward = new Ward();
        Bill b1 = new Bill();
        public String id,name,address,sex,mobileno,email_id,Doct,room,Charge;
	public int age,date,month,year;
	public Patient(String Id,String Name,String Email_id,String Address,String Sex,int Age,int Date,int Month,int Year,String Mobileno,String Doctor,String Room,String charge)
	{
			id = Id;
			name = Name;
			address = Address;
			sex = Sex;
			age = Age;
			date = Date;
			month = Month;
			year = Year;
			email_id = Email_id;
			Doct = Doctor;
                        room = Room;
                        Charge = charge;
	}
	public void display()
	{
		System.out.print("\nPatient id is " + id);
		System.out.print("\nName: "+ name);
		System.out.print("\nAddress: "+ address);
		System.out.print("\nSex: "+ sex);
		System.out.print("\nAge: " + age);
		System.out.print("\nEmail id: " + email_id);
		System.out.print("\nDate: " + date + "/" + month + "/" + year);
		System.out.print("Doctor: " + Doct);
		System.out.print("Room: " + room);
        }
        public String get_doctor()
        {
            return Doct;
        }
        public String get_charge()
        {
            return Charge;
        }
        public void get_pos()
        {
           Scanner input = new Scanner(System.in);
           int choice;
           do
           {
           System.out.println("1.General Ward.\n2.Private Room.\n3.ICU Room.\n4.ICCU Room.");
           choice = input.nextInt();
           switch(choice)
             { 
                 case 1:
                     if(ward.general_ward.size() != 0)
                        {
                           for(int i=0;i<ward.general_ward.size();i++)
                                System.out.println(ward.general_ward.get(i));
                        }
                       else
                        {
                            System.out.println("There are no patients in the general ward.");
                        }
                    break;
                   case 2:
                       if(ward.Private_room.size() != 0)
                        {
                           for(int i=0;i<ward.Private_room.size();i++)
                                System.out.println(ward.Private_room.get(i));
                        }
                       else
                        {
                            System.out.println("There are no patients in any Private Room.");
                        }
                       break;
                   case 3:
                    if(ward.icu_room.size() != 0)
                        {
                           for(int i=0;i<ward.icu_room.size();i++)
                                System.out.println(ward.icu_room.get(i));
                        }
                       else
                        {
                            System.out.println("There are no patients in any ICU. ");
                        }
                       break;
                   case 4:
                        if(ward.iccu_room.size() != 0)
                        {
                           for(int i=0;i<ward.iccu_room.size();i++)
                                System.out.println(ward.iccu_room.get(i));
                        }
                       else
                        {
                            System.out.println("There are no patients in any ICCU. ");
                        }
                      break;
                  default:
                      System.out.println("Please Select a Proper Room.");
                      break;
             }     
           }while((choice <1) && (choice >4));
        }
        
        public void makeBill()
        {
                if(room == "General Ward")
                {
                    b1.finalBill(b1.getGeneralWardCharges());
                }
                else if(room == "Private Room")
                {
                    b1.finalBill(b1.getPrivateWardCharges());
                }
                else if(room == "ICU Room")
                {
                    b1.finalBill(b1.getICUWardCharges());
                }
                else if(room == "ICCU Ward")
                {
                    b1.finalBill(b1.getICCUWardCharges());
                }
                else
                {
                    b1.finalBill(0);
                }
                
                if(room == null)
                {
                    b1.finalBill(b1.getAppointmentCharges());
                }
                
                System.out.print("\nFinal bill for " + id + " is: " + b1.getfinalbill());
        }
}
