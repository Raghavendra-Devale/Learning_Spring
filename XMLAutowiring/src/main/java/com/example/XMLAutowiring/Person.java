package com.example.XMLAutowiring;

public class Person {
	Vehicle vehicle;
	
	public Person(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void drive() {
		vehicle.start();
	}
	
}
