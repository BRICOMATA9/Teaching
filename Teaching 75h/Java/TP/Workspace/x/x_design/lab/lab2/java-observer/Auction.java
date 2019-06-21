/**
 * Auction.java
 *
 * Provide an auction whereby bidders register with the BidList.
 * Bidders may then submit bids and all bidders are notified when 
 * a bid is made.
 */

public class Auction {
 public static void main(String[] args) {
  BidList auction = new BidList();
  
  // create some bidders
  Bidder amy = new Bidder(auction);
  Bidder julie = new Bidder(auction);
  Bidder pat = new Bidder(auction);

  // submit some bids to the auction 
  auction.submitBid(new Bid("Amy",150));
  auction.submitBid(new Bid("Julie",160));
  auction.submitBid(new Bid("Amy",165));
  auction.submitBid(new Bid("Julie",170));
  auction.submitBid(new Bid("Pat", 175));

  // The bidding has gone too high for Amy.
  auction.deleteObserver(amy);
  
  // few more bids
  auction.submitBid(new Bid("Julie",180));
  auction.submitBid(new Bid("Pat",185));
  
  // now too high for Julie
  auction.deleteObserver(julie);

  // this doesn't make sense, but just to show that
  // there is now only one observer (Pat)
  auction.submitBid(new Bid("Pat",190));
 }
}
