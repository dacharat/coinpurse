package coinpurse;

/**
 * Cointain money in banknote
 * 
 * @author Dacharat Pankong
 *
 */

public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value of money
	 */
	public BankNote(double value){
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}
	
	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of coin.
	 */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}
	
	/**
     * Get value of banknote.
     * 
     * @return value of banknote.
     */
	public double getValue(){
		return value;
	}
	
	/**
     * Get currency of banknote.
     * 
     * @return currency of banknote. 
     */
	public String getCurrency(){
		return currency;
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
     * Check if two banknote are same value or currency.
     * 
     * @param arg is the object that you want to compare.
     * @return true if they have same value and currency.
     * 		   false if they not same value and currency.	
     */
	public boolean equals(Object arg){
		if(arg == null){
    		return false;
    	}
    	if(arg.getClass()!= this.getClass()){
    		return false;
    	}
    	BankNote other  = (BankNote) arg;
    	return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());
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
