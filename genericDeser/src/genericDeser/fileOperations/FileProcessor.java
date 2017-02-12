package genericDeser.fileOperations;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import genericDeser.util.Logger;

/**
 * @author tanmaykale
 * The FileProcessor class is used to read the contents of the input file.
 */
public class FileProcessor implements FileProcessorI
{
	String inputfile;
	BufferedReader br;
	
	public FileProcessor(String inputfileIn) throws FileNotFoundException
	{
		Logger.writeMessage ("In Constructor of File_Processor", Logger.DebugLevel.CONSTRUCTOR);
		try
		{
			inputfile=inputfileIn;
    		br = new BufferedReader(new FileReader(inputfile));
    	}
		catch(NullPointerException e)
		{
       		System.err.println("NullPointerException");
    		System.exit(0);
		}
		catch (FileNotFoundException e)
		{
		    System.err.println("Filenotfound Exception occured");
			System.exit(0);	
		}
		finally
		{
			
		}
	}// END OF FILEPROCESSOR()

	/**
	 * Reads a line from the file.
	 * temp : reads a line from the input file and returns the string
	 */
	public String readFromFile()
	{
		Logger.writeMessage ("readFromFile() called", Logger.DebugLevel.FUNCTIONCALL);
		try
		{
			 String temp = br.readLine();
			 Logger.writeMessage ("Reading Line from the input file", Logger.DebugLevel.FILEREAD);
			 return temp;
		}
		catch (IOException e)
		{
			System.out.println("IOException occured");
			System.exit(0);	
		}
		finally
		{
			
		}
		return null;
	}
 
	/**
	 * Write data to the file.
	 */
	public void writeToFile()
	{
		Logger.writeMessage ("writeToFile() called", Logger.DebugLevel.FUNCTIONCALL);
	}// End of writeToFile
	
	/**
	 * Closes the file upon reading data.
	 */
	public void closeFile()
	{	
		
		try {
			Logger.writeMessage ("closeFile() called", Logger.DebugLevel.FUNCTIONCALL);
			br.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
	}// END OF closeFile
	
	
}

