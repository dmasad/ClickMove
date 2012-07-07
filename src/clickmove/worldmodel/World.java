package clickmove.worldmodel;
import java.util.ArrayList;

/**
 * The internal god class that holds all the information
 * on the current state of the world, and updates it each tick.
 * @author dmasad
 *
 */
public class World {
	
	// The bounding box of the world
	public double x_size;
	public double y_size;
	
	
	// This is the ArrayList that holds everything in the world:
	public ArrayList<WorldObj> allWorldObjects = new ArrayList<WorldObj>();
	
	/**
	 * Iterate over every object in the world and increment their position.
	 * @param timestep The timestep to increment the world by
	 */
	public void update(int timestep) {
		for (WorldObj worldobj : allWorldObjects)
		{
			worldobj.update(timestep);
		}
	}
	
	/**
	 * Placeholder wrapper to insert a new object.
	 * @param newObj
	 */
	public void add_object(WorldObj newObj)
	{
		allWorldObjects.add(newObj);
	}
	
}
