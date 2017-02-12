package wordCount.visitors.WordCountVisitor;

import java.io.IOException;
import wordCount.dsForStrings.BSTInterface;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI.Visitor;

/**
 * @author tanmaykale
 * calls the individual methods of the GetStatistics class 
 * in order to get the required details of the tree.
 */
public class WordCountVisitor implements Visitor
{
	
	public FileProcessor fileprocessor;
	GetStatistics getStats;
	
	public WordCountVisitor(FileProcessor fileprocessorIn, GetStatistics getStatsIn)
	{
		getStats = getStatsIn;
		fileprocessor = fileprocessorIn; 
		Logger.writeMessage ("In Constructor of WordCountVisitor", Logger.DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void visit(BSTInterface bTreeIn) throws IOException
	{
		// TODO Auto-generated method stub
		BSTInterface bTree = bTreeIn;
		Node root = bTree.getRootNode();

		int  noWords = getStats.noofWords(root);
		int  nodistinctWords = getStats.noofDistinctWords(root);
		int  noofChars = getStats.noofCharacters(root);
		fileprocessor.writeToFile(noWords, nodistinctWords, noofChars);
	}

}