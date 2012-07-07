/**
 * 
 */
package clickmove.graphics.graphicsobjects;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import clickmove.graphics.Camera;
import clickmove.worldmodel.WorldObj;

/** A basic placeholder for circular shapes.
 * @author dmasad
 *
 */
public class EllipseObject extends GraphicsObject {
	
	protected int radius;
	protected Ellipse2D.Double circle;
	
	public EllipseObject(Camera myCamera, WorldObj underlyingObj, int xCoord, int yCoord) {
		super(myCamera, underlyingObj, xCoord, yCoord);
		radius = 8;
		
		circle = new Ellipse2D.Double(x, y, radius, radius);
	}
	
	public void render(Graphics2D g) {
		if (selected == true) {
			g.draw(new Rectangle2D.Double(x, y, radius, radius));
		}
		g.fill(circle);
	}
	
	public boolean contains(double xCoord, double yCoord) {
		return circle.contains(xCoord, yCoord);
	}

}
