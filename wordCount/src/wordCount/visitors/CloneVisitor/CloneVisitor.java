package wordCount.visitors.CloneVisitor;

import java.io.IOException;
import wordCount.dsForStrings.BSTInterface;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI.Visitor;

/**
 * @author tanmaykale
 * calls the CloneTraverse() from the BST class to 
 *  create a backup of the original tree.
 */
public class CloneVisitor implements Visitor{
	
	BSTInterface backupTree;
	BSTInterface ogTree;
	public CloneVisitor(BSTInterface backupIn, BSTInterface originalTreeIn)
	{
		backupTree = backupIn;
		ogTree = originalTreeIn;
		Logger.writeMessage ("In Constructor of CloneVisitor", Logger.DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void visit(BSTInterface originalTree) throws IOException
	{
		originalTree.cloneTraverse(backupTree,ogTree);
	}

}