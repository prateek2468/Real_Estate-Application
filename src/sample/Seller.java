package sample;

import java.io.Serializable;

/** Represents a type of owner who is attempting to sell their property. */
public class Seller extends Owner implements Serializable {
	private String conveyancer;
	
	/** Constructs a new Landlord (a type of Owner) by providing their details.
	 * @param name			The name of the Seller which this object is to represent. 
	 * @param address		The address of the Seller.
	 * @param ownerID		The unique code to identify this Seller as an Owner within the system.
	 * @param conveyancer	The name of the conveyancer for this Seller.
	 */ 
	public Seller(String name, String address, int uniqueID, String conveyancer)
	{
		super(name,address,uniqueID);
		this.conveyancer = conveyancer;
	}

	/** Returns the name of the seller's conveyancer. */
	public String getConveyancer()
	{
		return conveyancer;
	}
	
	/** Returns false, since this Object is a Seller, rather than a Landlord, object. */
	public boolean isLandlord()
	{
		return false;
	}
	
	/** Returns true, since this Object is a Seller object. */
	public boolean isSeller()
	{
		return true;
	}

}
