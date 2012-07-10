package snarkhunt;

import clickmove.worldmodel.CommandableUnit;
import clickmove.worldmodel.WorldObj;

public class MissileBoat extends WorldObj implements CommandableUnit {
	
	private double xSpeed;
	private double ySpeed;
	
	public double target_xSpeed;
	public double target_ySpeed;
	
	public double acceleration;
	
	public void update(int timestep)
	{
		// Move
		x += timestep * xSpeed;
		y += timestep * ySpeed;
	}
	
	public void setVector(float angle, float magnitude) {
		
	}
	
	
}
