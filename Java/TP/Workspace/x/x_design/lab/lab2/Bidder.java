/**
 * Bidder.java
 *
 * Bidders to the auction. They register themselves with the
 * auction so that they are notified when the state of the 
 * auction has changed. (i.e. someone has put out a higher bid)
 */

public class Bidder implements Observer {
	private Subject auction;
	
	public Bidder(Subject auction) {
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
