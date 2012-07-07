/*
 * WorldObj
 * The superclass for all objects in the game world.
 */

package clickmove.worldmodel;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;

public abstract class WorldObj implements CommandableUnit {
	public double x;
	public double y;
	public boolean selectable;
	public boolean selected;
	
	public GraphicsObject graphicsObject; // The GraphicsObject currently associated with this WorldObj.
	
	public GraphicsObject setGraphicsObject(Camera camera, int xCoord, int yCoord) {
		graphicsObject = new GraphicsObject(camera, this, xCoord, yCoord);
		return graphicsObject;
	}
	  
	public abstract void update(int timestep);  
}
