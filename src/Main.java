import javax.vecmath.Vector2d;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import graphics.Screen;
import graphics.Sprite;


public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Screen w = new Screen( 640,480 );
		
		Sprite sprite = new Sprite("res/Schiff.png");
		
		FPSCounter.tick();
		
		while (!w.shouldClose()) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			
			w.setTitle( "FPS: "+FPSCounter.getFPS()+ " Delta: "+FPSCounter.getDelta() );
			sprite.draw();
			FPSCounter.tick();
			Display.update();
			Display.sync(120); // FPS begrenzen
			sprite.setRotationAngle(Math.random()*5);
			sprite.setTranslate(new Vector2d(Math.random()*200,Math.random()*200));
		}
		
		w.close();
	}

}
