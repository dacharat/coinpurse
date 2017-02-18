package coinpurse;

import java.util.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Dacharat Pankong
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * 
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		List<Valuable> filteredCoins = new ArrayList<>();
		for(Valuable c : coinlist){
			if(c.getCurrency().equals(currency)){
				filteredCoins.add(c);
			}
		}
		return filteredCoins; 
	}
	

	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * 
	 * @param coins is a List of Coin objects we want to sort. 
	 *
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		Collections.sort(valuable, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
					return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
			}
		});
			
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * 
	 * @param coins is list of coin object.
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		Map<String, Double> map = new HashMap<>();
		for(Valuable money : valuable){
			if(map.containsKey(money.getCurrency())){
				map.put(money.getCurrency(), map.get(money.getCurrency()) + money.getValue());
			} else {
				map.put(money.getCurrency(), money.getValue());
			}
		}
		for(String key : map.keySet()){
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> valuable = makeInternationalCoins();
		int size = valuable.size();
		System.out.print(" INPUT: "); 
		printList(valuable," ");
		List<Valuable> rupees = filterByCurrency(valuable, currency);
		System.out.print("RESULT: "); 
		printList(rupees," ");
		if (valuable.size() != size) 
			System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		valuable = makeInternationalCoins();
		System.out.print(" INPUT: "); 
		printList(valuable," ");
		sortByCurrency(valuable);
		System.out.print("RESULT: "); 
		printList(valuable," ");
		
		System.out.println("\nSum coins by currency");
		valuable = makeInternationalCoins();
		System.out.print("coins= "); 
		printList(valuable," ");
		sumByCurrency(valuable);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) 
			list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) 
				System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}
