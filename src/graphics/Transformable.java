package graphics;

import javax.vecmath.Vector2d;

import org.lwjgl.opengl.GL11;

/**
 * Erlaubt das beliebige Verschieben, Drehen und Skalieren seiner
 * Unterklassen...
 * 
 * @author David Bellingroth
 * 
 */
public abstract class Transformable {

	protected Vector2d translate = new Vector2d(0, 0);
	protected Vector2d rotationPoint = new Vector2d(0, 0);
	protected double rotationAngle = 0;
	protected Vector2d scaleFactor = new Vector2d(1, 1);

	public Vector2d getTranslate() {
		return translate;
	}

	public void setTranslate(Vector2d translate) {
		this.translate = translate;
	}

	public Vector2d getRotationPoint() {
		return rotationPoint;
	}

	public void setRotationPoint(Vector2d rotationPoint) {
		this.rotationPoint = rotationPoint;
	}

	public double getRotationAngle() {
		return rotationAngle;
	}

	public void setRotationAngle(double rotationAngle) {
		this.rotationAngle = rotationAngle;
	}

	public Vector2d getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(Vector2d scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	/**
	 * Transformiert die aktuelle Matrix so wie gewünscht. Vorher bitte
	 * GL11.glPushMatrix() und nachher GL11.glPopMatrix() aufrufen Diese Methode
	 * muss von allen Klassen, die von Transformable erben in ihrer Draw-Methode
	 * aufgerufen werden!
	 */
	protected void transform() {

		GL11.glTranslated(translate.x, translate.y, 0);

		GL11.glTranslated(rotationPoint.x, rotationPoint.y, 0);
		// falls Rotation gewünscht
		if (rotationAngle != 0)
			GL11.glRotatef((float) rotationAngle, 0f, 0f, 1);
		GL11.glTranslated(-rotationPoint.x, -rotationPoint.y, 0);
		GL11.glScaled(scaleFactor.x, scaleFactor.y, 1);
	}

}