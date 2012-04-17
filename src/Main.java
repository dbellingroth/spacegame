import graphics.Window;


public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Window w = new Window(640,480);
		FPSCounter.tick();
		while (!w.shouldClose()) {
			w.setTitle("FPS: "+FPSCounter.getFPS()+ " Delta: "+FPSCounter.getDelta());
			Thread.sleep(500);
			FPSCounter.tick();
		}
		w.close();
	}

}
