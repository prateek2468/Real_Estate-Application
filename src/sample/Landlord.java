package sample;

import java.io.Serializable;

/** Represents a type of Owner who allows another person to rent their property for a fixed rate per week. */
public class Landlord extends Owner implements Serializable {
	private String bankDetails;
	private double weeklyRent;
	
	/** Constructs a new Landlord (a type of Owner) by providing their details.
	 * @param name			The name of the Landlord which this object is to represent. 
	 * @param address		The address of the Landlord.
	 * @param ownerID		The unique code to identify this Landlord as an Owner within the system.
	 * @param bankDetails	The banking details of this Landlord, in the format BSB:AcctNum
	 * @param weeklyRent	The amount of money to pay the Landlord for collected rent each week.
	 */
	public Landlord(String name, String address, int uniqueID, String bankDetails, double weeklyRent)
	{
		super(name,address,uniqueID);
		this.bankDetails = bankDetails;
		this.weeklyRent = weeklyRent;
	}
	
	/** Returns the banking details for the Landlord, in the format  BSB:AcctNum */
	public String getBankDetails()
	{
		return bankDetails;
	}
	
	/** Returns the amount which the Landlord will be paid each week for collected rent. */ 
	public double getWeeklyRent()
	{
		return weeklyRent;
	}
	
	/** Returns true, since this Object is a Landlord object. */
	public boolean isLandlord()
	{
		return true;
	}
	
	/** Returns false, since this Object is a Landlord, rather than a Seller, object. */
	public boolean isSeller()
	{
		return false;
	}
}
