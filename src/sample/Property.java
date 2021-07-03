package sample;


import java.io.Serializable;

/**
 * This class represents a Property within the real-estate system.
 * Every property needs to have a unique ID code that is different from other properties.
 * Every property should also have an Owner that exists in the system's list of owners.
 */
public abstract class Property implements Serializable {
	private String address;					// The address (excluding town) where the property is located
	private String town;					// The town where the property is located
	private int propertyID;					// A unique code to identify this property within the system
	private Owner propertyOwner;			// A Reference to the Owner who owns this property 
	
	
	/** Constructs a new Property, by providing the address and town and unique code to identify the property,
	 * in addition to a reference to the Owner of the property.
	 * @param address			The address of the property (excluding the town, just the street address)
	 * @param town				The town/suburb where the property is located
	 * @param propertyID		The unique code to identify this property within the system
	 * @param propertyOwner		A reference to an Owner, being the owner of this property.
	 */
	public Property(String address, String town, int propertyID, Owner propertyOwner)
	{
		this.address = address;
		this.town = town;
		this.propertyID = propertyID;
		this.propertyOwner = propertyOwner;
	}
	
	/** Returns the street address for this property. */
	public String getAddress()
	{
		return address;
	}
	
	/** Returns the town in which the property is located. */
	public String getTown()
	{
		return town;
	}
	
	/** Returns the unique code used to identify this Property. */
	public int getPropertyID()
	{
		return propertyID;
	}
	
	/** Returns a reference to the owner of this Property. */
	public Owner getPropertyOwner()
	{
		return propertyOwner;
	}
}