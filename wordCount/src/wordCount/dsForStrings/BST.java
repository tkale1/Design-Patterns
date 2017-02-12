package wordCount.dsForStrings;

import java.io.IOException;

import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI.Visitor;


/**
 * @author tanmaykale
 * The BST tree implements BSTInterface. It contains
 * all the generic method of a BST tree.
 */
public class BST implements BSTInterface{

	Visitor visitorObj;
	private Node rootNode;
	
	/**
	 * The constructor of the BST initializes the rootnode of
	 * the Tree object to null.
	 */
	public BST()
	{
		rootNode = null;
		Logger.writeMessage ("In Constructor of BST", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	@Override
	public void insert(String wordIn)
	{
		
		String word = wordIn;
		// TODO Auto-generated method stub
		Node temp = new Node(word);
		if(null == rootNode)
		{
			rootNode = temp;
			return;
		}
		Node temp1 = rootNode;
		boolean flag = true;
		while(flag)
		{
			String str = temp1.getWord();
			String str1 = temp.getWord();
			
			if(0 == str.compareTo(str1))
			{
				temp1.setFrequency(temp1.getFrequency() + 1);
				break;
			}
			if(str.compareTo(str1) > 0)
			{
				if (null == temp1.getLeft())
				{
					temp1.setLeft(temp);
					break;
				}
				else
				{
					temp1 = temp1.getLeft();
				}
			}
			else if(str.compareTo(str1) < 0)
			{
				if (null == temp1.getRight())
				{
					temp1.setRight(temp);
					break;
				}
				else
				{
					temp1 = temp1.getRight();
				}
			}
		}//End of while
	}//End of insert()

	@Override
	public void printInorder(Node rootIn)
	{
		// TODO Auto-generated method stub
		Node rootTemp = rootIn;
		if (null == rootTemp)
		{
			return;
		}
		if (null != rootTemp)
        {
			printInorder(rootTemp.getLeft());     
            System.out.print(rootTemp.getWord() +" ---> Frequency : "+rootTemp.getFrequency()+"\n");
            printInorder(rootTemp.getRight());
        }
	}
		
	@Override
	public void accept(Visitor visitIn)
	{
		visitorObj=visitIn;
		try {
			visitorObj.visit(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Node getRootNode()
		{
		return rootNode;
	}
	@Override
	public void setRootNode(Node rootIn)
	{
		rootNode = rootIn;
	}

	
	@Override
	public void cloneTraverse(BSTInterface backupTree,BSTInterface ogTree)
	{
		Logger.writeMessage ("CLONE TREE method called", Logger.DebugLevel.CLONETREE);
		try
		{
			backupTree.setRootNode(ogTree.getRootNode().clone());
			ogTree.getRootNode().registerObserver(backupTree.getRootNode());
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		cloneRecurse(ogTree.getRootNode(),backupTree.getRootNode());	
	}
	
	@Override
	public void cloneRecurse(Node currentNode,Node backupNode){
		
		if(currentNode.getLeft()!=null)
		{
			try
			{
				backupNode.setLeft(currentNode.getLeft().clone());
				currentNode.getLeft().registerObserver(backupNode.getLeft());
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
			cloneRecurse(currentNode.getLeft(),backupNode.getLeft());
		}
		if(currentNode.getRight()!=null)
		{
			try
			{
				backupNode.setRight(currentNode.getRight().clone());
				currentNode.getRight().registerObserver(backupNode.getRight());
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
			cloneRecurse(currentNode.getRight(),backupNode.getRight());
		}
	}
	
	@Override
	public void updateTree(Node rootIn)
	{
		Node rootTemp = rootIn;
		if (null == rootTemp)
		{
			return;
		}
		if (null != rootTemp)
        {
			Logger.writeMessage ("UPDATE TREE method called", Logger.DebugLevel.UPDATETREE);
			updateTree(rootTemp.getLeft());
			rootTemp.setFrequency(rootTemp.getFrequency()+10);
			rootTemp.updateBackup();
            updateTree(rootTemp.getRight());
        }
	}

}
