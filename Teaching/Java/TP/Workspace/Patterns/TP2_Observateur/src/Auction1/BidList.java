package Auction1;

import java.util.Observable;

public class BidList extends Observable {

	private Bid latestBid;

	public Bid getBid() {
		return latestBid;
	}

	public void submitBid(Bid latestBid) {
		this.latestBid = latestBid;
		setChanged();
		//notifyObservers();		
	}
}
