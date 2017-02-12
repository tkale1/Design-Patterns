package registrationScheduler.threadMgmt;

import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StoreDataClass;

/**
 * @author tanmaykale
 * The Worker class implements Runnable interface.
 * It contains the implementation of the run method.
 * The run method is used to call the main algorithm 
 * which is the StoreDataClass.
 * It also reads the file line by line and send the 
 * readed string as an arguments to the storeData method
 * of the StoreDataClass.
 */
public class Worker implements Runnable {
	String line;

	FileProcessor fileProcessorObj;
	StoreDataClass storeDataObj;
	Results rs;

	/**
	 * The Constructor of the Worker class has the 
	 * following parameters.
	 * @param fileProcessorObjIn : used to read the contents 
	 * of the file line by line.
	 * @param rsIn : used to access the methods and data members 
	 * of the results class. As the results class contains
	 * all the necessary data structure which are needed 
	 * by the algorithm.
	 * @param StoreData_ObjIn : used to call the methods 
	 * of the StoreDataClass.
	 */
	public Worker(FileProcessor fileProcessorObjIn, Results rsIn, StoreDataClass storeDataObjIn) {
		Logger.writeMessage("In Constructor of a WorkerThread", Logger.DebugLevel.CONSTRUCTOR);
		fileProcessorObj = fileProcessorObjIn;
		rs = rsIn;
		storeDataObj = storeDataObjIn;
		line = null; // File_ProcessorObj.readLineFromFile();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Used to read the content of the input 
	 * file line by line
	 * Once a line it read it passes the string 
	 * to storeData() of the StoreDataClass.
	 */
	public void run() {
		Logger.writeMessage(Thread.currentThread().getName() + " began its run method", Logger.DebugLevel.INTHREADRUN);

		while ((line = fileProcessorObj.readLineFromFile()) != null) {
			storeDataObj.storeData(line, rs);
		}
	}// End of run.
}// End of Worker Class