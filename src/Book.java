
import java.util.ArrayList;


public class Book
{
	private int bookId;
	private String title;
	private String author;
	private int copies;
	private int locationId;
	private int borrowed;

	public Book(int bookID, String title, String author, int copies, int locationID)
	{
		this.bookId = bookID;
		this.title = title;
		this.author = author;
		this.copies = copies;
		this.locationId = locationID;
		
		
		
	}

	//this is for the grouped by books. It needs the count int. Just use the copies to store this value.
	public Book(String title2, String author2, Integer count) {
		// TODO Auto-generated constructor stub
		this.title =title2;
		this.author = author2;
		this.borrowed =count;
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

	public int getBorrowed() {
		return borrowed;
	}
	
	
	
	
}
