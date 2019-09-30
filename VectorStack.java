import java.util.EmptyStackException;
import java.util.Vector;

/**
 * This class implements the interface StackInterface to 
 * demonstrate how to use vector stack to store book's
 * to data.
 * @author Alan Huang
 * @param <T>
 */
public final class VectorStack<T> implements StackInterface<T> 
{
	private Vector<T> stack;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY=5;
	private static final int MAX_CAPACITY=10000;
	
	/**
	 * Default constructor use to initial the size of my vector stack
	 */
	public VectorStack()
	{
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor I use to create my stack to store books
	 * @param initialCapacity is the starting vector stack size
	 */
	public VectorStack(int initialCapacity)
	{
		integrityOK=false;
		checkCapacity(initialCapacity);
		stack = new Vector<>(initialCapacity);
		integrityOK=true;
	}
	
	/**
	 * This method will add books to the top of 
	 * stack and increase size if the stack is full
	 * @param newEntry the new book that I am adding
	 * to the stack
	 */
	public void push(T newEntry)
	{
		checkIntegrity();
		stack.add(newEntry);
	}
	
	/**
	 * This method will remove one book
	 * form the top of stack
	 */
	public T pop()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else 
			return stack.remove(stack.size()-1);
	}
	
	/**
	 * This method will check what book is on
	 * top of the stack
	 */
	public T peek()
	{
		checkIntegrity();
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
			return stack.lastElement();
	}
	
	/**
	 * This method will return true is the stack
	 * is empty
	 */
	public boolean isEmpty()
	{
		checkIntegrity();
		return stack.isEmpty();
	}
	
	/**
	 * This method will remove all the books 
	 * from the stack
	 */
	public void clear()
	{
		checkIntegrity();
		stack.clear();
	}
	
	/**
	 *  This method will check integrity and throw an 
	 *  exception if receiving object is not initialized.
	 */
	public void checkIntegrity()
	{
		if (!integrityOK)
	         throw new SecurityException ("VectorStack object is corrupt.");	
	}
	
	/**
	 * This private method will ensure the capacity will
	 * not pass MAX_CAPACITY
	 * @param capacity the current total entries
	 */
	private void checkCapacity(int capacity)
	{
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a stack whose capacity exceeds " +
			                                         "allowed maximum of " + MAX_CAPACITY);
	}

}
