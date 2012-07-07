/**
 * 
 * 
 */
package clickmove.worldmodel;
import java.lang.Math;


/**
 * @author dmasad
 * The MobileObj class is a subclass of WorldObj 
 * for objects that have a specific velocity.  
 */
public class MobileObj extends WorldObj {
	
	public double x_speed;
	public double y_speed;
	
	public MobileObj(double starting_x, double starting_y)
	{
		x = starting_x;
		y = starting_y;
		
		x_speed = 0;
		y_speed = 0;
	}
	
	/** 
	 * Update the object by moving it the correct distance
	 * for the given timestep.
	 */
	public void update(int timestep) {
		x += timestep * x_speed;
		y += timestep * y_speed;
	}
	
	/**
	 * Set the object's velocity based on an angle and magnitude.
	 * @param angle The angle in radians.
	 * @param magnitude The magnitude of the new velocity.
	 */
	public void set_vector(float angle, float magnitude)
	{
		// angle in radians.
		y_speed = magnitude * Math.sin(angle);
		x_speed = magnitude * Math.cos(angle);
	}
	
}
