
public class Location
{
	private int locationId;
	private int shelfId;
	private int rownumber;
	
	
	public Location(int locationID, int shelfID, int  rowNumber)
	{
		this.locationId = locationID;
		this.shelfId = shelfID;
		this.rownumber = rowNumber;
		
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public int getShelfId() {
		return shelfId;
	}


	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}


	public int getRownumber() {
		return rownumber;
	}


	public void setRownumber(int rownumber) {
		this.rownumber = rownumber;
	}
	
	
	

}
