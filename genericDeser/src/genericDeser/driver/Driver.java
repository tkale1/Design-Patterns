package genericDeser.driver;

import java.io.FileNotFoundException;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.fileOperations.FileProcessorI;
import genericDeser.util.PopulateObjects;
import genericDeser.util.Logger;

public class Driver
{
	/**
	 * Main function of the Driver class.
	 * This function takes 2 arguments.
	 * 1. inputfile name	2. Logger Debug Level
	 * The main function creates instances of all the class. which includes 
	 * FileProcessor : Which has the file processor objects in it.
	 * PopulateObjects : Which is used to call the deserObjects().
	 * @param args
	 */
	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.err.println("Invalid number of Command line arguments");
			System.err.println("Please check the arguments");
			System.exit(1);
		}
	
		String inputfile=args[0];
		int debugLevel = 0;
		try
		{
			debugLevel = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException ex)
		{
			System.err.println("Check the arguments");
			System.exit(-1);
		}
		finally{
			
		}
		Logger.setDebugValue(debugLevel);
		
		PopulateObjects popObj=null;
		FileProcessorI fp = null;
		
		try
		{
			fp = new FileProcessor(inputfile);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("File not Found. Please check the argument passed to the program.\n");
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			
		}
		
		popObj = new PopulateObjects(fp);
		popObj.deserObjects();
		popObj.getCount();

	}

}
