package Auction2;

public class Bid {
	private String bidder;
	private double amount;
	
	public Bid(String bidder, double amount) {
		this.bidder = bidder;
		this.amount = amount;
	}
	
	public String toString() {
		return "Bidder: " + bidder + " $" + amount;
	}
}

