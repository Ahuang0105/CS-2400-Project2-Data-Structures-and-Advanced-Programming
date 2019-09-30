/** I use this interface to transfer all method from BookStack 
 *  and LinkedBookStack to implemented the the action for push 
 *  and pop books from the pile. 
 *  @author Alan Huang
 *  @param <T>
 */
public interface StackInterface<T> 
{
	/**
	 *  Adds new entry to top of the stack	
	 * @param newEntry a book we are try to add to the Stack
	 */
	public void push(T newEntry);
	
	/**		
	 * Removes the book from top of the
	 * Stack	
	 * @return True if the remove process is complete
	 */
	public T pop();
	
	/** 
	 * Retrieves this stack's top book's name
	 * @return The book's name on top of the stack
	 */
	public T peek();
	
	/**
	 * Check if there is any book in the stack
	 * @return True if the stack in empty
	 */
	public boolean isEmpty();
	
	/**
	 * Remove all the books from stack
	 */
	public void clear();
	
}