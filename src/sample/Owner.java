package sample;

import java.io.Serializable;

/** Represents an Owner of a property.
 *  Each owner has a name, an address, and a numerical ID code to identify them by. 
 */
public abstract class Owner implements Serializable {
	private String name;				// The name of the owner
	private String address;				// The owner's address
	private int ownerID;				// The ID code for the owner
	
	/**
	 * Constructs a new Owner, by providing their name, address and unique ID code.
	 * @param name		The name of the owner which this object is to represent. 
	 * @param address	The address of the owner.
	 * @param ownerID	The unique code to identify this owner in the system.
	 */
	public Owner(String name, String address, int ownerID)
	{
		this.name = name;
		this.address = address;
		this.ownerID = ownerID;
	}
	
	/** Returns the name of this Owner. */
	public String getName()
	{
		return name;
	}
	
	/** Returns the address of this Owner. */
	public String getAddress()
	{
		return address;
	}
	
	/** Returns the unique code to identify this Owner within the system. */
	public int getOwnerID()
	{
		return ownerID;
	}
	
	/** Returns true if this Owner is a Landlord (of a rental property) */
	public abstract boolean isLandlord();
	
	/** Returns true if this Owner is a Seller (of a property) */
	public abstract boolean isSeller();
}
