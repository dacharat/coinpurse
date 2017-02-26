package coinpurse;

/**
 * Cointain money in banknote
 * 
 * @author Dacharat Pankong
 *
 */

public class BankNote extends AbstractValuable{
//	private static long nextSerialNumber = 1000000;
//	private double value;
//	private String currency = "Baht";
	private long serialNumber;

	
	
	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of coin.
	 */
	public BankNote(double value, String currency){
		super(value,currency);
	}
	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value of money
	 */
	public BankNote(double value){
		super(value, "Baht");
	}
	
	/**
	 * A banknote with given value , serial number and currency.
	 * @param value of money
	 * @param currency of money
	 * @param serialNumber of money
	 */
	public BankNote(double value, String currency, long serialNumber){
		super(value,currency);
		this.serialNumber = serialNumber;
	}
	/**
	 * Get serial number of banknote.
	 * 
	 * @return serial number of banknote.
	 */
	public long getSerial(){
		return serialNumber;
	}
		
	/**
     * Return the value of banknote and it currency.
     * 
     * @return the value of banknote and it currency.
     */
	public String toString(){
		return value+" - "+currency+ "note ["+serialNumber+"]";
	}





	
}
