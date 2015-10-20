
public class QFactory 
{
	static PSQueue theJobQ = new PSQueue();
	static PSQueue theReadyQ = new PSQueue();
	static PSQueue theWaitingQ = new PSQueue();
	
	static PCB getNextPCBForCPU()
	{
		PCB thePCB = QFactory.theReadyQ.getPCBwithPriority(PCB_Priority.HIGH);
		if(thePCB == PCB.PCBNotFound)
		{
			thePCB = QFactory.theReadyQ.getPCBwithPriority(PCB_Priority.NORMAL);
			if(thePCB == PCB.PCBNotFound)
			{
				thePCB = QFactory.theReadyQ.getPCBwithPriority(PCB_Priority.LOW);
			}
		}
		return thePCB;
	}
}