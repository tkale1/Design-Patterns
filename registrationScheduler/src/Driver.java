/*
*	Author : Tanmay Kale
*	Subject : CS542_01 Design Patterns
*	Assignment 1 : A simple Java program and develop a program, using Java, to assign courses to students based on their preferences.
*/

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
    	
    	//Validating runtime arguments
    	int count = args.length;
    	String input_file = null;
    	String output_file = null;

    	if(count < 1 || count >2)
    	{
    		System.out.println("Exiting Program. \nIncorrect number of arguments.");
    		System.exit(0);
    	}
    
   		input_file = args[0];
   		output_file = args[1];

   		Scanner s = null;
    	File filename = new File(input_file);
    	int i=0;
		
    	List<String> studID = new ArrayList<String>();
		List<Integer> pref1 = new ArrayList<Integer>();
		List<Integer> pref2 = new ArrayList<Integer>();
		List<Integer> pref3 = new ArrayList<Integer>();
		List<Integer> pref4 = new ArrayList<Integer>();
        
		try {
           
            s = new Scanner(filename);
            System.out.println(filename+" file successfully opened for reading");
            while (s.hasNext())
    		{
    			studID.add(s.next()); // read and adding 'studentID'
    			pref1.add(s.nextInt()); // read and adding 'pref1'
    			pref2.add(s.nextInt()); // read and adding 'pref2'
    			pref3.add(s.nextInt()); // read and adding 'pref3'
    			pref4.add(s.nextInt()); // read and adding 'pref4'
    		}

            for (String name: studID)
    		{
    			System.out.println("Details of student "+(i+1));
    			System.out.println(name +" "+ pref1.get(i)+" "+ pref2.get(i)+" "+ pref3.get(i)+" "+ pref4.get(i));
    			i++;
    		}
            s.close();

        } catch (FileNotFoundException ex) {
        	System.err.println(filename +" File Not Found");
            ex.printStackTrace();
            System.exit(-1);
        }
		
		List<String> assignedID = new ArrayList<String>();
		List<String> assign1 = new ArrayList<String>();
		List<String> assign2 = new ArrayList<String>();
		List<String> assign3 = new ArrayList<String>();
		
		int[] total_pref = new int[12];
		float final_pref=0;
		int slota=0,slotb=0,slotc=0,slotd=0;
		
		for(i=0;i<12 ;i++)
		{
			total_pref[i]=0;
		}
		//Assigning first course
		for(i=0;i<12 ;i++)
		{
			if(pref1.get(i)==1)
			{
				if(slota<10)
				{
					assignedID.add("Student_"+(i+1));
					assign1.add("A");
					slota++;
					total_pref[i]=total_pref[i]+1;
				}
				else
				{
					if(pref2.get(i)==2 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref3.get(i)==2 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref4.get(i)==2 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+2;
					}
				}
			}
			else if(pref2.get(i)==1)
			{
				if(slotb<10)
				{
					assignedID.add("Student_"+(i+1));
					assign1.add("B");
					slotb++;
					total_pref[i]=total_pref[i]+1;
				}
				else
				{
					if(pref3.get(i)==2 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref4.get(i)==2 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref1.get(i)==2 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("A");
						slota++;
						total_pref[i]=total_pref[i]+2;
					}
				}
			}
			else if(pref3.get(i)==1)
			{
				if(slotc<10)
				{
					assignedID.add("Student_"+(i+1));
					assign1.add("C");
					slotc++;
					total_pref[i]=total_pref[i]+1;
				}
				else
				{
					if(pref1.get(i)==2 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("A");
						slota++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref2.get(i)==2 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref4.get(i)==2 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+2;
					}
				}
			}
			else if(pref4.get(i)==1)
			{
				if(slotd<10)
				{
					assignedID.add("Student_"+(i+1));
					assign1.add("D");
					slotd++;
					total_pref[i]=total_pref[i]+1;
				}
				else
				{
					if(pref1.get(i)==2 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("A");
						slota++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref2.get(i)==2 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+2;
					}
					else if(pref3.get(i)==2 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign1.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+2;
					}
				}
			}
		}

		//Assigning Second course		
		for(i=0;i<12;i++)
		{
			if(pref1.get(i)==2)
			{
				if(slota<10)
				{
					assignedID.add("Student_"+(i+1));
					assign2.add("A");
					slota++;
					total_pref[i]=total_pref[i]+2;
				}
				else
				{
					if(pref2.get(i)==3 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref3.get(i)==3 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref4.get(i)==3 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+3;
					}
				}
			}
			else if(pref2.get(i)==2)
			{
				if(slotb<10)
				{
					assignedID.add("Student_"+(i+1));
					assign2.add("B");
					slotb++;
					total_pref[i]=total_pref[i]+2;
				}
				else
				{
					if(pref3.get(i)==3 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref4.get(i)==3 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref1.get(i)==3 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("A");
						slota++;
						total_pref[i]=total_pref[i]+3;
					}
				}
			}
			else if(pref3.get(i)==2)
			{
				if(slotc<10)
				{
					assignedID.add("Student_"+(i+1));
					assign2.add("C");
					slotc++;
					total_pref[i]=total_pref[i]+2;
				}
				else
				{
					if(pref1.get(i)==3 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("A");
						slota++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref2.get(i)==3 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref4.get(i)==3 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+3;
					}
				}
			}
			else if(pref4.get(i)==2)
			{
				if(slotd<10)
				{
					assignedID.add("Student_"+(i+1));
					assign2.add("D");
					slotd++;
					total_pref[i]=total_pref[i]+2;
				}
				else
				{
					if(pref1.get(i)==3 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("A");
						slota++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref2.get(i)==3 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+3;
					}
					else if(pref3.get(i)==3 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign2.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+3;
					}
				}
			}
		}
		
		//Assigning Third course
		for(i=0;i<12;i++)
		{
			if(pref1.get(i)==3)
			{
				if(slota<10)
				{
					assignedID.add("Student_"+(i+1));
					assign3.add("A");
					slota++;
					total_pref[i]=total_pref[i]+3;
				}
				else
				{
					if(pref2.get(i)==4 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref3.get(i)==4 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref4.get(i)==4 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+4;
					}
				}
			}
			else if(pref2.get(i)==3)
			{
				if(slotb<10)
				{
					assignedID.add("Student_"+(i+1));
					assign3.add("B");
					slotb++;
					total_pref[i]=total_pref[i]+3;
				}
				else
				{
					if(pref1.get(i)==4 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("A");
						slota++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref3.get(i)==4 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref4.get(i)==4 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+4;
					}
				}
			}
			else if(pref3.get(i)==3)
			{
				if(slotc<10)
				{
					assignedID.add("Student_"+(i+1));
					assign3.add("C");
					slotc++;
					total_pref[i]=total_pref[i]+3;
				}
				else
				{
					if(pref1.get(i)==4 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("A");
						slota++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref2.get(i)==4 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref4.get(i)==4 && slotd<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("D");
						slotd++;
						total_pref[i]=total_pref[i]+4;
					}
				}
			}
			else if(pref4.get(i)==3)
			{
				if(slotd<10)
				{
					assignedID.add("Student_"+(i+1));
					assign3.add("D");
					slotd++;
					total_pref[i]=total_pref[i]+3;
				}
				else
				{
					if(pref1.get(i)==4 && slota<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("A");
						slota++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref2.get(i)==4 && slotb<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("B");
						slotb++;
						total_pref[i]=total_pref[i]+4;
					}
					else if(pref3.get(i)==4 && slotc<10)
					{
						assignedID.add("Student_"+(i+1));
						assign3.add("C");
						slotc++;
						total_pref[i]=total_pref[i]+4;
					}
				}
			}
		}

		//Printing all the Assigned Courses.
		int j=0;
		System.out.println("\nStudents with their assigned courses and total preference count.");
		for (j=0;j<12;j++)
		{
			System.out.println(assignedID.get(j) +" "+ assign1.get(j)+" "+assign2.get(j)+" "+assign3.get(j)+" "+total_pref[j]);
			final_pref = final_pref + total_pref[j];
		}
		
		//Finding the average of all the preferences.
		final_pref = final_pref/12;
		System.out.println("Average preference_score is: "+ final_pref);

		// writing all the output a file.
		try
		{
			File file = new File(output_file);

			if (!file.exists())
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (j=0;j<12;j++)
			{
				bw.write(assignedID.get(j) +" "+ assign1.get(j)+" "+assign2.get(j)+" "+assign3.get(j)+" "+total_pref[j]);
				bw.newLine();
			}
			
			bw.write("Average preference_score is: "+ final_pref);
			bw.close();
		}
		catch (IOException e)
		{
			System.out.println("Cannot open file to Write data.\n");
			e.printStackTrace();
			System.exit(-1);
		}
    }//End of main.
}