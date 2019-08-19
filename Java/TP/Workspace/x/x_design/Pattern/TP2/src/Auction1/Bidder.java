package Auction1;
/**
 * Bidder.java
 *
 * Bidders to the auction. They register themselves with the
 * auction so that they are notified when the state of the 
 * auction has changed. (i.e. someone has put out a higher bid)
 */

import java.util.Observer;
import java.util.Observable;

public class Bidder implements Observer {
	private Observable auction;
	private Bid latestBid;
	
	public Bidder(Observable auction) {
		this.auction = auction;
		auction.addObserver(this);
	}

	// this is invoked when the state of the auction has changed
	// this uses the "pull" approach of getting the new state
	// the subject.
	public void update(Observable subject, Object newState) {
		BidList bidList = (BidList)subject;
		latestBid = bidList.getBid();

		display(latestBid);
	}
	
	public void display(Bid latestBid) {
		System.out.println("The latest bid is " + latestBid);
	}
}
