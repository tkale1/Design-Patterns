package registrationScheduler.util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author tanmaykale
 * The FileProcessor class is used to read the contents 
 * of the input file.
 */
public class FileProcessor
{
	FileReader fileInput;
	BufferedReader bufferedInput;
	String fname;
	File filename;
	
	/**
	 * The Constructor of the FileProcessor class takes 
	 * the following input.
	 * @param fileNameIn : The name of the inputfile 
	 * that is to read by the threads.
	 * 
	 */
	public FileProcessor(String fileNameIn)
	{
		Logger.writeMessage ("In Constructor of File_Processor", Logger.DebugLevel.CONSTRUCTOR);
		try
		{
			fname = fileNameIn;
			filename = new File(fname);
			
			fileInput = new FileReader(filename);
            bufferedInput = new BufferedReader(fileInput);
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.err.println("Exception:\"" + filename + "\" was not found. Please enter Correct filename.");
			System.err.println("Suggestion: Check for incorrect file name and it's extension.\n");
			System.exit(1);                
        }
		finally{
			
		}
	}

	/**
	 * Reads a line from the file.
	 * @return : a String named as line to 
	 * the calling class.
	 * The String contains a single record of one 
	 * student at a time.
	 * the String contains name of the student 
	 * and the preferences of 7 subjects that 
	 * are given by the student.
	 */
	public String readLineFromFile(){
		String line = null;		
		try{
			line = bufferedInput.readLine();
					//return line;
		}
		catch(IOException ex) {
       		ex.printStackTrace(); 
       		System.err.println("Unable to read line from file.");
			System.exit(1);                    
        }
		finally{
			
		}
		return line;
	}
 
	/**
	 * Closes the file upon reading 
	 * all the student records.
	 */
	public void closeFile(){	
		try{
			bufferedInput.close();
		}
		catch(IOException ex) {
       		ex.printStackTrace(); 
			System.exit(1);                    
        }finally{
        	
        }
	}
}
