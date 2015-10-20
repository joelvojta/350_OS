import java.util.LinkedList;
import java.util.NoSuchElementException;

//represent a Queue of PCB's managed by the Process Scheduler
public class PSQueue 
{
	private LinkedList<PCB> theLowQ = new LinkedList<PCB>();
	private LinkedList<PCB> theNormalQ = new LinkedList<PCB>();
	private LinkedList<PCB> theHighQ = new LinkedList<PCB>();
	private LinkedList<LinkedList<PCB>> theQs = new LinkedList<LinkedList<PCB>>();
	
	public PSQueue()
	{
		theQs.add(this.theLowQ); //add to position 0 (PCB_Priority.LOW)
		theQs.add(this.theNormalQ); //add to position 1 (PCB_Priority.NORMAL)
		theQs.add(this.theHighQ); //add to position 2 (PCB_Priority.HIGH)
	}
	
	public PCB getPCBwithPriority(int priority)
	{
		try
		{
			return this.theQs.get(priority).removeFirst();
		}
		catch(NoSuchElementException e)
		{
			return PCB.PCBNotFound;
		}
	}
	
	public void addPCB(PCB p, boolean withPriority)
	{
		if(!withPriority)
		{
			theQs.get(PCB_Priority.NORMAL).addLast(p);
		}
		else
		{
			//add with priority
			theQs.get(p.getPriority()).addLast(p);
		}
	}
}