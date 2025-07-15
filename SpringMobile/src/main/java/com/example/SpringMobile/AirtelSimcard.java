package com.example.SpringMobile;

public class AirtelSimcard implements SimCard {
	private String networkName;
	
	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	@Override
	public void call() {
		System.out.println("Calling via " + networkName);

	}

	@Override
	public void browse() {
		System.out.println("Browsing via " + networkName);

	}

}
