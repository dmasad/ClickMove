

package clickmove.graphics.graphicsobjects;

import java.awt.Graphics2D;

import clickmove.worldmodel.*;

/**
 * A wrapper around a shape or sprite that can interface with 
 * the original worldObject.
 */
public class GraphicsObject {
	public WorldObj worldObj; // The underlying object.
	
	public GraphicsObject(WorldObj underlyingObj) {
		worldObj = underlyingObj;
	}
	
	public void render(Graphics2D g) {
		// Render code goes here.
	}
	
	
}
