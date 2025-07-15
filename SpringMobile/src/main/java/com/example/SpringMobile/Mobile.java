package com.example.SpringMobile;

public class Mobile {
	private SimCard simCard;

	public void setSimCard(SimCard simCard) {
		this.simCard = simCard;
	}

	public SimCard getSimCard() {
		return simCard;
	}
	
	public void start() {
		simCard.call();
		simCard.browse();
		
	}
}
