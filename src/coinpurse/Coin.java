package coinpurse;
/**
 * a coin with a monetary value and currency
 * 
 * @author Dacharat Pankong
 */
public class Coin extends AbstractValuable{
	//public static final String DEFAULT_CURRENCY = "Baht";

    /**
     * A coin with given value using the default currency.
     * 
     * @param value is the value of coin.
     */
    public Coin(double value) {
        super(value,"Baht");
    }
    
    /**
     * A coin with given value and currency.
     * 
     * @param value is the value of coin.
     * @param currency is the currency of coin.
     */
    public Coin( double value, String currency ) {
    	super(value,currency);
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

