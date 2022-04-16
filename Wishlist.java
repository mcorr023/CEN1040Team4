import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Wishlist {
	
	static ArrayList<String> bookList = new ArrayList<String>();
	static ArrayList<String> bookWishList = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		
		store();
		
	}
	
	public static void store() {
		
		boolean exit = false;
		
		while(!exit) {
			
			Object[] options = {"Add Book", "Remove Book", "Add To Wishlist", "Remove From Wishlist", "See Book List", "See Wishlist", "Close"};
			int result = JOptionPane.showOptionDialog(null, "Welsome To The Book Store?", "Select Option",
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[6]);
		    
			switch (result) {
		       case 0:
		    	   addBook();
		    	   break;
		         
		       case 1:
		    	   removeBook();
		    	   break;
		         
		       case 2:
		    	   addBookToWishlist();
		    	   break;
			     
		       case 3:
		    	   removeBookFromWishlist();
		    	   break;
		         
		       case 4:
		    	   seeList();
		    	   break;
		       
		       case 5:
		    	   seeWishList();
			       break;
			       
		       default:
					exit = true;
					break;
		       }
			
		}
	}
	
	public static void addBook() {
		
		String nameOfBook = JOptionPane.showInputDialog("Add Name of Book: ");
		bookList.add(nameOfBook);
	}
	
	public static void removeBook() {
		
		String[] options = new String[bookList.size()];
		
		for(int i = 0; i < bookList.size(); i++) {
			options[i] = bookList.get(i);
		}
		
		String bookToRemove = (String)JOptionPane.showInputDialog(null, "Which Book to Remove from List", "Select Book", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		bookList.remove(bookToRemove);
		
	}
	
	public static void addBookToWishlist() {
		
		String[] options = new String[bookList.size()];
		
		for(int i = 0; i < bookList.size(); i++) {
			options[i] = bookList.get(i);
		}
		
		String bookToAdd = (String)JOptionPane.showInputDialog(null, "Which Book to Add to Wishlist", "Select Book", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		bookWishList.add(bookToAdd);
		
	}
	
	public static void removeBookFromWishlist() {
		
		String[] options = new String[bookWishList.size()];
		
		for(int i = 0; i < bookWishList.size(); i++) {
			options[i] = bookWishList.get(i);
		}
		
		String bookToRemove = (String)JOptionPane.showInputDialog(null, "Which Book to Remove from Wishlist", "Select Book", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		bookWishList.remove(bookToRemove);
		
	}
	
	public static void seeList() {
			
			String list = "";
			for(int i = 0; i < bookList.size(); i++) {
				list += bookList.get(i) + "\n";
			}
			
			JOptionPane.showMessageDialog(null, list);
			
		}
	
	public static void seeWishList() {
		
		String list = "";
		for(int i = 0; i < bookWishList.size(); i++) {
			list += bookWishList.get(i) + "\n";
		}
		
		JOptionPane.showMessageDialog(null, list);
		
	}
	
}