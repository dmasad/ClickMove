package clickmove.worldmodel;

import javax.swing.JComponent;

/**
 * Class that defines a specific property of a WorldObject 
 * that can be modified, particularly by the player.
 * @author dmasad
 *
 * @param <T>
 */
public class SubSystem<T> {
	
	protected T value; // The value assigned.
	protected JComponent component; // The component associated with
	protected WorldObj rootObj; // The root object associated  
	
	public SubSystem(WorldObj obj, T startValue) {
		rootObj = obj;
		value = startValue;
	}
	
	public JComponent setupComponent()
	{
		return component;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T newValue) {
		value = newValue;
	}
	
	

}
