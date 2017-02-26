package coinpurse;

public abstract class AbstractValuable implements Valuable {

	protected double value;

	protected String currency;

	public AbstractValuable(double value) {
		this.value = value;
		this.currency = "Baht";
	}

	/**
	 * Constructs a AbstractValuable with a value and currency.
	 * 
	 * @param value
	 *            is the value of money.
	 * @param currency
	 *            is the currency of money.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Check two valuable is equal or not.
	 * 
	 * @param arg
	 *            the object that you want to check.
	 * @return true if they are same value and currency 
	 * 		   false if they are not.
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}
		if (arg.getClass() != this.getClass()) {
			return false;
		}
		Valuable other = (Valuable) arg;
		return other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency());

	}

	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare this valuable and another by value and currency.
	 * 
	 * @param other
	 *            is valuable to compare.
	 * @return 1 if this coin more than other, -1 if this coin less than other,
	 *         0 if this coin equals other.
	 */
	@Override
	public int compareTo(Valuable other) {
		if (this.getCurrency().equals(other.getCurrency())) {
			if (this.getValue() > other.getValue())
				return 1;
			else if (this.getValue() < other.getValue())
				return -1;
			else
				return 0;
		} else
			return this.getCurrency().compareToIgnoreCase(other.getCurrency());
	}

}
