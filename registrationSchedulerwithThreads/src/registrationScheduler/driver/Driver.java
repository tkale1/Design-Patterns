package registrationScheduler.driver;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.threadMgmt.Createworker;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StoreDataClass;

public class Driver {

	
	/**
	 * Main function of the Driver class.
	 * This function takes 4 arguments.
	 * 1. inputfile name	2. Outputfile name	3. No. of threads	
	 * 4. Logger Debug Level
	 * The main function creates instances of all the class. 
	 * which includes 
	 * StoreDataClass : Which has the algorithm in it.
	 * FileProcessor : Which has the file processor objects in it.
	 * FileDisplayInterface : Which has the function which writes 
	 * the output data to the file.
	 * StdoutDisplayInterface : which has the function which writes
	 * data to the screen.
	 * Createworker : Which creates the no of worker threads needed 
	 * to run the program.
	 * @param args
	 */
	public static void main(String[] args) {

		// Validating runtime arguments
		int count = args.length;
		String inputFile;
		String outputFile;
		int numThreads = 0;
		int debugLevel = -1;
		if (count <= 1 || count > 4) {
			System.out.println("Exiting Program. \nIncorrect number of arguments.");
			System.exit(0);
		}
		
		/**
		 *Read the Inputfile name and the Outputfile name.
		*/
		inputFile = args[0];
		outputFile = args[1];

		/**
		 *Read the number of Threads
		 */
		numThreads = Integer.parseInt(args[2]); // Number format exception TODO
		if (numThreads < 0 || numThreads > 3) {
			System.out.println("Exiting Program. \nNo. of Threads exceeded.");
			System.exit(0);
		}

		/**
		 *Getting the debug level and setting the debug level and checking it.
		 */debugLevel = Integer.parseInt(args[3]);
		if (debugLevel < 0 || debugLevel > 4) {
			System.out.printf("Exiting Program. \nError: Incorrect debug Level.\n");
			System.exit(0);
		}
		Logger.setDebugValue(debugLevel);
		
		
		StoreDataClass storeDataObj = new StoreDataClass();
		FileProcessor fprocessorObj = new FileProcessor(inputFile);
		FileDisplayInterface resultObj = new Results(outputFile);
		StdoutDisplayInterface resultObj1 = (Results) resultObj;
		Createworker cworkerObj = new Createworker(numThreads, fprocessorObj, resultObj, storeDataObj);
		cworkerObj.startWorker();
		
		resultObj1.writeSchedulesToScreen();
		resultObj.writeSchedulesToFile();

	}// End of main

}