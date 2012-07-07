/*
 * WorldObj
 * The superclass for all objects in the game world.
 */

package clickmove.worldmodel;

public abstract class WorldObj {
	public double x;
	public double y;
	public boolean selected;
	  
	public abstract void update(int timestep);  
}
