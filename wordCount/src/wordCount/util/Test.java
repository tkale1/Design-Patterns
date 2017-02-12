package wordCount.util;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.BSTInterface;
import wordCount.visitors.CloneVisitor.CloneVisitor;
import wordCount.visitors.DSProcessingVisitorI.Visitor;
import wordCount.visitors.UpdateVisitor.UpdateVisitor;

/**
 * @author tanmaykale
 * The Test class contains methods which are used to create Backup tree
 * and Update the backpTree.
 */
public class Test {
	BSTInterface backupTree;
	FileProcessor fileProcessor;
	
	public Test()
	{
		backupTree = new BST();
        Logger.writeMessage ("In Constructor of Test", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * The CreateBackup method is used to create Backup tree
	 * @param originalTree : it is used as an argument the the CloneVisitor
	 */
	public void CreateBackup(BSTInterface originalTree)
	{
		//System.out.println("\nCreating a backup Tree.\n");
		Visitor CV = new CloneVisitor(backupTree,originalTree);
		originalTree.accept(CV);
		System.out.println("\n");
		//System.out.println("Created backupTree");
		
		/*
		 * Remove the below comment to check for created backup tree.
		 * CloneVisitor calls the Clone function and clones the tree
		 * node by node.
		 */
		
		//backupTree.printInorder(backupTree.getRootNode());
	}
	
	
	/**
	 * The CheckUpdate method is used to create Backup tree
	 * @param originalTree : it is used as an argument the the UpdateVisitor
	 */
	public void CheckUpdate(BSTInterface originalTree)
	{
		Visitor update = new UpdateVisitor(originalTree);
		originalTree.accept(update);
		System.out.println("\n");
		//System.out.println("\nUpdated backupTree");
		
		/*
		 * Remove the below comment to check for updated backup tree.
		 * UpdateVisitor calls the update function and increments the frequency
		 * of all nodes by '10'.
		 */
		
		//backupTree.printInorder(backupTree.getRootNode());
	}
	

}
