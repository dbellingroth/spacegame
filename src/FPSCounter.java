
import org.lwjgl.Sys;


public class FPSCounter {
	private static boolean started = false;
	private static long fps, counter, lastTick, lastCount;
	private static int delta;
	
	/**
	 * Call once per frame at the end of the main loop. Also calling once before starting the main loop is recommended.
	 */
	public static void tick() {
		
		if (!started) {
			started = true;
			lastCount = getTime();
			tick();
		}
		
		if (getTime() - lastCount > 1000) {
			fps = counter;
			counter = 0; // reset the FPS counter
			lastCount += 1000; // add one second
		}
		counter++;
		
		delta = (int) (getTime()-lastTick);
		lastTick = getTime();
	}
	
	/**
	 * 
	 * @return current fps
	 */
	public static long getFPS() {
		return fps;
	}
	
	/**
	 * 
	 * @return timecode in milliseconds
	 */
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/**
	 * 
	 * @return delta for the last frame
	 */
	public static int getDelta() {
		return delta;
	}
	
}
