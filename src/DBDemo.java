import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class demonstrates how to connect to MySQL and run some basic commands.
 * 
 * In order to use this, you have to download the Connector/J driver and add
 * its .jar file to your build path.  You can find it here:
 * 
 * http://dev.mysql.com/downloads/connector/j/
 * 
 * You will see the following exception if it's not in your class path:
 * 
 * java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
 * 
 * To add it to your class path:
 * 1. Right click on your project
 * 2. Go to Build Path -> Add External Archives...
 * 3. Select the file mysql-connector-java-5.1.24-bin.jar
 *    NOTE: If you have a different version of the .jar file, the name may be
 *    a little different.
 *    
 * The user name and password are both "root", which should be correct if you followed
 * the advice in the MySQL tutorial. If you want to use different credentials, you can
 * change them below. 
 * 
 * You will get the following exception if the credentials are wrong:
 * 
 * java.sql.SQLException: Access denied for user 'userName'@'localhost' (using password: YES)
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

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "library";
	
	
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

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);
		
		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void run() {

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

		// Create user tables
		try {
			//drop table if exists so we dont run into problems being able to create it.
			this.executeUpdate(conn, "DROP TABLE IF EXISTS USER");
			System.out.println("drop table if exists user executed");
			
		    String createString =
			        "CREATE TABLE " + this.userTableName + " ( " +
			        "UID INTEGER NOT NULL, " +
			        "NAME VARCHAR(30), " +
			        "ISEMPLOYEE TINYINT DEFAULT 0, " +
			        "BORROWED INT DEFAULT 0, " +
			        "BIRTHDATE DATE DEFAULT '0000-00-00', " +
			        "FEES DOUBLE DEFAULT 0.0, " +
			        "UPDATEDON TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,"+ 
			        "CHECK(ISEMPLOYEE<2), "+
			        "PRIMARY KEY (UID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a " + this.userTableName + " table");
			//do the increment for user
			this.executeUpdate(conn, "ALTER TABLE USER AUTO_INCREMENT = 1");
			System.out.println("altered user table to increment from 1.");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not create the "+ this.userTableName+ " table");
			e.printStackTrace();
			return;
		}
//		
//		// Drop the user table KEEP THIS FOR FUTURE REFERENCE BUT THIS IS CURRENTLY NOT NEEDED IF THERE IS THE DROP IF... STATEMENT PER TABLE
//		try {
//		    String dropString = "DROP TABLE " + this.userTableName;
//			this.executeUpdate(conn, dropString);
//			System.out.println("Dropped the " +this.userTableName+" table");
//	    } catch (SQLException e) {
//			System.out.println("ERROR: Could not drop the "+this.userTableName+" table");
//			e.printStackTrace();
//			return;
//		}
		
		// Create loan tables
				try {
					//drop table if exists so we dont run into problems being able to create it.
					this.executeUpdate(conn, "DROP TABLE IF EXISTS LOAN");
					System.out.println("drop table if exists loan executed");
					
				    String createString =
					        "CREATE TABLE " + this.loanTableName + " ( " +
					        "LOANID INTEGER AUTO_INCREMENT, " +
					        "UID INT, " +
					        "BOOKID INT, " +
					        "CHECKOUTDATE DATE DEFAULT '0000-00-00', " +
					        "DUEDATE DATE DEFAULT '0000-00-00', " +
					        "OVERDUE TINYINT DEFAULT 0, " +
					        "CHECK(OVERDUE<2), " +
					        "PRIMARY KEY (LOANID), " +
					        "FOREIGN KEY (UID) references USER (UID))";
				    //TODO make a foreign key for bookid after book is made
					this.executeUpdate(conn, createString);
					System.out.println("Created a " + this.loanTableName + " table");
					
					this.executeUpdate(conn, "ALTER table LOAN AUTO_INCREMENT = 1001");
					System.out.println("LOAN table now increments starting at 1001.");

			    } catch (SQLException e) {
					System.out.println("ERROR: Could not create the "+ this.loanTableName+ " table");
					e.printStackTrace();
					return;
				}
	}
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DBDemo app = new DBDemo();
		app.run();
	}
}