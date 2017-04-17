import java.util.TimerTask;
import java.util.Timer;

public class RandPassGen {
	
	private static Timer tmr;
	private static TimerTask Gen;

	public static void main(String[] args) {
		//Randomly generate a password every 24 hours
		long g = 1000*60*60*24;
		
		//code to set timer device
		tmr = new Timer();
		Gen = new Task();
		//runs Gen task every 24 hours
		tmr.scheduleAtFixedRate(Gen, 0, g);
		
	}


}
