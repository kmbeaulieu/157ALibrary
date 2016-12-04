
import java.util.ArrayList;


public class Book
{
	private int bookId;
	private String title;
	private String author;
	private int copies;
	private int locationId;

	public Book(int bookID, String title, String author, int copies, int locationID)
	{
		this.bookId = bookID;
		this.title = title;
		this.author = author;
		this.copies = copies;
		this.locationId = locationID;
		
		
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	
	
}
