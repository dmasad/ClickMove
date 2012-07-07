

package clickmove.graphics.graphicsobjects;

import java.awt.Graphics2D;

import clickmove.graphics.Camera;
import clickmove.worldmodel.*;

/**
 * A wrapper around a shape or sprite that can interface with 
 * the original worldObject.
 */
public class GraphicsObject {
	public WorldObj worldObj; // The underlying object.
	private Camera camera; // The camera associated with the object
	
	// Screen coordinates:
	public int x;
	public int y;
	
	/**
	 * Create a new graphics object.
	 * @param myCamera The camera this object is visible in.
	 * @param underlyingObj The object this graphic represents.
	 */
	public GraphicsObject(Camera myCamera, WorldObj underlyingObj, int xCoord, int yCoord) {
		camera = myCamera;
		worldObj = underlyingObj;
		
		x = xCoord;
		y = yCoord;
	}
	
	/**
	 * Render the graphic onto the camera
	 * @param g The camera buffer's Graphics2D context.
	 */
	public void render(Graphics2D g) {
		// Render code goes here.
	}
	
	public boolean contains(double x, double y) {
		// Abstract method.
		return false;
	}
	
	
}
