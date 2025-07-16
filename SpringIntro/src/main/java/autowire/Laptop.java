package autowire;


public class Laptop {
	
	private Processor processor;
	public Laptop(Processor processor) {
		this.processor = processor;
	}
	
	public void start() {
		processor.boot();
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	
}
