package game;

public interface InputReceiver {

	
	public void mousePressed( int button );
	public void mouseReleased( int button );
	
	public void mouseWheel( int direction );
	
	
	public void keyPressed( int key );
	public void keyReleased( int key );
	
}
