package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
 

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Dacharat Pankong
 */
public class Purse {
	
    /** Collection of objects in the purse. */
	private List<Coin> money;
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	this.money = new ArrayList<>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * 
     * @return the number of coins in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double balance = 0;
    	for(Coin c : this.money){
    		balance += c.getValue();
    	}
    	return balance; 
    }

    
    /**
     * Return the capacity of the coin purse.
     * 
     * @return the capacity
     */
    public int getCapacity() { 
    	return this.capacity;
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if(this.count() >= this.capacity){
        	return true;
        }
        return false;
    	
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * 
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
    	if(coin.getValue() <= 0){
    		return false;
    	} else {
    		money.add(coin);
    	}
    	return true;
        
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	if (amount < 0) {
			return null;
		}
		double moneyLeft = amount;
		List<Coin> tempList = new ArrayList<Coin>();
		if (amount > 0) {
			Collections.sort(money);
			Collections.reverse(money);
			for (int i = 0; i < money.size(); i++) {
				if (moneyLeft - money.get(i).getValue() >= 0) {
					moneyLeft = moneyLeft - money.get(i).getValue();
					tempList.add(money.get(i));
					if (moneyLeft == 0) {
						break;
					}
				}
			}
		}
		if (moneyLeft == 0) {
			for (Coin coin : tempList) {
				money.remove(coin);
			}
			Coin[] arrayCoin = new Coin[tempList.size()];
			tempList.toArray(arrayCoin);
			return arrayCoin;
		}
        return null;
	   
        
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    @Override
    public String toString() {
    	return this.money.size()+" coins with value "+ this.getBalance();
    }

}

