/*
 * WorldObj
 * The superclass for all objects in the game world.
 */

package clickmove.worldmodel;

import java.util.ArrayList;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;

public abstract class WorldObj implements CommandableUnit {
	public double x;
	public double y;
	public boolean selectable;
	public boolean selected;
	public boolean visible;
	
	public ArrayList<SubSystem> subSystems = new ArrayList<SubSystem>();
	
	public GraphicsObject graphicsObject; // The GraphicsObject currently associated with this WorldObj.
	
	public GraphicsObject setGraphicsObject(int xCoord, int yCoord) {
		return graphicsObject;
	}
	
	public void select() {
		if(selectable) {
			selected = true;
			graphicsObject.selected = true;
		}
	}
	
	public void deselect() {
		if(selectable) {
			selected = false;
			graphicsObject.selected = false;
		}
	}
	  
	public abstract void update(int timestep);  
}
