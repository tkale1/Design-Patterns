package wordCount.visitors.UpdateVisitor;

import java.io.IOException;

import wordCount.dsForStrings.BSTInterface;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI.Visitor;

/**
 * @author tanmaykale
 * calls the updateTree() from the BST class to 
 *  update the backup tree with the changes done in the
 *  original tree.
 */
public class UpdateVisitor implements Visitor {

	BSTInterface ogTree;
	public UpdateVisitor(BSTInterface originalTreeIn)
	{
		ogTree = originalTreeIn;
		Logger.writeMessage ("In Constructor of UpdateVisitor", Logger.DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void visit(BSTInterface originalTree) throws IOException
	{
		originalTree.updateTree(originalTree.getRootNode());
	}	

}
