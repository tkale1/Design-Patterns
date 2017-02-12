package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * @author tanmaykale
 *	The Results class implements two interfaces.
 *  StdoutDisplayInterface : To print data on the screen
 *  FileDisplayInterface : To print data to a file.
 */

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	String[] name;
	String filename;
	public char assigned[][];
	public int assignedpref[][];
	int totalpref;
	FileProcessor fp;

	/**
	 * The Constructor of the Results class takes one argument which 
	 * is used to open the output file.
	 * This class has the methods to print the output to the file or 
	 * on the screen.
	 * The Results class also contains the method addsubject() which 
	 * is used to assign a course to the respected student.
	 * It also have the required data structure which are needed to 
	 * store the assigned courses/preferences to the students.
	 * @param filenameIn
	 */
	public Results(String filenameIn) {
		Logger.writeMessage("In Constructor of a Results", Logger.DebugLevel.CONSTRUCTOR);
		name = new String[80];
		assigned = new char[80][5];
		assignedpref = new int[80][5];
		filename = filenameIn;

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * returns a string which contains all the results.
	 * i.e all the courses that have been assigned to all 
	 * the students.
	 */
	@Override
	public String toString() {
		String output = "";
		for(int i = 0;i<80;i++)
			output +="Results [name = " + name[i] + ", assigned = " + Arrays.toString(assigned[i]) + ", assignedpref = "
				+ Arrays.toString(assignedpref[i]) + ", totalpref = " + this.getTotal(i) + "]\n";
		return output;
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.FileDisplayInterface()
	 * and writeSchedulesToFile() which are used to write 
	 * the data to a file.
	 * the name of the file is taken as in arguments 
	 * in the class constructor.
	 */
	@Override
	public void writeSchedulesToFile() {
		try {
			File file = new File(filename);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < 80; i++) {
				String output = name[i] + " ";
				for (int k = 0; k < 5; k++) {
					output = output + assigned[i][k] + " ";
				}
				output += this.getTotal(i);
				bw.write(output);
				bw.newLine();
			}
			double finalpref = getavgPref();

			bw.write("Average preference_score is: " + finalpref);
			bw.close();
		} catch (IOException e) {
			System.out.println("Cannot open file to Write data.\n");
			e.printStackTrace();
			System.exit(-1);
		} finally {

		}

	}

	/* (non-Javadoc)
	 * registrationScheduler.store.
	 * StdoutDisplayInterface#writeSchedulesToScreen()
	 * Writes the output data to the screen every time 
	 * the method is called.
	 */
	@Override
	public void writeSchedulesToScreen() {
//		for (int i = 0; i < 80; i++)
//		System.out.println(toString(i));
		for (int i = 0; i < 80; i++) {
			String output = name[i] + " ";
			for (int k = 0; k < 5; k++) {
				output = output + assigned[i][k] + " ";
			}
			output += this.getTotal(i);
			System.out.println(output);
		}
		double final_pref = getavgPref();
		System.out.println("Average preference_score is: " + final_pref);
	}

	/**
	 * This method is used a setter method
	 * It takes two parameters
	 * @param nameIn : A String that contains the 
	 * name of the student.
	 * @param i :  The record number of the student.
	 */
	public void setName(String nameIn, int i) {
		name[i] = nameIn;
	}

	int counter = 0;

	/**
	 * This method is used to assign a course to a student. 
	 * It takes 4 arguments
	 * @param posIn : used to determine the preference position 
	 * of the student. i.e first pref/second pref
	 * @param indexIn : used to check which subject is to be allocated.
	 * i.e 0= A, 1=B,...,5=F,6=G 
	 * @param i : used to determine the number of the student.
	 * ex: 1st student, 2nd student...
	 * @param pref : to Store the preference count of the subject.
	 * @return
	 */
	public synchronized int addsubject(int posIn, int indexIn, int i, int pref) {

		if (indexIn == 0) {
			assigned[i][posIn] = 'A';
		} else if (indexIn == 1) {
			assigned[i][posIn] = 'B';

		} else if (indexIn == 2) {
			assigned[i][posIn] = 'C';

		} else if (indexIn == 3) {
			assigned[i][posIn] = 'D';

		} else if (indexIn == 4) {
			assigned[i][posIn] = 'E';

		} else if (indexIn == 5) {
			assigned[i][posIn] = 'F';

		} else if (indexIn == 6) {
			assigned[i][posIn] = 'G';

		}
		assignedpref[i][posIn] = pref;
		return 1;
	}

	public int getTotal(int i) {
		int total = 0;
		for (int x = 0; x < 5; x++) {
			total += assignedpref[i][x];
		}
		return total;
	}

	/**
	 * this method is used to get the average 
	 * preference count all the students.
	 * @return the average preference count of all the students.
	 */
	public double getavgPref() {
		int avgpref = 0;
		int temp;
		for (int x = 0; x < 80; x++) {
			temp = getTotal(x);
			avgpref += temp;
		}
		return avgpref / 80.0;
	}
}
