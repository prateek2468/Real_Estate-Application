package sample;

import java.io.Serializable;

/** Represents a type of Property which is currently for sale. */
public class SaleProperty extends Property implements Serializable {
	//private static final long serialVersionUID = 5230549922091722630L;
	private int price;					// The price that the seller hopes to get for this property
	private double indoorArea;			// The area of the indoors of this property
	
	/** Construct a new SaleProperty, by providing all the details expected.
	 * @param address			The address of the property (excluding the town, just the street address)
	 * @param town				The town/suburb where the property is located
	 * @param propertyID		The unique code to identify this property within the system
	 * @param propertyOwner		A reference to an Owner, being the owner of this property.
	 * @param askingPrice		The price at which the owner hopes to sell the property for
	 * @param indoorArea		The area in square-meters, of the indoor space of the property.
	 */
	public SaleProperty(String address, String town, int propertyID, Owner propertyOwner,int askingPrice, double indoorArea)
	{
		super(address,town,propertyID,propertyOwner);
		this.price = askingPrice;
		this.indoorArea = indoorArea;
	}
	
	/** Returns the price at which the owner hopes to sell the property for. */
	public int getPrice()
	{
		return price;
	}
	
	/** Returns the area of the indoor space of the property, in square-meters. */
	public double getIndoorArea()
	{
		return indoorArea;
	}
	
}
