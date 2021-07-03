package sample;

import java.io.Serializable;

/** Represents a type of Property which is being rented by a tenant. */
public class RentalProperty extends Property implements Serializable {

	private String tenantName;
	private String tenantPhone;

	/** Constructs a new RentalProperty object by providing all the details for the new object.
	 * @param address			The address of the RentalProperty (excluding the town, just the street address)
	 * @param town				The town/suburb where the property is located
	 * @param propertyID		The unique code to identify this property within the system
	 * @param propertyOwner		A reference to an Owner, being the owner of this property.
	 * @param tenantName		The name of the main tenant at this rental property
	 * @param tenantPhone		The phone number of the main tenant at this rental property.
	 */
	public RentalProperty(String address, String town, int propertyID, Owner propertyOwner, String tenantName, String tenantPhone)
	{
		super(address,town,propertyID,propertyOwner);
		this.tenantName = tenantName;
		this.tenantPhone = tenantPhone;
	}
	
	/** Returns the name of the (main) tenant living at this property. */
	public String getTenantName()
	{
		return tenantName;
	}
	
	/** Return the phone number for the named tenant living at this property. */
	public String getTenantPhone()
	{
		return tenantPhone;
	}
}
