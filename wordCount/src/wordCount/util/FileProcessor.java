package wordCount.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author tanmaykale
 * The FileProcessor class is used to read the contents of the input file.
 */
public class FileProcessor
{
	BufferedWriter out;
	Scanner scanner;
	
	String inputfile;
	String outputfile;
	
	File filename;
	File filename1;
	
	FileReader fileInput;
	FileWriter fileOutput;
	
	public FileProcessor(String inputfileIn,String outputfileIn) throws FileNotFoundException
	{
		Logger.writeMessage ("In Constructor of File_Processor", Logger.DebugLevel.CONSTRUCTOR);
		try
		{
			inputfile = inputfileIn;
			outputfile = outputfileIn;
			filename = new File(inputfile);
			filename1 = new File(outputfile);
	
			fileInput = new FileReader(filename);
			fileOutput = new FileWriter(filename1);
			
			out = new BufferedWriter(fileOutput);
            scanner = new Scanner(fileInput);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			System.err.println("Exception:\"" + filename + "\" was not found. Please enter Correct filename.");
			System.err.println("Suggestion: Check for file extension or any Spelling mistake in File Name\n");
			System.exit(1);                
        }
		finally{
			
		}
	}

	/**
	 * Reads a line from the file.
	 * tempWords : returns a String array named as tempWords to the calling class.
	 */
	public String[] readFromFile() throws IOException
	{
		Logger.writeMessage ("READING DATA FROM FILE", Logger.DebugLevel.FILEREAD);
		String line = null;
		String[] tempWords = null;
		try
		{
			scanner.useDelimiter("\r\n");
			while (scanner.hasNext())
			{
			    line = scanner.next();
			    if(null != line)
			    {
			    	tempWords = line.split("\\s+");
			    }
			}
		}
		finally
		{
			
		}
		return tempWords;
	}
 
	/**
	 * Write data to the file.
	 */
	public void writeToFile(int noWords, int nodistinctWords, int noofChars) throws IOException
	{
		try
		{
			out.write("Total no. of words : " + noWords);
			out.newLine();
			out.write("Total no. distinct of words : " + nodistinctWords);
			out.newLine();
			out.write("Total no. of Characters : " + noofChars);
			out.close();
		}
		catch (IOException e)
		{
			System.out.println("Cannot open file to Write data.\n");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	/**
	 * Closes the file upon reading data.
	 */
	public void closeFile() throws IOException
	{	
		try
		{
			fileInput.close();
			fileOutput.close();
			scanner.close();
			out.close();
		}
		finally
		{
        	
        }
	}
	
	
}
