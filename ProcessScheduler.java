import java.util.LinkedList;
import java.util.Random;


public class ProcessScheduler
{
	private PSQueue theJobQ = new PSQueue();
	private PSQueue theReadyQ = new PSQueue();
	private PSQueue theWaitingQ = new PSQueue();
	private int currPID;
	private Random r = new Random();
	
	public ProcessScheduler()
	{
		this.currPID = 0;
	}
	
	public void createPCB()
	{
		int numInstructions = r.nextInt(41) + 10;
		System.out.println("** Creating PCB with:" + numInstructions + " lines");
		LinkedList<String> theInstructions = new LinkedList<String>();
		for(int i = 0; i < numInstructions; i++)
		{
			theInstructions.add("instruction " + i);
		}
		
		PCB theNewPCB = new PCB(this.currPID, null, theInstructions);
		
		//increment the PID for the next PCB
		this.currPID++;
		
		//add the new PCB to the Job Q
		theNewPCB.setPriorityHigh();
		this.theJobQ.addPCB(theNewPCB, false);   //false --> no priority
		System.out.println("\t*** Add PCB to Job Q");
		
		//add the new PCB to the Ready Q
		theNewPCB.setStateReady();
		this.theReadyQ.addPCB(theNewPCB, true);  //true --> priority
		
		//******We need to wrap our Q's in a data structure
		
	}
}