import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JFrame;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add its
 * .jar file to your build path. You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for
 * jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path: 1. Right click on your project 2. Go to Build
 * Path -> Add External Archives... 3. Select the file
 * mysql-connector-java-5.1.24-bin.jar NOTE: If you have a different version of
 * the .jar file, the name may be a little different.
 * 
 * The user name and password are both "root", which should be correct if you
 * followed the advice in the MySQL tutorial. If you want to use different
 * credentials, you can change them below.
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using
 * password: YES)
 * 
 * You will instead get the following exception if MySQL isn't installed, isn't
 * running, or if your serverName or portNumber are wrong:
 * 
 * java.net.ConnectException: Connection refused
 */
public class DBDemo {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;


	/**
	 * The name of the database we are testing with (this default is installed
	 * with MySQL)
	 */
	private final String dbName = "libraryProject";

	/** The name of the tables we are using */
	private final String userTableName = "USER";
	private final String loanTableName = "LOAN";
	private final String bookTableName = "BOOK";
	private final String locationTableName = "LOCATION";
	private final String employeeTableName = "EMPLOYEE";
	private final String archiveTableName = "ARCHIVE";

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		conn = DriverManager.getConnection(
				"jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName, connectionProps);
		return conn;
	}

	/**
	 * Closes connection to database
	 */
	public void disconnect() {
		Connection conn = null;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it
											// fails
			return true;
		} finally {
			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Connect to MySQL and get all users!
	 * 
	 * @throws SQLException
	 */
	public void run() throws SQLException {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		String testQuery = "SELECT * FROM user";
		Statement ts = conn.createStatement();
		ResultSet rs = ts.executeQuery(testQuery);
		while (rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("name");
			int isEmployee = rs.getInt("isEmployee");
			int borrowed = rs.getInt("borrowed");
			Date birthday = rs.getDate("birthday");
			Double fees = rs.getDouble("fees");
			Timestamp updatedOn = rs.getTimestamp("updatedOn");

			System.out.format("%s,%s,%s,%s,%td,%s,%s%n", uid, name, isEmployee, borrowed, birthday, fees,
					updatedOn.toString());
		}
		ts.close();
	}

	/* ------------- USER METHODS --------------- */

	// Creating a new user in user table
	public void insertUser(String name, Date birthday) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("INSERT INTO user (name, birthday) VALUES (?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setDate(2, birthday);

			preparedStatement.execute();
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT USER");
			e.printStackTrace();
			
		}
	}

	// --- NEED TO CHANGE FROM VOID TO RETURN USER OBJECT!
	public User selectUser(String name, Date birthday) {
		User user = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"SELECT uID, name, birthday, borrowed, fees FROM user WHERE name = ? AND birthday = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setDate(2, birthday);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int uID = rs.getInt("uID");
				String userName = rs.getString("name");
				Date userBirthday = rs.getDate("birthday");
				int userBorrowed = rs.getInt("borrowed");
				double userFees = rs.getDouble("fees");
				user = new User(uID, userName, 0, userBorrowed, userBirthday, userFees);// 0 for isEmployee
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT USER");
			e.printStackTrace();
		}
		return user;
	}

	// Update user's name in user table
	public void updateUser(int uID, String name) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("UPDATE FROM user SET name = ? WHERE uID = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, uID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete user from user table
	public void deleteUser(int uID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM user WHERE uID = ?");
			preparedStatement.setInt(1, uID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* ------------- LOAN METHODS --------------- */

	// Inserting a new loan into loan table
	public void insertLoan(int uID, int bookID, Date checkoutDate, Date dueDate, int overdue) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Get the current date
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		checkoutDate = sqlDate;

		// Get the due date
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(utilDate);
		gc.add(Calendar.YEAR, 7);
		java.sql.Date sqlDueDate = new java.sql.Date(gc.getTime().getTime());

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO loan (uID, bookID, checkoutDate, dueDate, overdue) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, uID);
			preparedStatement.setInt(2, bookID);
			preparedStatement.setDate(3, checkoutDate);
			preparedStatement.setDate(4, dueDate);
			preparedStatement.setInt(5, overdue);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT LOAN");
			e.printStackTrace();
		}
	}

	// --- NEED TO CHANGE FROM VOID TO RETURN USER OBJECT!
	public Loan selectLoan(int loanID) {
		Connection conn = null;
		Loan currentLoan = new Loan(0, 0, 0, null, null, 0);
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"SELECT loanID, uID, bookID, checkoutDate, dueDate, overdue FROM loan WHERE loanID = ? AND uID = ?");
			preparedStatement.setInt(1, loanID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int lID = rs.getInt("loanID");
				currentLoan.setLoanID(lID);
				
				int loanUID = rs.getInt("uID");
				currentLoan.setUserID(loanUID);
				
				int loanBookID = rs.getInt("bookID");
				currentLoan.setBookID(loanBookID);
				
				Date checkoutDate = rs.getDate("checkoutDate");
				currentLoan.setCheckoutDate(checkoutDate);
				
				Date dueDate = rs.getDate("dueDate");
				currentLoan.setDueDate(dueDate);
				
				int overdue = rs.getInt("overdue");
				currentLoan.setOverdue(overdue);
			}
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT LOAN");
			e.printStackTrace();
		}
		
		return currentLoan;
	}

	// Delete a loan
	public void deleteLoan(int loanID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM loan WHERE loanID = ?");
			preparedStatement.setInt(1, loanID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Extend loan due date
	public void extendDueDate(int loanID) {
		selectLoan(loanID);
		
		
		
	}
	
	// Update overdue = 1 if there is an overdue
	public void checkOverdue(int loanID) {
		selectLoan(loanID);
		
	}

	/* ------------- BOOK METHODS --------------- */

	// Inserting a new book into book table
	public void insertBook(String title, String author, int copies, int locationID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("INSERT INTO book (title, author, copies, locationID) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, copies);
			preparedStatement.setInt(4, locationID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT BOOK");
			e.printStackTrace();
		}
	}

	// ---------- NEED TO CHANGE FROM VOID TO RETURN BOOK OBJECT
	public void selectBook(int bookID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("SELECT bookID, title, author, copies, locationID FROM book WHERE bookID = ?");
			preparedStatement.setInt(1, bookID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int bID = rs.getInt("bookID");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int copies = rs.getInt("copies");
				int locationID = rs.getInt("locationID");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT BOOK");
			e.printStackTrace();
		}

	}

	// Update all the attributes of the book in book table
	public void updateBook(String title, String author, int copies, int locationID, int bookID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"UPDATE FROM book SET title = ?, author = ?, copies = ?, locationID = ? WHERE bookID = ?");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, copies);
			preparedStatement.setInt(4, locationID);
			preparedStatement.setInt(5, bookID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO UPDATE BOOK");
			e.printStackTrace();
		}
	}

	// Delete book from book table
	public void deleteBook(int bookID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM book WHERE bookID = ?");
			preparedStatement.setInt(1, bookID);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO DELETE BOOK");
			e.printStackTrace();
		}
	}

	// Search book using title
	public ArrayList<Book> searchBookTitle(String title) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = null;
			if(title.isEmpty())
			{
			
				 preparedStatement = conn
						.prepareStatement("SELECT bookID, title, author, copies, locationID FROM book");
				
			}
			else
			{
				preparedStatement = conn
					.prepareStatement("SELECT bookID, title, author, copies, locationID FROM book WHERE title = ?");
				preparedStatement.setString(1, title);
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int bookID = rs.getInt("bookID");
				String bookTitle = rs.getString("title");
				String bookAuthor = rs.getString("author");
				int copies = rs.getInt("copies");
				int locationID = rs.getInt("locationID");
				Book book = new Book(bookID, bookTitle, bookAuthor, copies, locationID);
				books.add(book);
				
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT BOOK");
			e.printStackTrace();
		}
		return books;
	}

	/* ------------- EMPLOYEE METHODS --------------- */

	// Creating a new user in user table
	public void insertEmployee(int uID, String department, String name, Date joinDate, int PIN) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Get the current date
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		joinDate = sqlDate;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO employee (uID, department, name, joinDate, employeePIN) VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, uID);
			preparedStatement.setString(2, department);
			preparedStatement.setString(3, name);
			preparedStatement.setDate(4, joinDate);
			preparedStatement.setInt(5, PIN);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT EMPLOYEE");
			e.printStackTrace();
		}
	}

	// ---------- NEED TO CHANGE FROM VOID TO RETURN USER OBJECT!
	// Gets all the attributes from the employee
	public void selectEmployee(String name, String department) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"SELECT employeeID, uID, department, name, joinDate, employeePIN FROM employee WHERE name = ? AND department = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, department);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int employeeID = rs.getInt("employeeID");
				int userID = rs.getInt("uID");
				String employeeDepartment = rs.getString("department");
				String employeeName = rs.getString("name");
				Date employeeJoinDate = rs.getDate("joinDate");
				int employeePIN = rs.getInt("employeePIN");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT EMPLOYEE");
			e.printStackTrace();
		}
	}

	// Update employee attributes in employee table
	public void updateEmployee(int employeeID, String name, String department, int employeePIN) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"UPDATE FROM employee SET name = ?, department = ?, employeePIN = ? WHERE employeeID = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, department);
			preparedStatement.setInt(3, employeePIN);
			preparedStatement.setInt(4, employeeID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO UPDATE EMPLOYEE");
			e.printStackTrace();
		}
	}

	// Delete employee from employee table
	public void deleteEmployee(int employeeID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM employee WHERE employeeID = ?");
			preparedStatement.setInt(1, employeeID);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Employee update user's fee in user table
	public void updateUserFees(int uID, int fees) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("UPDATE FROM user SET fees = ? WHERE uID = ?");
			preparedStatement.setInt(1, uID);
			preparedStatement.setInt(2, fees);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* ------------- LOCATION METHODS --------------- */
	
	// Creating a new location in location table
	public void insertLocation(int shelfID, int rowNumber) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO location (shelfID, rowNumber) VALUES (?, ?)");
			preparedStatement.setInt(1, shelfID);
			preparedStatement.setInt(2, rowNumber);

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT LOCATION");
			e.printStackTrace();
		}
	}
	
	// ---------- NEED TO CHANGE FROM VOID TO RETURN LOCATION OBJECT!
	// Get location info
	public void selectLocation(int bookID) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("SELECT locationID, shelfID, rowNumber FROM location WHERE bookID = ?");
			preparedStatement.setInt(1, bookID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int locationID = rs.getInt("locationID");
				int shelfID = rs.getInt("shelfID");
				int rowNumber = rs.getInt("rowNumber");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO SELECT LOCATION");
			e.printStackTrace();
		}
	}

	/**
	 * Make a window. connect to the database. Connect to the DB and do some
	 * stuff
	 */
	public static void main(String[] args) {
		MainMenuPage hp = new MainMenuPage();
		hp.setVisible(true);

	}
}