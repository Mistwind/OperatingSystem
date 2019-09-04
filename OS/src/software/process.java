package software;
import hardware.MajorDevices;

public class process {
	private int[] PCB; //	PID\main register\process status\block reason
	private int time;
	private int ax;
	private static int returnCode;
	
	public int create() { //create the process
		PCB = new int[4];
		PCB[0] = MajorDevices.getPID();
		PCB[1] = 0;
		PCB[2] = 0;  //0 is create,1 is ready,2 is block,3 is run,4 is quit
		PCB[3] = -1; //it isn't in block
		time = 6;    //run time
		returnCode = 0;  //succeed to create
		//add to the ready queue
		return returnCode;
	}

	public static int destroy(process p) { //destroy the process
		p = null;
		System.gc();
		returnCode = 10; //succeed to destroy
		return returnCode;
	}
	
	public int block() { //block the process
		this.PCB[2] = 2;
		this.ax = MajorDevices.ax;
		//add to the block queue
		return returnCode;
	}
	
	public int awake() { //awake the sleeping process
		//remove from the block queue
		//add to the ready queue or the run
		return returnCode;
	}
	
}
