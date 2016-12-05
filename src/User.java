import java.sql.Date;


public class User
{
	private int uid;
	private String name;
	private int isEmployee;
	private int borrowed;
	private Date dob;
	private double fees;
	
	public User(int uID,String name, int isEmployee, int borrowed, Date birthday, double fees)
	{
		this.uid = uID;
		this.name = name;
		this.isEmployee = isEmployee;
		this.borrowed = borrowed;
		this.dob = birthday;
		this.fees = fees;
		
		
	}
	
	public User(Date birthday){
		this.dob = birthday;
	}

	/** this is used for the find users not in employee function in database manager
	 * 
	 * @param uid2 
	 * @param name2
	 */
	public User(int uid2, String name2) {
		// TODO Auto-generated constructor stub
		this.uid = uid2;
		this.name = name2;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(int isEmployee) {
		this.isEmployee = isEmployee;
	}

	public int getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", isEmployee=" + isEmployee + ", borrowed=" + borrowed
				+ ", dob=" + dob + ", fees=" + fees + "]";
	}
	

}
