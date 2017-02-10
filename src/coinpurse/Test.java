package coinpurse;

public class Test {
	public static void main(String[] args) {
		Coin one = new Coin(1);
		Coin five = new Coin(5);
		Coin malay = new Coin(0.5,"Ringgit");
		System.out.println(one.toString());
		System.out.println(one.compareTo(five));
		System.out.println(five.compareTo(one));
		System.out.println(one.equals(five));
		System.out.println(malay.toString());
		System.out.println(malay.compareTo(one));
	}
}
