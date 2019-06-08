package Exo1;

public class Market {
	private String city="Paris";
	private Integer nStalls = 2;

	public Market (String city,Integer nStalls){
		this.city=city;
		this.nStalls=nStalls;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getnStalls() {
		return nStalls;
	}
	public void setnStalls(Integer nStalls) {
		this.nStalls = nStalls;
	}

}
