import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;

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
	private final String password = "fion1994";

	/** The name of the computer running MySQL */
	private final String serverName = "127.0.0.1";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3307;

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
	private void disconnect() {
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
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
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


	private void insertUser(String name, Date birthday) {
		Connection conn = null;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO user (name, birthday) VALUES (?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setDate(2, birthday);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("UNABLE TO INSERT USER");
			e.printStackTrace();
		}
	}


	public int selectUser(String name, Date birthday) {
		Connection conn = null;
		int uID = 0;
		try {
			conn = this.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM user WHERE name = ? AND birthday = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setDate(2, birthday);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				uID = rs.getInt("uid");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uID;
	}
	
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
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Make a window. connect to the database. Connect to the DB and do some
	 * stuff
	 */
	public static void main(String[] args) {
		Homepage hp = new Homepage();
		hp.setVisible(true);

	}
}