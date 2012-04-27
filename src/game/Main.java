package game;

import graphics.Screen;
import graphics.Sprite;


public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main( String[] args ) throws InterruptedException {
		
		Screen w = new Screen( 640, 480 );
		
		Sprite sprite = new Sprite( "res/Schiff.png" );
		
		FPSCounter.tick();
		
		while ( !w.shallClose() ) {
			
			sprite.draw();
			sprite.setRotationAngle(Math.random()*5);
			sprite.setTranslate( new Point3D( (float) (Math.random()*200), (float) (Math.random()*200 ), 0));
		
			w.render();
			
		}
		
		w.close();
	}

}
