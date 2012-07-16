package snarkhunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.WorldObj;

public class CircleGraphic extends GraphicsObject {
	
	protected int radius;
	protected Color color;
	protected Ellipse2D.Double circle;

	//public CircleGraphic(Camera myCamera, WorldObj underlyingObj, int xCoord, int yCoord, int r, Color c) {
	public CircleGraphic(WorldObj underlyingObj, int xCoord, int yCoord, int r, Color c) {
		//super(myCamera, underlyingObj, xCoord, yCoord);
		super(underlyingObj, xCoord, yCoord);
		radius = r;
		color = c;
		circle = new Ellipse2D.Double(x, y, radius, radius);
	}
	
	public void render(Graphics2D g) {
		if (selected == true) {
			g.setColor(Color.WHITE);
			g.draw(new Rectangle2D.Double(x-4, y-4, radius+4, radius+4));
			g.draw(new Line2D.Double(x, y, 
					x + ((MissileBoat)worldObj).xSpeed*100, y + 100*((MissileBoat)worldObj).ySpeed));
			
		}
		g.setColor(color);
		g.fill(circle);
	}
	
	public void setCoords(int newX, int newY) {
		x = newX;
		y = newY;
		
		circle.x = x;
		circle.y = y;
	}
	
	public boolean contains(double xCoord, double yCoord) {
		return circle.contains(xCoord, yCoord);
	}
}
