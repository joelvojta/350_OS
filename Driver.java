public class Driver {

	public static void main(String[] args) 
	{
		//Initial the OS
		CUWOS theOS  = new CUWOS();
		
		for(int i = 0; i < 10; i++)
		{
			theOS.theProcessScheduler.createPCB();
		}
	}

}