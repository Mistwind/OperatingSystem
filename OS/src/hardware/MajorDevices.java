package hardware;

public class MajorDevices {
	public static int ax;
	public static int PID = 0;					//PID for a new process 
	public static int[] psw = new int[4];      //zf\cf\sf\df
	public static int pc;			
	public static int clock;
	public static int ir;
	public static int device;					
	public static int[][] readyQueue;			//ready queue
	public static int runningPID;				//PID of running process
	
	public static void cpu() {
		while(true) {
			pc++;
			switch(ir/256) {  //ir structure :3 instruction code\2 device code\7 number code
				case 0:ax=ir%128;		//assignment instruction
				       //print the result
					   break;	
				case 1:ax++;				//increase instruction
					   //print the result
				       break;
				case 2:ax--;				//decrease instruction
					   if(ax==0) {
						   psw[0] = 1;
					   }
					   //print the result
				       break;
				case 3:device=(ir%256)/128;	//request device instruction,0 is A,1 is B,2 is C
				       //get the device
				       //print the result
				       break;
				case 4:					//end
					   for(int each:psw) {
						   each = 1;
					   }
					   //recover the PCB,devices
					   //print the result
					   break;
			}
			//interrupt
		}
	}
	
	public static void clock() {
		
	}
	
	public static void wander() {
		while(readyQueue==null) {
			//run
			PID = -1;
		}
	}
	
	public static int getPID() {
		int returnpid = PID;
		return returnpid;
	}
	
}
