package snarkhunt;

import java.awt.Color;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.CommandableUnit;
import clickmove.worldmodel.WorldObj;


/**
 * Missiles take on the velocity of the ship that launched them; they can change 
 * angle, but always keep the same speed. This is purely gameist with little/no 
 * physics justification (maybe gyroscopes?), but requires attack runs.
 * @author dmasad
 *
 */
public class Missile extends WorldObj implements CommandableUnit {
	
	private double xSpeed;
	private double ySpeed;
	
	private double speed;
	private double heading;
	
	public Missile(double startingX, double startingY) {
		
		xSpeed = startingX;
		ySpeed = startingY;
		
		speed = Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed);
		heading = Math.acos(startingX/speed);		
	}
	
	@Override
	public void setVector(float angle, float magnitude) {
		heading = angle;
		ySpeed = speed * Math.sin(heading);
		xSpeed = speed * Math.cos(heading);
		
	}
	@Override
	public void update(int timestep) {
		for (int i=0;i<timestep;i++) {
			x += xSpeed;
			y += ySpeed;
		}
		
	}
	
	public GraphicsObject setGraphicsObject(Camera camera, int xCoord, int yCoord) {
		graphicsObject = new CircleGraphic(camera, this, xCoord, yCoord, 4, Color.GREEN); 
		return graphicsObject;
	}
	
	

}
