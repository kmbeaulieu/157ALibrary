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
	

}
