import graphics.Window;


public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Window w = new Window(640,480);
		FPSCounter fps = new FPSCounter();
		while (!w.shouldClose()) {
			System.out.print(".");
			fps.tick();
			w.setTitle("FPS: "+fps.getFPS()+ " Delta: "+fps.getDelta());
		}
		w.close();
	}

}
