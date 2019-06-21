package Auction1;

import java.util.Observer;
import java.util.Observable;

public class Bidder implements Observer {
	private Observable auction;
	private Bid latestBid;
	
	public Bidder(Observable auction) {
		this.auction = auction;
		//auction.addObserver(this);
	}

	public void update(Observable subject, Object newState) {
		this.latestBid = ((BidList)subject).getBid();
		System.out.println("The latest bid is " + latestBid);
	}

}
