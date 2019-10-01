package Auction1;
/**
 * BidList.java
 *
 * This manages an auction whereby bidders register themselves
 * and  are notified when a bid is made.
 */

import java.util.Observable;
import java.util.Observer;

public class BidList extends Observable {
	private Bid latestBid;
	
	public BidList () { }

	/**
	 * Observers will call this to pull the latest bid.
	 */
	public Bid getBid() {
		return latestBid;
	}

	/* bidders invoke this method when they submit a bid */	
	public void submitBid(Bid latestBid) {
		this.latestBid = latestBid;

		 /* 
		 * we must first call setChanged() to indicate
		 * that the state has changed and then we
		 * call notifyObservers() in the parent class
		 * which notifes all observers that the state
		 * has changed.
		 */
		setChanged();
		notifyObservers();		
	}
}
