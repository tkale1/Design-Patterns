package registrationScheduler.threadMgmt;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;
import registrationScheduler.util.StoreDataClass;


/**
 * @author tanmaykale
 * The Createworker class is used to create the number of
 * working threads that are needed to execute the algorithm
 * This class takes objects of all other necessary class 
 * and use it to create all the worker theads.
 */
public class Createworker {
	int numThreads;
	FileProcessor fprocessorObj;
	Results resultObj;
	Worker workersObj;
	StoreDataClass StoreDataClass;

	int i;

	/**
	 * The constructor of the Createworker class takes the 
	 * following arguments and create the specified 
	 * no of worker class.
	 * @param numThreadsIN : value that contains the no. 
	 * of threads that are to be created.
	 * @param fprocessorObjIN : File processor object required 
	 * to read the contents of the input file.
	 * @param resultObj2 : To call the logger during checking 
	 * of debug level. (Everytime a data structure is added) 
	 * @param storeDataIn : Object to call the main algorithm 
	 * which is in the StoreDataClass.
	 */
	public Createworker(int numThreadsIN, FileProcessor fprocessorObjIN, FileDisplayInterface resultObj2IN,
			StoreDataClass storeDataIn)
	{
		Logger.writeMessage("In Constructor of Create Worker", Logger.DebugLevel.CONSTRUCTOR);
		numThreads = numThreadsIN;
		fprocessorObj = fprocessorObjIN;
		resultObj = (Results) resultObj2IN;
		StoreDataClass = storeDataIn;
	}

	/**
	 *  This method startWorker is used to create the 
	 *  required number of thread. and Join them.
	 */
	public void startWorker() {

		workersObj = new Worker(fprocessorObj, resultObj, StoreDataClass);
		Thread thread[] = new Thread[numThreads];
		/**
		 * Create threads in this block
		 */
		for (i = 0; i < numThreads; i++) {
		 thread[i] = new Thread(workersObj);
		}
		/**
		 * Start all the created threads.
		 */
		for (i = 0; i < numThreads; i++) {
			thread[i].start();
		}
		/**
		 * Join all the created threads.
		 */
		for (i = 0; i < numThreads; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Logger.writeMessage(resultObj.toString(), DebugLevel.DATASTRUCTURE);
	}
}