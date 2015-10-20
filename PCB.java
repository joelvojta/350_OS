import java.io.File;
import java.util.LinkedList;

class PCB_State
{
	static int NEW = 0;
	static int READY = 1;
	static int RUNNING = 2;
	static int WAITING = 3;
	static int TERMINATED = 4;
}

class PCB_Priority
{
	static int LOW = 0;
	static int NORMAL = 1;
	static int HIGH = 2;
}

public class PCB 
{
	static PCB PCBNotFound = null;
	private int pid;
	private int state;
	private int timeSlice;
	private int priority;
	private PCB parent;
	private LinkedList<PCB> children = new LinkedList<PCB>();
	private LinkedList<File> openFiles = new LinkedList<File>();
	private LinkedList<String> instructions = new LinkedList<String>();
	private LinkedList<Register> registerValues = new LinkedList<Register>();
	private int programCounter = 0;
	
	
	public PCB(int pid, PCB parent, LinkedList<String> instructions)
	{
		this.pid = pid;
		this.state = PCB_State.NEW;
		this.timeSlice = 0;
		this.priority = PCB_Priority.NORMAL;
		this.parent = parent;
		this.instructions = instructions;
	}

	public String getValueForRegister(String registerName)
	{
		for(Register r : this.registerValues)
		{
			if(r.getName().equals(registerName))
			{
				return r.getBinaryValue();
			}
		}
		return null;
	}
	
	////////////////////////////////////////////////////////////////

	public void setValueForRegisters(String registerName)
	{
			Register registerItem = new Register(registerName);
			this.registerValues.add(registerItem);
	}
	
	////////////////////////////////////////////////////////////////
	
	public int getPriority() 
	{
		return priority;
	}

	public int getTimeSlice() 
	{
		return timeSlice;
	}
	
	public void setPriorityHigh()
	{
		this.priority = PCB_Priority.HIGH;
	}
	
	public void setPriorityNormal()
	{
		this.priority = PCB_Priority.NORMAL;
	}
	
	public void setPriorityLow()
	{
		this.priority = PCB_Priority.LOW;
	}
	
	public void setStateReady()
	{
		this.state = PCB_State.READY;
	}
	
	public void setStateRunning()
	{
		this.state = PCB_State.RUNNING;
	}
	
	public void setStateWaiting()
	{
		this.state = PCB_State.WAITING;
	}
	
	public void setStateTerminated()
	{
		this.state = PCB_State.TERMINATED;
	}
	
	public void setTimeSlice(int timeSlice) 
	{
		this.timeSlice = timeSlice;
	}
	
}