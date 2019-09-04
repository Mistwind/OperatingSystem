package hardware;

public class Device {
	private int number;	  //the number of devices
	private int[][] distributeTable;	//the first int is PID,the second int is use time
	private int[][] waitTable;		//the first int is PID, the second int is need time
	private boolean busy;  //when has no one can be used,it is 1
	
	public Device(int number) {
		this.number = number;
		this.distributeTable = new int[number][2];
		this.busy = false;
	}
	
	public boolean is_busy() {
		return busy;
	}
	
	public void getDevice(int PID,int time) {
		for(int[] each:distributeTable) {
			if(each[0] == -1) {
				each[0] = PID;
				each[1] = time;
				number--;
				if(this.number == 0) {
					this.busy = true;
				}
				break;
			}
		}
	}
	
	public void relseaseDevice() {
		for(int[] each:distributeTable) {
			if(each[1] == 0) {
				each[0] = -1;
				if(this.waitTable!=null) {
					//wakeup waiting processes
				}
				if(this.number > 0) {
					this.busy = false;
				}
				break;
			}
		}
	}
	
	public int[][] getDistribution() {
		return this.distributeTable;
	}
	
	public int[][] getWaitTable() {
		return this.waitTable;
	}
}
