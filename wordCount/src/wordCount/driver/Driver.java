package wordCount.driver;

import java.io.IOException;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.BSTInterface;
import wordCount.util.FileProcessor;
import wordCount.util.Test;
import wordCount.visitors.DSProcessingVisitorI.Visitor;
import wordCount.visitors.PopulateVisitor.PopulateTreeVisitor;
import wordCount.visitors.WordCountVisitor.GetStatistics;
import wordCount.visitors.WordCountVisitor.WordCountVisitor;


/**
 * @author tanmaykale
 * Contains all the code to create a BST and create its backu
 * and update the backup using observer pattern.
 */
public class Driver
{

	public static void main(String[] args) throws IOException
	{
		
		//Validating runtime arguments
    	int count = args.length;
    	if(count <= 0 || count == 1 || count == 2 || count >3)
    	{
    		System.out.println("Exiting Program. \nIncorrect number of arguments.");
    		System.exit(0);
    	}

    	BSTInterface bst = null;
    	FileProcessor fileProcessor;
    	GetStatistics getStats;
    	Visitor PopulateTree;
    	Visitor WordCount;
		
    	String inputFileName = args[0];
		String outputFileName = args[1];
		
		long startTime = System.currentTimeMillis();
		int NUM_ITERATIONS = Integer.parseInt(args[2]);
		for(int i= 0; i<NUM_ITERATIONS;i++)
		{
			bst = null;
			fileProcessor = null;
			PopulateTree = null;
			WordCount = null;
			getStats = null;
			
			try
			{
				fileProcessor = new FileProcessor(inputFileName,outputFileName);
				getStats = new GetStatistics();
				bst = new BST();
				PopulateTree = new PopulateTreeVisitor(fileProcessor);
				WordCount = new WordCountVisitor(fileProcessor,getStats);
				bst.accept(PopulateTree);
				bst.accept(WordCount);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.err.println("ERROR : Check the file name and extension.");
				System.err.println("ERROR : Failed to Read the file and create the Tree.");
			}
			finally
			{
				fileProcessor.closeFile();	
			}
		}
	
		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime - startTime) / NUM_ITERATIONS;
		System.out.println("Total Time : "+total_time+" milliseconds");
		//bst.printInorder(bst.getRootNode());
		
		//Create and Check update of Backup Tree.
		if(bst.getRootNode()!=null)
		{
			Test t1 = new Test();
			t1.CreateBackup(bst);
			t1.CheckUpdate(bst);
		}

	}

}
