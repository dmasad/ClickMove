package snarkhunt;

import java.awt.Color;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.CommandableUnit;
import clickmove.worldmodel.World;
import clickmove.worldmodel.WorldObj;

public class MissileBoat extends WorldObj implements CommandableUnit {
	
	// TODO: Completely fix the acceleration model so it isn't a piece of complete shit.
	
	double xSpeed;
	double ySpeed;
	
	public double target_xSpeed;
	public double target_ySpeed;
	public Sensor sensor;
	public double acceleration; // Change in units per timestep.
	public float heading;
	
	//CircleGraphic graphicsObject;
	
	public MissileBoat(World world) {
		
		selectable = true;
		visible = true;
		
		sensor = new Sensor(this, false, 100, 10);
		subSystems.add(new MissileLauncher(world, this, 5));
		subSystems.add(sensor);
		graphicsObject = new CircleGraphic(this, 0, 0, 8, Color.BLUE);
	
	}
	
	public void update(int timestep)
	{
		for(int i = 0;i<timestep;i++) {
			// Accelerate:
			if (xSpeed != target_xSpeed || ySpeed != target_xSpeed)
			{
				double dvx = acceleration * Math.cos(heading);
				double dvy = acceleration * Math.sin(heading);
				
				xSpeed = minAbs(xSpeed + dvx, target_xSpeed);
				ySpeed = minAbs(ySpeed + dvy, target_ySpeed);
			}
			
			// Move
			x += xSpeed;
			y += ySpeed;
		}
	}
	
	public void setVector(float angle, float magnitude) {
		
		heading = angle;
		// Set target velocity
		target_ySpeed = magnitude * Math.sin(heading);
		target_xSpeed = magnitude * Math.cos(heading);
		
	}
	

	public GraphicsObject setGraphicsObject(int xCoord, int yCoord) {
		graphicsObject.setCoords(xCoord, yCoord);  
		return graphicsObject;
	}
	
	public void select() {
		selected = true;
		graphicsObject.selected = true;
	}
	
	public void deselect()
	{
		selected = false;
		graphicsObject.selected = false;
	}
	
	// Returns the value with the lowest absolute value:
	private double minAbs(double a, double b) {
		if (Math.abs(a) < Math.abs(b)) return a;
		else return b;
	}
	
	
}
