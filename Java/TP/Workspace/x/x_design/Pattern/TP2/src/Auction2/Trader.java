package Auction2;

public class Trader implements Observer {
	private Subject auction;
	
	public Trader(Subject auction) {
		this.auction = auction;
		auction.addObserver(this);
	}

	// this is invoked when the state of the auction has changed
	public void update(Object newState) {
		Bid latestBid = (Bid)newState;
		display(latestBid);
	}
	
	public void display(Bid latestBid) {
		System.out.println("The latest bid is " + latestBid);
	}
}
