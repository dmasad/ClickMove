package snarkhunt;

import javax.swing.JPanel;

import clickmove.worldmodel.SubSystem;
import clickmove.worldmodel.WorldObj;

/**
 * A sensor has two states: active (value==true) and passive (value==false).
 * Each state has a range associated with it.
 * @author dmasad
 *
 */
public class Sensor extends SubSystem<Boolean> {
	
	// Range definition
	double activeRange;
	double passiveRange;
	
	// GUI components:
	JPanel component;
	// TODO Add radio buttons.
	
	public Sensor(WorldObj parentObj, Boolean active, double aRange, double pRange ) {
		super(parentObj, active);
		activeRange = aRange;
		passiveRange = pRange;
	}
	
	

}
