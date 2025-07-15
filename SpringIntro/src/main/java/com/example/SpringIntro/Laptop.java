package com.example.SpringIntro;


public class Laptop {
	
	private Processor processor;
	public Laptop(Processor processor) {
		this.processor = processor;
	}
	
	public void start() {
		processor.boot();
	}
	
	
}
