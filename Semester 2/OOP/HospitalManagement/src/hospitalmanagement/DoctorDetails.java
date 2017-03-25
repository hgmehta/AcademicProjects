/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;
import java.util.*;
import java.io.*;
import java.util.ArrayList.*;
/**
 *
 * @author Harsh Mehta
 */
public class DoctorDetails implements Serializable
{
        ArrayList id = new ArrayList();
	ArrayList name = new ArrayList();
	ArrayList address = new ArrayList();
	ArrayList gender = new ArrayList();
	ArrayList attendance  = new ArrayList();
	ArrayList speciality = new ArrayList();
	ArrayList Doctorsalary = new ArrayList();
	ArrayList DdrawSalary = new ArrayList();
	ArrayList salary = new ArrayList();
	
	int Dsalary = 0;
	int Wsalary = 0;
	int Nsalary = 0;
	
	ArrayList Nursename = new ArrayList();
	ArrayList NdrawSalary = new ArrayList();
	ArrayList Nursegender = new ArrayList();
	ArrayList Nurseaddress = new ArrayList();
	ArrayList Nursesalary = new ArrayList();
	ArrayList Nurseattendance  = new ArrayList();
	ArrayList Nurseid = new ArrayList();
	
	ArrayList Wardboyname = new ArrayList();
	ArrayList WdrawSalary = new ArrayList();
	ArrayList Wardboyattendance  = new ArrayList();
	ArrayList WardboyGender = new ArrayList();
	ArrayList Wardboysalary = new ArrayList();
	ArrayList Wardboyid = new ArrayList();
	ArrayList Wardboyaddress = new ArrayList();
	public void DoctorsId()
	{
		for(int k=100; k<130; k++)
		{
			int j = k;
			int i = k - 100 ;
			id.add("DOC" + (++j ));
		}
	}
	
	public void NurseId()
	{
		for(int k=100; k<130; k++)
		{
			int j = k;
			int i = k - 100 ;
			Nurseid.add("NR" + (++j ));
		}
	}
	
	public void WardBoyId()
	{
		for(int k=100; k<110; k++)
		{
			int j = k;
			int i = k - 100 ;
			Wardboyid.add("WB" + (++j ));
		}
	}
	
	public void DoctorsName()
	{
		name.add("Deepak shah");
		name.add("Harsh mehta");
		name.add("Abhishek chaudhary");
		name.add("Pratik bagul");
		name.add("Mihir gajjar");
		name.add("Shreyas patel");
		name.add("Maunil shah");
		name.add("Prachi patel");
		name.add("Mansi shah");
		name.add("Raj talati");
		name.add("Shailee shah");
		name.add("Bilal sheikh");
		name.add("Riya mehta");
		name.add("Maunil vyas");
		name.add("Ashutosh sharma");
		name.add("Kishan raval");
		name.add("Mukesh bhatt");
		name.add("Prakash verma");
		name.add("Aryan shah");
		name.add("Chaitanya patel");
		name.add("Shailesh patel");
		name.add("Nachiket Sharma");
		name.add("Ragini patel");
		name.add("Alay joshi");
		name.add("Ujjwal sareen");
		name.add("Ashok samrat");
		name.add("Justin singhania");
		name.add("Nitin shah");
		name.add("Akshara doshi");
		name.add("Pooja mehta");	
	}
	
	public void Nursename()
	{
		for(int k=0; k<30; k++)
		{
			Nursename.add("Nurse" + k);
		}
	}
	
	public void Wardboyname()
	{
		for(int k=0; k<10; k++)
		{
			Wardboyname.add("WardBoy" + k);
		}
	}
	
	public void NurseAdderess()
	{
		Nurseaddress.add("Naranpura");
		Nurseaddress.add("Navrangpura");
		Nurseaddress.add("Shahpur");
		Nurseaddress.add("Maninagar");
		Nurseaddress.add("Mirzapur");
		Nurseaddress.add("Khadia");
		Nurseaddress.add("Science city");
		Nurseaddress.add("Bopal");
		Nurseaddress.add("Pragatinagar");
		Nurseaddress.add("Shastrinagar");
		Nurseaddress.add("Satellite");
		Nurseaddress.add("CG road");
		Nurseaddress.add("SG highway");
		Nurseaddress.add("Kalupur");
		Nurseaddress.add("Ranip");
		Nurseaddress.add("Vastrapur");
		Nurseaddress.add("Judges bungalow");
		Nurseaddress.add("Shahibaug");
		Nurseaddress.add("Hatkeshwar");
		Nurseaddress.add("RTO");
		Nurseaddress.add("Chandranagar");
		Nurseaddress.add("Paldi");
		Nurseaddress.add("Anjali");
		Nurseaddress.add("Nehrunagar");
		Nurseaddress.add("Naroda");
		Nurseaddress.add("Naranpura");
		Nurseaddress.add("Navrangpura");
		Nurseaddress.add("Satellite");
		Nurseaddress.add("Vastrapur");
		Nurseaddress.add("Satellite");
	}
	
	public void WardBoyAdderess()
	{
		Wardboyaddress.add("Naranpura");
		Wardboyaddress.add("Navrangpura");
		Wardboyaddress.add("Shahpur");
		Wardboyaddress.add("Maninagar");
		Wardboyaddress.add("Mirzapur");
		Wardboyaddress.add("Khadia");
		Wardboyaddress.add("Science city");
		Wardboyaddress.add("Bopal");
		Wardboyaddress.add("Pragatinagar");
		Wardboyaddress.add("Shastrinagar");
	}
	
	public void DoctorsAdderess()
	{
		address.add("Naranpura");
		address.add("Navrangpura");
		address.add("Shahpur");
		address.add("Maninagar");
		address.add("Mirzapur");
		address.add("Khadia");
		address.add("Science city");
		address.add("Bopal");
		address.add("Pragatinagar");
		address.add("Shastrinagar");
		address.add("Satellite");
		address.add("CG road");
		address.add("SG highway");
		address.add("Kalupur");
		address.add("Ranip");
		address.add("Vastrapur");
		address.add("Judges bungalow");
		address.add("Shahibaug");
		address.add("Hatkeshwar");
		address.add("RTO");
		address.add("Chandranagar");
		address.add("Paldi");
		address.add("Anjali");
		address.add("Nehrunagar");
		address.add("Naroda");
		address.add("Naranpura");
		address.add("Navrangpura");
		address.add("Satellite");
		address.add("Vastrapur");
		address.add("Satellite");
	}
	
	public void DoctorsGender()
	{	
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Female");
		gender.add("Female");
		gender.add("Male");
		gender.add("Female");
		gender.add("Male");
		gender.add("Female");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Female");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Male");
		gender.add("Female");
	}
	
	public void NurseGender()
	{	for(int k=0; k<Nursename.size(); k++)
		{
			Nursegender.add("Female");
		}
	}
	
	public void wardBoyGender()
	{	for(int k=0; k<Wardboyname.size(); k++)
		{
			WardboyGender.add("Male");
		}
	}
	
	public void DoctorsSpeacilities()
	{	
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Physician");
		speciality.add("Oncologist");
		speciality.add("Oncologist");
		speciality.add("Radiologist");
		speciality.add("Radiologist");
		speciality.add("Cardiologist");
		speciality.add("Cardiologist");
		speciality.add("Cardiologist");
		speciality.add("Neurologist");
		speciality.add("Neurologist");
		speciality.add("Surgeon");
		speciality.add("Surgeon");
		speciality.add("Surgeon");
		speciality.add("Anesthesiologist");
		speciality.add("Anesthesiologist");
		speciality.add("Anesthesiologist");
		speciality.add("Gynaecologist");
		speciality.add("Gynaecologist");
		speciality.add("Gynaecologist");
		speciality.add("Gynaecologist");
		speciality.add("Gynaecologist");
		speciality.add("Gynaecologist");
	}
	
	public void DoctorsSalary()
	{	
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(2000);
		salary.add(5000);
		salary.add(5000);
		salary.add(3000);
		salary.add(3000);
		salary.add(5000);
		salary.add(5000);
		salary.add(5000);
		salary.add(7000);
		salary.add(7000);
		salary.add(4000);
		salary.add(4000);
		salary.add(4000);
		salary.add(4000);
		salary.add(4000);
		salary.add(4000);
		salary.add(3000);
		salary.add(3000);
		salary.add(3000);
		salary.add(3000);
		salary.add(3000);
		salary.add(3000);
	}
	
	public void WardBoySalary()
	{	
		for(int k=0; k<Wardboyname.size(); k++)
		{
			Wardboysalary.add(300);
		}
	}
	
	public void NurseSalary()
	{	
		for(int k=0; k<Nursename.size(); k++)
		{
			Nursesalary.add(500);
		}
	}
	
	public void getDoctorsDetailsFile()
	{
	try
	{
		File doctordetails = new File("Doctor_Details.xls");
		FileWriter output = new FileWriter(doctordetails, false );
		
		output.write("Name"+"\t"+"Id"+"\t"+"Address"+"\t"+"Gender"+"\t"+"Speciality"+"\t"+"Salary Per Day"+"\n");
	
		for(int i=0; i<name.size(); i++)
		{
			output.write("\n" + name.get(i) + "\t" + id.get(i) + "\t" + address.get(i) + "\t" + gender.get(i) + "\t" + speciality.get(i) + "\t"+ salary.get(i));
		}
		output.close();
	}
	catch(Exception e)
	{System.out.print("ERROR getDoctorsDetailsFile: " + e);}
	}
	
	public void getStaffDetailsFile()
	{
		try
		{
			File Staffdetails = new File("StaffDetails.xls");
			PrintWriter out = new PrintWriter(Staffdetails);
			
			out.print("Name"+"\t"+"Id"+"\t"+"Address"+"\t"+"Gender"+"\t"+"Salary Per Day"+"\n");
		for(int i=0;i<Nursename.size();i++)
			{
				out.print("\n" + Nursename.get(i) + "\t" + Nurseid.get(i) + "\t" + Nurseaddress.get(i) + "\t" + Nursegender.get(i) + "\t"+ Nursesalary.get(i));
			}
			out.flush();
			for(int i=0; i<Wardboyname.size(); i++)
			{
				out.write("\n" + Wardboyname.get(i) + "\t" + Wardboyid.get(i) + "\t" + Wardboyaddress.get(i) + "\t" + WardboyGender.get(i) + "\t"+ Wardboysalary.get(i));
			}
			out.close();
		}
		catch(Exception e)
		{
			System.out.print("ERROR in getStaffDetailsFile: " + e);
		}
	}
	
	public void Doctorattendance()
	{
		try
		{
			File Attendance = new File("DoctorAttendance.xls");
			FileWriter output = new FileWriter(Attendance, true );
			
			Date d = new Date();
			char temp;
			Scanner input = new Scanner(System.in);
			
			for(int i=0; i<name.size(); i++)
			{
				System.out.print("\nEnter presence of " + name.get(i) + ": ");
				temp = input.next().charAt(0);
				
				if(temp == 'p' || temp == 'p')
				attendance.add('P');
				else
				attendance.add('A');
			}
			output.write("\n\n");
			output.write("Name"+"\t"+"Id"+"\t"+d);
			for(int i=0; i<name.size(); i++)
			{
			output.write("\n" + name.get(i) + "\t" + id.get(i) + "\t" +attendance.get(i));
			}
		output.close();
		}
		catch(Exception e)
		{System.out.print("ERROR in  attendance: " + e);}
	}
	
	public void Staffattendance()
	{
		try
		{
			File Attendance = new File("StaffAttendance.xls");
			FileWriter output = new FileWriter(Attendance, true );
			
			Date d = new Date();
			char temp;
			Scanner input = new Scanner(System.in);
			
			for(int i=0; i<Nursename.size(); i++)
			{
				System.out.print("\nEnter presence of " + Nursename.get(i) + ": ");
				temp = input.next().charAt(0);
				
				if(temp == 'p' || temp == 'p')
				{
					Nurseattendance.add('P');
				}
				else
				{	
					Nurseattendance.add('A');
				}
			}
			output.write("\n\n");
			
			for(int i=0; i<Wardboyname.size(); i++)
			{
				System.out.print("\nEnter presence of " + Wardboyname.get(i) + ": ");
				temp = input.next().charAt(0);
				
				if(temp == 'p' || temp == 'p')
				Wardboyattendance.add('P');
				else
				Wardboyattendance.add('A');
			}
			output.write("Name"+"\t"+"Id"+"\t"+d);
			for(int i=0; i<Nursename.size(); i++)
			{
				output.write("\n" + Nursename.get(i) + "\t" + Nurseid.get(i) + "\t" +Nurseattendance.get(i));
			}
			//output.write("Name"+"\t"+"Id"+"\t"+d);
			for(int i=0; i<Wardboyattendance.size(); i++)
			{
				output.write("\n" + Wardboyname.get(i) + "\t" + Wardboyid.get(i) + "\t" +Wardboyattendance.get(i));
			}
			
		output.close();
		}
		catch(Exception e)
		{System.out.print("ERROR in  attendance: " + e);}
	}
	
	public void DrawDoctorSalary()
	{
		for(int i=0;i<attendance.size();i++)
		{
			if((char)attendance.get(i) == 'P')
			{
				Dsalary = Dsalary + (int)salary.get(i);
				DdrawSalary.add(Dsalary);
				Dsalary = 0;
			}
			else
			{
				DdrawSalary.add(Dsalary);
			}
		}
		
		try
		{
			File SALARY = new File("DoctorSalary.xls");
			FileWriter output = new FileWriter(SALARY, true );
			
			for(int i=0; i<name.size(); i++)
			{
				output.write("\n" + name.get(i) + "\t" + DdrawSalary.get(i));
			}
		output.close();
		}
		catch(Exception e)
		{System.out.print("ERROR in  attendance: " + e);}
		
		for(int i=0;i<30;i++)
		{
			if((char)Nurseattendance.get(i) == 'P')
			{
				Nsalary = Nsalary + (int)Nursesalary.get(i);
				NdrawSalary.add(Nsalary);
				Nsalary = 0;
			}
			else
			{
				NdrawSalary.add(Nsalary);
			}
		}
		
		try
		{
			File SALARY = new File("NurseSalary.xls");
			FileWriter output = new FileWriter(SALARY, true );
			
			for(int i=0; i<Nursename.size(); i++)
			{
				output.write("\n" + name.get(i) + "\t" + NdrawSalary.get(i));
			}
			for(int i=0; i<Wardboyname.size(); i++)
			{
				output.write("\n" + name.get(i) + "\t" + NdrawSalary.get(i));
			}
			output.close();
		}
		catch(Exception e)
		{System.out.print("ERROR in  attendance: " + e);}
		
		for(int i=0;i<Wardboyattendance.size();i++)
		{
			if((char)Wardboyattendance.get(i) == 'P')
			{
				Wsalary = Wsalary + (int)Wardboysalary.get(i);
				WdrawSalary.add(Wsalary);
				Wsalary = 0;
			}
			else
			{
				WdrawSalary.add(Wsalary);
			}
		}
		
		for(int i=0;i<name.size();i++)
		{
			System.out.print("\nSalary of " + name.get(i) + "= " + DdrawSalary.get(i));
		}
		for(int i=0;i<Nursename.size();i++)
		{
			System.out.print("\nSalary of " + Nursename.get(i) + "= " + NdrawSalary.get(i));
		}
		for(int i=0;i<Wardboyname.size();i++)
		{
			System.out.print("\nSalary of " + Wardboyname.get(i) + "= " + WdrawSalary.get(i));
		}
	}
}
