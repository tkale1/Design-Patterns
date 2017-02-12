package wordCount.visitors.PopulateVisitor;

import java.io.IOException;
import wordCount.dsForStrings.BSTInterface;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI.Visitor;

/**
 * @author tanmaykale
 * calls the readFromFile() from the FileProcessor class to 
 *  read the file, tokenize it and insert each node into the BST Tree.
 */
public class PopulateTreeVisitor implements Visitor {

	public FileProcessor fileProcessor;
	int i =0;
    public PopulateTreeVisitor(FileProcessor fileProcessorIn)
    {
       fileProcessor = fileProcessorIn; 
       Logger.writeMessage ("In Constructor of PopulateTreeVisitor", Logger.DebugLevel.CONSTRUCTOR);
    }

    @Override
	public void visit(BSTInterface bTreeIn) throws IOException
    {       
    	BSTInterface bTree = bTreeIn;
 
    	String[] words = fileProcessor.readFromFile();
        if(words!=null)
        {
        	if(0 < words.length)
        	{
        		for(i=0;i<words.length;i++)
        		{
               		bTree.insert(words[i]);
        		}
        	}  
        } 
        else
        {
        	return;
        }
        }
}//End of class
