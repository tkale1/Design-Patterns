package wordCount.dsForStrings;

import wordCount.visitors.DSProcessingVisitorI.Visitor;

//import java.util.ArrayList;

/**
 * @author tanmaykale
 * The BSTInterface is an interface to implement
 * a Binary Search Tree.
 */
public interface BSTInterface {

	public void insert(String value);
	
	public void printInorder(Node rootIn);
	
	public void accept(Visitor visitIn);
	
	public Node getRootNode();
	
	public void setRootNode(Node rootIn);
	
	public void cloneTraverse(BSTInterface backupTree, BSTInterface ogTree);
	
	public void cloneRecurse(Node currentNode,Node backupNode);
	
	public void updateTree(Node rootIn);
}
