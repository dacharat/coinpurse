package coinpurse;

import java.util.Comparator;

//A specification needs documentation so that others can use it.

/**
 * An interface for objects having a monetary value and currency.
 * 
 * @author Dacharat Pankong
 *
 */
public interface Valuable {
	public double getValue();
	
	public String getCurrency();
	
	public boolean equals(Object arg);
	
}
