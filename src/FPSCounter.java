import org.lwjgl.Sys;


public class FPSCounter {
	private long fps, counter, lastCount, lastFrame;
	
	public FPSCounter() {
		lastCount = getTime();
		getDelta();
	}
	
	public void tick() {
		if (getTime() - lastCount > 1000) {
			fps = counter;
			counter = 0; // reset the FPS counter
			lastCount += 1000; // add one second
		}
		counter++;
	}
	
	public long getFPS() {
		return fps;
	}
	
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
	
}
