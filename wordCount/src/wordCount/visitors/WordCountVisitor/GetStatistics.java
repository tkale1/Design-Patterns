package wordCount.visitors.WordCountVisitor;

import wordCount.dsForStrings.Node;
import wordCount.util.Logger;

/**
 * @author tanmaykale
 * To get the details of the tree such as no of words, no of distinct
 * words and total no of character(excluding spaces.)
 */
public class GetStatistics {

	public int noWords = 0;
	public int distinctWords = 0;
	public int noOfCharacters = 0;
	
	public GetStatistics()
	{
        Logger.writeMessage ("In Constructor of GetStatistics", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * To get the total no of words stored in a Tree.
	 * @param rootIn: Is the root node of the tree to do inorder traversing
	 * in get all the child of the trees.
	 */
	public int noofWords(Node rootIn)
	{
		Node rootTemp = rootIn;
		if (null == rootTemp) {
			return 0;
		}
		if (null != rootTemp)
        {
			noofWords(rootTemp.getLeft());     
			noWords += rootTemp.getFrequency();
			noofWords(rootTemp.getRight());
            
        }
		return noWords;
	}
	/**
	 * To get the total no of distinct words stored in a Tree.
	 * @param rootIn: Is the root node of the tree to do inorder traversing
	 * in get all the child of the trees.
	 */
	public int noofDistinctWords(Node rootIn)
	{
		Node rootTemp = rootIn;
		if (null == rootTemp) {
			return 0;
		}
		if(null != rootTemp) {
			 distinctWords = 1;
			 distinctWords += noofDistinctWords(rootIn.getLeft());
			 distinctWords += noofDistinctWords(rootIn.getRight());
        }
		return distinctWords;
		
	}
	/**
	 * To get the total no of characters stored in a Tree.
	 * @param rootIn: Is the root node of the tree to do inorder traversing
	 * in get all the child of the trees.
	 */
	public int noofCharacters(Node rootIn)
	{

		Node rootTemp = rootIn;
		if (null == rootTemp) {
			return 0;
		}
		if(null != rootTemp) {
			noofCharacters(rootTemp.getLeft());    
			int temp2 = rootTemp.getcharCount()*rootTemp.getFrequency();
			noOfCharacters += temp2;
			noofCharacters(rootTemp.getRight());
        }
		return noOfCharacters;
	}
	
}
