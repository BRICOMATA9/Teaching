package Auction2;

import java.util.ArrayList;

public class Stock implements Subject {
 private ArrayList<Observer> observers;
 private Bid latestBid;
 
 public Stock () {
  observers = new ArrayList<Observer>();
 }

 /* add a registered observer */
 public void addObserver(Observer o) {
  observers.add(o);
 }

 /* remove a registered observer */
 public void removeObserver(Observer o) {
  observers.remove(0);
 }

 /* notify all registered observers */
 public void notifyObservers() {
  for (int i = 0; i < observers.size(); i++) {
   Observer obs = observers.get(i);
   obs.update(latestBid);
  }
 }

 /* bidders invoke this method when they submit a bid */ 
 public void submitBid(Bid latestBid) {
  this.latestBid = latestBid;

  // notify all registered bidders (observers)
  notifyObservers();  
 }
}
