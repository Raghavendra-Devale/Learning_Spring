package autowire;

public class IntelProcessor implements Processor {
	
	
	@Override
	public void boot() {
		
		System.out.println("Intel processor is running......!");
	}

}
