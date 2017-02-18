package coinpurse;
/**
 * a coin with a monetary value and currency
 * 
 * @author Dacharat Pankong
 */
public class Coin implements Comparable<Coin>,Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * 
     * @param value is the value of coin.
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * 
     * @param value is the value of coin.
     * @param currency is the currency of coin.
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
    }

    /**
     * Get value of coin.
     * 
     * @return value of coin.
     */
    public double getValue( ) { 
    	return value;
    } 
    
    /**
     * Get currency of coin.
     * 
     * @return currency of coin. 
     */
    public String getCurrency() { 
    	return currency;
    }
    
    /**
     * Check if two coins are same value or currency.
     * 
     * @param arg is the object that you want to compare.
     * @return true if they have same value and currency.
     * 		   false if they not same value and currency.	
     */
    public boolean equals(Object arg) {
    	if(arg == null){
    		return false;
    	}
    	if(arg.getClass()!= this.getClass()){
    		return false;
    	}
    	Coin other  = (Coin) arg;
    	return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());
    	
    }
    
    /**
     * 
     * 
     * @param c is the object that you want to compare.
     * @return -1 if the object is null or this coin less is than other coin.
     * 		    1 if this coin more than other coin.
     * 		    0 if 2 coin are equal.	 
     */
    @Override
    public int compareTo(Coin c){
    	if(c == null){
    		return -1;
    	}
    	if(this.value>c.value){
    		return 1;
    	}
    	if(this.value<c.value){
    		return -1;
    	}
    	return 0;
    }
    
    /**
     * Return the value of coin and it currency.
     * 
     * @return the value of coin and it currency.
     */
    @Override
    public String toString() { 
    	return this.value+" - "+this.currency; 
    }
    
    
}

