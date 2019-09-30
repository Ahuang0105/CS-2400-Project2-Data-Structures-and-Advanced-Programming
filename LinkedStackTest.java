/**
 * This class will demonstrates all the required implementation
 * for Task 2, with linked chain stack.
 * @author Alan Huang
 */
public class LinkedStackTest {

	public static void main(String[] args)
	{			
		StackInterface<String> bookPiles = new LinkedBookStack<String>();
					
		System.out.println("*************************************************************************************************************\n");
			
		System.out.println("let's check if the pile is empty right now:  " +"(" +bookPiles.isEmpty() +")" +"\n\n" );
			
		String [] contentsOfBook ={"Rich Dad Poor Dad", "10% Happier", "The Path to Love",
				"Data Structures", "Fuel Injection System", "Peaceful Warrior"  };
		
		testAdd(bookPiles, contentsOfBook);
				
		System.out.println("Which book is on the top now? " +"(" +bookPiles.peek() +")" +"\n\n");
			
		System.out.println("*************************************************************************************************************\n");
			
		System.out.println("We want to remove (Data Structures) from the pile now, "
				+ "but we need to remove all the books on top first. \n");
				
		System.out.println("Let's begin\n");
				
		removeBook(bookPiles, "Data Structures");
				
		System.out.println("Which book is at the top now? " +"(" + bookPiles.peek() +")" +"\n");
			
		System.out.println("*************************************************************************************************************\n");
		
		System.out.println("let's check if the pile is empty right now:  " +"(" +bookPiles.isEmpty() +")" +"\n" );
				
		System.out.println("Let's add a textbook (Starting Out with Java) to the pile\n");
				
		bookPiles.push("Starting Out with Java ");
			
		System.out.println("Which book is at the top now? " +"(" + bookPiles.peek() +")" +"\n");
				
		System.out.println("*************************************************************************************************************\n");
		
		System.out.println("Let's remove all the book from the pile.\n");
		
		bookPiles.clear();
		
		System.out.println("let's check if the pile is empty right now:  " +"(" +bookPiles.isEmpty() +")" +"\n" );;
				
		System.out.println("*************************************************************************************************************\n");
				
	}
	
	/**
	 * This private inner method will save each variable from contentsOfBook array
	 * @param bookPiles the pile I create to store all the books
	 * @param contentsOfBook array that store 6 different books title
	 */
	private static void testAdd(StackInterface<String> bookPiles, String[] contentsOfBook)
	{
	 
		System.out.print("Adding books to the bag: ");
	    	    	
		for (int index= 0; index < contentsOfBook.length; index++)
		{
			bookPiles.push(contentsOfBook[index]);
			System.out.print(" (" +contentsOfBook[index] +") ");
		}//end for
		System.out.println("\n\n");
	}
	
	/**
	 * This private inner method will use peek() to compare each book's name and remove
	 * the right book I want. 
	 * @param bookPiles the stack I create to store all the books
	 * @param bookName a String for the name of book
	 */
	private static void removeBook(StackInterface<String> bookPiles, String bookName)
	{
		if(bookPiles.peek() != null)
		{
			while( bookPiles.peek() != bookName)
            {
		       System.out.println("We are removing" +"(" +bookPiles.peek() +")" +"right now.\n");
			   bookPiles.pop();
		    }
			
			System.out.println("We are removing" +"(" +bookPiles.peek() +")" +"right now.\n");
		   
			bookPiles.pop();
		}
		
		else
		{
			System.out.println("There is no book on the pile");
		}
	}
}
