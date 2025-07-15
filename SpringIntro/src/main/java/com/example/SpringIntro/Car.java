package com.example.SpringIntro;

public class Car {
	private Engine engine;

	public void setEngine(Engine engine) {
		this.engine = engine;
	} 
	
	public void Drive() {
		System.out.println("Car ");
		engine.start();
	}
}
