package wordCount.dsForStrings;

import java.util.ArrayList;
import wordCount.Observer.ObserverInterface;
import wordCount.Observer.SubjectInterface;
import wordCount.util.Logger;

/**
 * @author tanmaykale
 * The Node class implements Cloneable,ObserverInterface and SubjectInterface
 * It has the getter and setter methods of each data member.
 * It also implements the methods from ObserverInterface and SubjectInterface
 * to register, notify, update and remove the obeserver.
 */
public class Node implements Cloneable,ObserverInterface,SubjectInterface
{

	public Node left,right;
	public String word;
	public int frequency;
	public int count;
	public int charCount;
	public ArrayList<ObserverInterface> observers;
	
	/* Constructor */
    public Node(String wordIn)
    {
        left = null;
        right = null;
        word = wordIn;
        frequency = 1;
        count = 1;
        charCount = word.length();
        observers = new ArrayList<ObserverInterface>();
        Logger.writeMessage ("In Constructor of Node", Logger.DebugLevel.CONSTRUCTOR);
    }
    
    /* Function to set left node */ 
    public void setLeft(Node leftIn)
    {
        left = leftIn;
    }
    /* Function to set right node */ 
    public void setRight(Node rightIn)
    {
        right = rightIn;
    }
    /* Function to get left node */
    public Node getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public Node getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setFrequency(int freqIn)
    {
        frequency = freqIn;
    }
    /* Function to get frequency of a node */
    public int getFrequency()
    {
        return frequency;
    }     
    /* Function to get word from the node */ 
    public String getWord()
    {
		return word;
	}
    /* Function to set word to the node */ 
	public void setWord(String value)
	{
		this.word = value;
	}
	/* Function to get Count from the node */ 
	public int getCount()
    {
		return count;
	}
    /* Function to set word to the node */ 
	public void setCount(int countIn)
	{
		this.count = countIn;
	}
	/* Function to get Count from the node */ 
	public int getcharCount()
    {
		return charCount;
	}
    /* Function to set word to the node */ 
	public int setcharCount(String wordIn)
	{
		return wordIn.length();
	}
	 /* Function to implement the Clone() */ 
	public Node clone() throws CloneNotSupportedException
	{
		return (Node) super.clone();
	}

	@Override
	public void registerObserver(ObserverInterface obj) {
		// TODO Auto-generated method stub
		observers.add(obj);
	}

	@Override
	public void removeObserver(ObserverInterface obj) {
		// TODO Auto-generated method stub
		observers.remove(obj);
	}

	public void updateBackup()
	{
		notifyObservers();
	}
	@Override
	public void notifyObservers()
	{
		// TODO Auto-generated method stub
		if(observers.size() != 0)
		{
	        for(int i = 0; i < observers.size(); i++)
	        {
	            if(observers.get(i)!= null)
	            {
	            	Node temp = (Node) observers.get(i);
					temp.update(10);
	            }
	        }
	    }
	}

	@Override
	public void update(int increment) {
		// TODO Auto-generated method stub
		this.frequency = frequency+increment;;
	}
	
	
}
