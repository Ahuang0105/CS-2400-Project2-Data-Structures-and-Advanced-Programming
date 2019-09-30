import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class will implements StackInterface with
 * a resizable array stack
 * @author AlanHuang
 *
 * @param <T>
 */
public class BookStack<T> implements StackInterface<T> {
	private T[] stack; 
	private int topIndex;
	private boolean integrityOK=false;
	private static final int DEFAULT_CAPACITY=5;
	private static final int MAX_CAPACITY=10000;

	/**
	 * Default constructor use to initial the size of my pile
	 */
	public BookStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor I use to create my stack to store books
	 * @param initialCapacity is the starting array size
	 */
	public BookStack(int initialCapacity)
	{
		integrityOK=false; 
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack=tempStack; 
		topIndex=-1;
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
		ensureCapacity();
		
		stack[topIndex+1]=newEntry; 
		topIndex++;
	}
	
	/**
	 * This method will remove one book
	 * form the top of stack
	 */
	public T pop()
	{
		checkIntegrity();
	
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
	
	
		else 
		{
			T top = stack[topIndex];
			stack[topIndex]=null;
			topIndex--;
			return top;
		}
	}
	
	/**
	 * This method will check what book is on
	 * top of the stack
	 */
	public T peek()
	{
		checkIntegrity();
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack[topIndex];
		}

	}
	
	/**
	 * This method will return true is the stack
	 * is empty
	 */
	public boolean isEmpty()
	{
		return topIndex <0;
	}
	
	/**
	 * This method will remove all the books 
	 * from the stack
	 */
	public void clear()
	{
		checkIntegrity();
		
		while(topIndex>-1)
		{
			stack[topIndex]=null;
			topIndex--;
		}	
	}
    
	/**
	 *  This method will check integrity and throw an 
	 *  exception if receiving object is not initialized.
	 */
	public void checkIntegrity()
	{
		if (!integrityOK)
	         throw new SecurityException ("ArrayStack object is corrupt.");	
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
	
	/**
	 * This private inner method will double the total
	 * capacity number if the stack is not big enough
	 * to store all the books
	 */
	private void ensureCapacity()
	{
		if(topIndex >= stack.length-1)
		{
			int newLength = 2*stack.length; 
			checkCapacity(newLength); 
			stack=Arrays.copyOf(stack, newLength); 
		}
	}
	
	
}