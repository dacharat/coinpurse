package coinpurse;

public abstract class MoneyFactory { 
	
	private static MoneyFactory theMoneyFactory = null;
		
	public static long nextSerialNumber = 1000000;
	
	protected MoneyFactory(){
		
	}
	
	/**
	 * Get instance of MoneyFactory. 
	 * 
	 * @return MoneyFactory instance.
	 */
	public static MoneyFactory getInstance(){
		if(theMoneyFactory == null){
			theMoneyFactory = new ThaiMoneyFactory();
		}
		return theMoneyFactory;
	}
	
	/**
	 * Create new money object.
	 * 
	 * @param value is the value you want to create.
	 * @return the Value of object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Create money by its value in String.
	 * 
	 * @param value is value you want to create.
	 * @return a Valuable of object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	public Valuable createMoney(String value) {
		double doubleValue = Double.parseDouble(value);
		return this.createMoney(doubleValue);
	}
	
	/**
	 * Set MoneyFactory.
	 * 
	 * @param factory is subclass of MoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory){
		theMoneyFactory = factory;
	}
}
