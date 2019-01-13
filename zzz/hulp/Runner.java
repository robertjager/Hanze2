package nl.hanze.zzz.hulp;

public class Runner {
	
	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

    public static void main(String[] args) throws Exception {
    	boolean getAll=true;
       	thread(new BBSCheck(true,getAll), false);
    }
}
