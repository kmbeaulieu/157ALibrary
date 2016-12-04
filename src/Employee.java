import java.util.Date;


public class Employee
{
	private int employeeID;
	private int uid;
	private String department;
	private String name;
	private Date joinDate;
	private int employeePIN;
	public Employee(int employeeID, int uID, String department, String name, Date joinDate, int employeePIN)
	{
		this.employeeID = employeeID;
		this.uid = uID;
		this.department = department;
		this.name = name;
		this.joinDate = joinDate;
		this.employeePIN = employeePIN;
		
		
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getEmployeePIN() {
		return employeePIN;
	}
	public void setEmployeePIN(int employeePIN) {
		this.employeePIN = employeePIN;
	}

	
}
