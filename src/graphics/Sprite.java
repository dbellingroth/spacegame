package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;

public class Sprite extends Transformable implements Drawable{
	
	
	private Texture texture;
	private int width, height;
	private float widthFactor, heightFactor;
	
	
	
	public Sprite( String imagePath ) {
		
		try {
			
			URL image_url = getClass().getClassLoader().getResource(imagePath);
			BufferedImage image = ImageIO.read(image_url);
			this.width = image.getWidth();
			this.height = image.getHeight();
			texture = new Texture(image);
			
			this.widthFactor = (float) this.width / texture.getEdgeLength();
			this.heightFactor = (float) this.height / texture.getEdgeLength();
			
			
		} catch (IOException e) {
		}
	}



	
	public void draw() {
		
		texture.bind();

		GL11.glPushMatrix();

		super.transform();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(widthFactor, 0);
		GL11.glVertex2f(width, 0);
		GL11.glTexCoord2f(widthFactor, heightFactor);
		GL11.glVertex2f(width, height);
		GL11.glTexCoord2f(0, heightFactor);
		GL11.glVertex2f(0, height);
		GL11.glEnd();

		GL11.glPopMatrix();
	}

	
	
	
	public boolean getVisibility() {
		
		return false;
	}

	
	
	
	public void setVisibility(boolean visible) {
		
		
	}
	
	
	
}
