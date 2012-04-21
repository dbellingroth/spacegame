package graphics;


import game.Point3D;

import org.lwjgl.opengl.GL11;

/**
 * Erlaubt das beliebige Verschieben, Drehen und Skalieren seiner
 * Unterklassen...
 * 
 * @author David Bellingroth
 * 
 */
public abstract class Transformable {
	
	
	protected Point3D translate = new Point3D( 0, 0, 0 );
	protected Point3D rotationPoint = new Point3D( 0, 0, 0 );
	protected double rotationAngle = 0;
	protected Point3D scaleFactor = new Point3D( 1, 1, 1 );

	
	
	public Point3D getTranslate() {
		
		return translate;
	}
	
	

	public void setTranslate( Point3D translate ) {
		
		this.translate = translate;
	}
	
	

	public Point3D getRotationPoint() {
		
		return rotationPoint;
	}

	
	
	public void setRotationPoint( Point3D rotationPoint ) {
		
		this.rotationPoint = rotationPoint;
	}

	
	
	public double getRotationAngle() {
		
		return rotationAngle;
	}
	
	

	public void setRotationAngle( double rotationAngle ) {
		
		this.rotationAngle = rotationAngle;
	}
	
	

	public Point3D getScaleFactor() {
		
		return scaleFactor;
	}

	
	
	public void setScaleFactor( Point3D scaleFactor ) {
		
		this.scaleFactor = scaleFactor;
	}

	
	
	/**
	 * Transformiert die aktuelle Matrix so wie gewünscht. Vorher bitte
	 * GL11.glPushMatrix() und nachher GL11.glPopMatrix() aufrufen Diese Methode
	 * muss von allen Klassen, die von Transformable erben in ihrer Draw-Methode
	 * aufgerufen werden!
	 */
	protected void transform() {

		GL11.glTranslated( translate.x, translate.y, translate.z );

		GL11.glTranslated( rotationPoint.x, rotationPoint.y, rotationPoint.z );
		
		// falls Rotation gewünscht
		if ( rotationAngle != 0 )
			GL11.glRotatef( (float) rotationAngle, 0f, 0f, 1);
		
		GL11.glTranslated( -rotationPoint.x, -rotationPoint.y, -rotationPoint.z );
		
		GL11.glScaled( scaleFactor.x, scaleFactor.y, scaleFactor.z );
	}

}