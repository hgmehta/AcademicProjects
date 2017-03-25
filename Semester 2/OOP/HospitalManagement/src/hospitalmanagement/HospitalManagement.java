/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

import java.util.*;
//import javax.swing.*;
import java.io.*;
/**
 *
 * @author Harsh Mehta
 */
public class HospitalManagement implements Serializable
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
       Scanner input = new Scanner(System.in);
       DoctorDetails d1 = new DoctorDetails();
		d1.DoctorsId();
		d1.DoctorsName();
		d1.DoctorsAdderess();
		d1.DoctorsGender();
		d1.DoctorsSpeacilities();
		d1.DoctorsSalary();
		d1.getDoctorsDetailsFile();
		d1.Doctorattendance();
		d1.Nursename();
		d1.Wardboyname();
		d1.NurseId();
		d1.WardBoyId();
		d1.NurseAdderess();
		d1.WardBoyAdderess();
		d1.NurseGender();
		d1.wardBoyGender();
		d1.WardBoySalary();
		d1.NurseSalary();
		d1.getStaffDetailsFile();
		d1.Staffattendance();
		d1.DrawDoctorSalary();
                
		String Id,ID="",NAME,ADDRESS,SEX,MOBILENO = null,EMAIL_ID,DOCTOR = null,roomType = null,CHARGE = null;
		int choice,AGE = 0,DATE,MONTH,YEAR;
                double DocCharge,WardCharge,TotalBill,TestCharge;
                boolean check = true;
                Patient P;
                Ward ward = new Ward();
		int temp1;
		whilelabel:
		while(true)
		{
			System.out.println("\n1.New Patient.\n2.Existing Patient.\n3.Check Details of the Patient.\n4.Create Bill.\n5.Exit.");
			System.out.print("\nEnter your choice: ");
			choice = input.nextInt();
			switch(choice)
			{
				case 1:	
					System.out.print("Enter the name of the patient: ");
					NAME = input.nextLine();
					NAME = input.nextLine();	
					do
                                        {
                                            try
                                            {
                                                System.out.print("Enter the age of the patient: ");
                                                AGE = input.nextInt();
                                                if(AGE < 0 | AGE > 130)
                                                    throw new InvalidValueException();
                                                check = false;
                                            }
                                            catch(InvalidValueException e)
                                            {
                                                   System.out.print("\nERROR: " + e);
                                                   check = true;
                                            }
                                        }while(check);
					System.out.print("Enter the sex of the patient: ");
					SEX = input.nextLine();
					SEX = input.nextLine();
					
					System.out.print("Enter the Address of the patient: ");
					ADDRESS = input.nextLine();
					try
                                        {
					System.out.print("Enter the Mobile number of the patient.");
					MOBILENO = input.nextLine();
                                        if(MOBILENO.length()<10 | MOBILENO.length()>10)
                                            throw new InvalidMobileNumber();
                                        ID ="Pat" +  MOBILENO;
                                        }
                                        catch(InvalidMobileNumber e)
                                        {
                                            System.out.print("\nERROR: " + e);
                                        }
					//ID ="Pat" +  MOBILENO;
                                        	
					System.out.print("Enter the email id of the patient.");
					EMAIL_ID = input.nextLine();
					
					System.out.print("Enter the Date: ");
					DATE = input.nextInt();
					
					System.out.print("Enter the Month: ");
					MONTH = input.nextInt();
					
					System.out.print("Enter the Year: ");
					YEAR = input.nextInt();
					do
					{
						System.out.println("Select:\n1.Consult.\n2.Admit.");
						temp1 = input.nextInt();
                                                CHARGE = "Consult";
						if(temp1 == 1)
						{
							System.out.println("Which Doctor Do you want to consult:");
							System.out.println("\n1.Physician.");
							System.out.println("2.Gynaecologist.");
							System.out.println("3.Oncologist.");
							System.out.println("4.Radiologist.");
							System.out.println("5.Cardiologist.");
							System.out.println("6.Neurologist.");
							System.out.println("7.Surgeon.");
							System.out.println("8.Anaesthesiologist.");
							int doc = input.nextInt();
							switch(doc)
							{
								case 1:
								DOCTOR = "Physician";
								break;
								case 2:
								DOCTOR = "Gynaecologist";
								break;
								case 3:
								DOCTOR = "Oncologist";
								break;
								case 4:
								DOCTOR = "Radiologist";
								break;
								case 5:
								DOCTOR = "Cardiologist";
								break;
								case 6:
								DOCTOR = "Neurologist";
								break;
								case 7:
								DOCTOR = "Surgeon";
								break;
								case 8:
								DOCTOR = "Anaesthesiologist";
								break;
							}
						}
						else if(temp1 == 2)
						{
                                                        CHARGE = "Admit";
							System.out.println("\nWhich Doctor Do you want to consult:");
                                                        System.out.println("1.Physician.");
							System.out.println("2.Gynaecologist.");
							System.out.println("3.Oncologist.");
							System.out.println("4.Radiologist.");
							System.out.println("5.Cardiologist.");
							System.out.println("6.Neurologist.");
							System.out.println("7.Surgeon.");
							System.out.println("8.Anaesthesiologist.");
							int admit = input.nextInt();
                                                        int room;
							switch(admit)
							{
								case 1:
								DOCTOR = "Physician";
								// Physician --.
								break;
								case 2:
								DOCTOR = "Gynaecologist";
								break;
								case 3:
								DOCTOR = "Oncologist";
								break;
								case 4:
								DOCTOR = "Radiologist";
								break;
								case 5:
								DOCTOR = "Cardiologist";
								break;
								case 6:
								DOCTOR = "Neurologist";
								break;
								case 7:
								DOCTOR = "Surgeon";
								break;
								case 8:
								DOCTOR = "Anaesthesiologist";
								break;
							}
                                                        do{
                                                        System.out.print("\n1.General ward\n2.Private ward\n3.ICU ward\n4.ICCU ward");
                                                        System.out.println("In which ward you want to admit:");
                                                        room = input.nextInt();
                                                        switch(room)
                                                        {
                                                            case 1:
                                                                ward.general_ward.add(ID);
                                                                roomType = "General Ward.";
                                                                System.out.print("\nGeneral ward is allocated");
                                                                break;
                                                            case 2:
                                                                ward.Private_room.add(ID);
                                                                roomType = "Private Room.";
                                                                System.out.print("\nPrivate room is allocated");
                                                                break;
                                                            case 3:
                                                                ward.icu_room.add(ID);
                                                                roomType = "ICU Room.";
                                                                System.out.print("\nICU room is allocated");
                                                                break;
                                                            case 4:
                                                                ward.iccu_room.add(ID);
                                                                roomType = "ICCU Ward.";
                                                                System.out.print("\nICCU room is allocated");
                                                                break;
                                                            default:
                                                                System.out.println("Please Select a appropriate ward.");
                                                                break;
                                                        }
                                                        }
                                                        while(room <1 & room >4);
						}
						else
						{
							System.out.println("Please Enter a Valid Choice.");
						}
					}while(choice != 1 && choice != 2 && choice != 3 && choice != 4);
					P = new Patient(ID,NAME,EMAIL_ID,ADDRESS,SEX,AGE,DATE,MONTH,YEAR,MOBILENO,DOCTOR,roomType,CHARGE);
					System.out.println("Patient ID:" + ID);
					FileOutputStream fout = new FileOutputStream(ID + ".dat");
					ObjectOutputStream oout = new ObjectOutputStream(fout);
                                        oout.writeObject(P);        
					oout.flush();
					oout.close();
				break;
				case 2:
				System.out.println("Enter the Id of the Patient");
				Id = input.nextLine();
				Id = input.nextLine();
					
                                do
					{
						System.out.println("Select:\n1.Consult.\n2.Admit.");
						temp1 = input.nextInt();
						if(temp1 == 1)
						{
							System.out.println("Which Doctor Do you want to consult:");
							System.out.println("\n1.Physician.");
							System.out.println("2.Gynaecologist.");
							System.out.println("3.Oncologist.");
							System.out.println("4.Radiologist.");
							System.out.println("5.Cardiologist.");
							System.out.println("6.Neurologist.");
							System.out.println("7.Surgeon.");
							System.out.println("8.Anaesthesiologist.");
							int doc = input.nextInt();
							switch(doc)
							{
								case 1:
								DOCTOR = "Physician";
								break;
								case 2:
								DOCTOR = "Gynaecologist";
								break;
								case 3:
								DOCTOR = "Oncologist";
								break;
								case 4:
								DOCTOR = "Radiologist";
								break;
								case 5:
								DOCTOR = "Cardiologist";
								break;
								case 6:
								DOCTOR = "Neurologist";
								break;
								case 7:
								DOCTOR = "Surgeon";
								break;
								case 8:
								DOCTOR = "Anaesthesiologist";
								break;
							}
						}
						else if(temp1 == 2)
						{
							System.out.println("\nWhich Doctor Do you want to consult:");
                                                        System.out.println("1.Physician.");
							System.out.println("2.Gynaecologist.");
							System.out.println("3.Oncologist.");
							System.out.println("4.Radiologist.");
							System.out.println("5.Cardiologist.");
							System.out.println("6.Neurologist.");
							System.out.println("7.Surgeon.");
							System.out.println("8.Anaesthesiologist.");
							int admit = input.nextInt();
                                                        int room;
							switch(admit)
							{
								case 1:
								DOCTOR = "Physician";
								// Physician --.
								break;
								case 2:
								DOCTOR = "Gynaecologist";
								break;
								case 3:
								DOCTOR = "Oncologist";
								break;
								case 4:
								DOCTOR = "Radiologist";
								break;
								case 5:
								DOCTOR = "Cardiologist";
								break;
								case 6:
								DOCTOR = "Neurologist";
								break;
								case 7:
								DOCTOR = "Surgeon";
								break;
								case 8:
								DOCTOR = "Anaesthesiologist";
								break;
							}
                                                        do{
                                                        System.out.print("\n1.General ward\n2.Private ward\n3.ICU ward\n4.ICCU ward");
                                                        System.out.println("In which ward you want to admit:");
                                                        room = input.nextInt();
                                                        switch(room)
                                                        {
                                                            case 1:
                                                                ward.general_ward.add(ID);
                                                                roomType = "General Ward";
                                                                System.out.print("\nGeneral ward is allocated");
                                                                break;
                                                            case 2:
                                                                ward.Private_room.add(ID);
                                                                roomType = "Private Room";
                                                                System.out.print("\nPrivate room is allocated");
                                                                break;
                                                            case 3:
                                                                ward.icu_room.add(ID);
                                                                roomType = "ICU Room";
                                                                System.out.print("\nICU room is allocated");
                                                                break;
                                                            case 4:
                                                                ward.iccu_room.add(ID);
                                                                roomType = "ICCU Ward";
                                                                System.out.print("\nICCU room is allocated");
                                                                break;
                                                            default:
                                                                System.out.println("Please Select a appropriate ward.");
                                                                break;
                                                        }
                                                        }
                                                        while(room <1 & room >4);
						}
						else
						{
							System.out.println("Please Enter a Valid Choice.");
						}
					}while(choice != 1 && choice != 2 && choice != 3 && choice != 4);
				break;
				case 3:
					System.out.print("Enter the ID of the Patient.");
					Id = input.nextLine();
					Id = input.nextLine();
					Id = Id + ".dat";
					File f = new File(Id);
					if(f.exists())
					{
						FileInputStream fin = new FileInputStream(Id);
						ObjectInputStream in = new ObjectInputStream(fin);
						Patient p1;
						p1 = (Patient)in.readObject();
						p1.display();
						in.close();
					}
					else
					{
						System.out.println("The patient Id is not registered.");
						continue whilelabel;
					}
					//linkedlist1.printList();
					break;
                                case 4:
                                    System.out.print("Enter the ID of the Patient.");
					Id = input.nextLine();
					Id = input.nextLine();
					Id = Id + ".dat";
					File f1 = new File(Id);
					if(f1.exists())
					{
						FileInputStream fin = new FileInputStream(Id);
						ObjectInputStream in = new ObjectInputStream(fin);
						Patient p1;
						p1 = (Patient)in.readObject();
                                                if(p1.get_charge().equals("Consult"))
                                                {
                                                    DocCharge = p1.b1.getAppointmentCharges();
                                                    do{
                                                    System.out.println("Did the patient had any test?");
                                                    System.out.println("1.Yes.\n2.No.");
                                                    int choice1 = input.nextInt();
                                                    if(choice == 1)
                                                    {
                                                         TestCharge = p1.b1.getTestCharges();
                                                    }
                                                    else if(choice == 2)
                                                    {
                                                        TestCharge = 0;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Please Select a Correct Choice.");
                                                    }
                                                    }while(choice != 1 & choice !=2);
                                                    }
						in.close();
					}
					else
					{
						System.out.println("The patient Id is not registered.");
						continue whilelabel;
					}
					//linkedlist1.printList();
					break;
                                    
				case 5:
					System.exit(0);
					break;
                                        default:
					System.out.println("Please enter a valid choice.");
			}//end of switch case..
		}
        }//end of main..
    }//end of public class Hospital Management..