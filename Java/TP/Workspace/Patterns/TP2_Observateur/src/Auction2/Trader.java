package Auction2;

public class Trader implements Observer {
	private Subject auction;
	private String nom;
	
	public Trader(String nom,Subject auction) {
		this.auction = auction;
		this.nom=nom;
		auction.addObserver(this);
	}

	public void update(Object newState) {
		Bid latestBid = (Bid)newState;
		System.out.println(nom+ " : The latest bid is " + latestBid);
	}

}
