import java.util.*;

/**
 * This class implements the interface StackInterface to 
 * demonstrate how to use linked nodes to store book's
 * to data.
 * @author Alan Huang
 * @param <T>
 */
public class LinkedBookStack <T> implements StackInterface<T>
{
	private Node topNode;       // Reference to first node
	private int numberOfEntries;
	
	/**
	 * Constructor use to initial the topNode to null
	 */
	public LinkedBookStack()
	{
		topNode = null;
	}
	
	/**  Push(add) a new entry to this linkedData Stack.
	 *   @param newEntry  The book to be added as a new entry 
     */
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		
		numberOfEntries++;
	}
	
	/**
	 * This method will remove one book from the 
	 * top of pile. Also return book's name that
	 * has been remove.
	 */
	public T pop()
	{
		T top = peek();
		
		topNode = topNode.getNextNode();
		
		numberOfEntries--;
		
		return top;
	}
	
	/**
	 * This method will check what book is on
	 * top of the stack.
	 */
	public T peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();						
	}
	
	/**
	 * This method will return true is the stack
	 * is empty, and false if it is not.
	 */
	public boolean isEmpty()
	{
		return topNode == null;
	}
	
	/**
	 * This method will remove all the books 
	 * from the stack
	 */
	public void clear()
	{
		topNode = null;
	}
	
	/** 
	 *  a private inner class to created linked node
	 */
	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
		
}
