package graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class Window {
	protected int width, height;
	protected boolean fullscreen = false;
	
	public Window(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			PixelFormat pix = new PixelFormat(org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel(),
				     8,   // alpha
				    24,   // depth buffer
				     1,   // stencil buffer
				     4) ;
			Display.create(pix);
			setResolution(width, height);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setResolution(int width, int height) throws LWJGLException {
		this.width = width;
		this.height = height;
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.setFullscreen(this.fullscreen);
		initGL(width, height);
	}
	
	public void setFullscreen(boolean fullscreen){
		
		try {
			Display.setFullscreen(fullscreen);
			this.fullscreen = fullscreen;
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initGL(width, height);
	}
	
	public void setTitle(String title) {
		Display.setTitle(title);
	}
	
	private void initGL(int width, int height) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		/*
		 * GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
		 * GL11.GL_CLAMP); GL11.glTexParameteri(GL11.GL_TEXTURE_2D,
		 * GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		 */
	}
	
	public boolean shouldClose(){
		return Display.isCloseRequested();
	}
	
	public void close() {
		Display.destroy();
	}

}
