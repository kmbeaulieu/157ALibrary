import java.sql.Date;

public class Loan {
	private int loanID;
	private int userID;
	private int bookID;
	private Date checkoutDate;
	private Date dueDate;
	private int overdue;

	public Loan(int lID, int uID, int bID, Date checkout, Date duedate, int Overdue) {
		loanID = lID;
		userID = uID;
		bookID = bID;
		checkoutDate = checkout;
		dueDate = duedate;
		overdue = Overdue;
	}

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	
}
