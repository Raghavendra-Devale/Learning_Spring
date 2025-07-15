package com.example.SpringIntro;

public class Laptop {
	private Processor process;
	
	
	
	public void setProcess(Processor process) {
		this.process = process;
	}



	public Processor getProcess() {
		return process;
	}



	public void callProcess() {
		process.runProcessor();
	}


}
