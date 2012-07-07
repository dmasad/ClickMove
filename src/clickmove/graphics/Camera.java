/**
 * 
 */
package clickmove.graphics;

import clickmove.worldmodel.*;

import java.lang.Math;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * @author dmasad
 *
 */
public class Camera extends Canvas {
	
	protected World world; // The underlying world-model.
	
	// Canvas dimensions
	protected int WIDTH;
	protected int HEIGHT;
	
	BufferStrategy bufferStrategy;
	
	// Dimensions in world to view:
	protected double zoom = 1; // How many pixels per world-unit.
	protected double min_x = 0, min_y = 0; // The top-left corner of the window, in the world.
		// Derived values
	protected double max_x;
	protected double max_y;
	
	protected ArrayList<WorldObj> visObjects; // All objects currently visible.
	public ArrayList<Shape> drawnObjects; // All objects currently drawn on the screen.
	public ArrayList<Shape> controlObjects = new ArrayList<Shape>(); // All control-related objects.
	

	/**
	 * Start the camera
	 * @param newWorld The WorldObject the camera is tied to.
	 * @param width Width of window, in pixels.
	 * @param height Height of window, in pixels.
	 */
	public Camera(World newWorld, int width, int height) {
		world = newWorld;
		WIDTH = width;
		HEIGHT = height;
		
		max_x = min_x + WIDTH * zoom;
		max_y = min_y + HEIGHT * zoom;
		
		super.setBounds(0, 0, WIDTH, HEIGHT);
		super.setIgnoreRepaint(true);
		
		// Initiate the controllers:
		Controller controller = new Controller(this);
		super.addMouseListener(controller.mouseadapter);
		super.addMouseMotionListener(controller.mousemotionlistener);
		
		
	}
	
	/**
	 * Start the buffering; must be done separately, after the parent frame is ready.
	 */
	public void init_buffering() {
		this.createBufferStrategy(2); // Double-buffer
		bufferStrategy = super.getBufferStrategy();
		super.requestFocus();	
	}
	
	/*
	 * HELPER METHODS
	 * =============== 
	 */
	
	/**
	 * Find all objects visible within the window
	 * @return an ArrayList of WorldObj objects.
	 */
	private ArrayList<WorldObj> findVisible() {
		ArrayList<WorldObj> visibleObjects = new ArrayList<WorldObj>();
		for(WorldObj obj : world.allWorldObjects) {
			if (obj.x >= min_x && obj.x <= max_x && obj.y >= min_y && obj.y <= max_y)
				visibleObjects.add(obj);
		}
		return visibleObjects;
	}
	
	private void drawVisible() {
		drawnObjects = new ArrayList<Shape>();
		
		// PLACEHOLDER: Draw a circle for each visible object:
		for (WorldObj obj : visObjects)
		{
			int[] coords = coordinateConverter(obj);
			int radius = (int)Math.round(16 * zoom);
			//graphics.fillOval(coords[0], coords[1], radius, radius);
			drawnObjects.add(new Ellipse2D.Double(coords[0], coords[1], radius, radius));
		}
		
	}
	
	/**
	 * Takes an object and finds its screen coordinates, given the current position.
	 * @param obj a WorldObj object to be placed on the screen.
	 * @return a 2-member int array with the {x, y} coordinates in pixels. 
	 */
	private int[] coordinateConverter(WorldObj obj) {
		int x_coord = (int)Math.round((obj.x - min_x) * zoom);
		int y_coord = (int)Math.round((obj.y - min_y) * zoom);
		int[] coords = {x_coord, y_coord}; 
		return coords;
	}
	
	void moveView(double new_min_x, double new_min_y, double new_zoom) {
		min_x = new_min_x;
		min_y = new_min_y;
		zoom = new_zoom;
		
		max_x = min_x + WIDTH * zoom;
		max_y = min_y + HEIGHT * zoom;
		
		// Update the list of visible objects.
		visObjects = findVisible();
	}
	
	/*
	 * RENDERING FUNCTIONS BELOW
	 * =========================
	 */
	/**
	 * The basic camera step.
	 */
	public void render() {
		Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		graphics.setBackground(Color.black);
		graphics.clearRect(0, 0, WIDTH, HEIGHT);
		
		visObjects = findVisible();
		drawVisible();
		
		render(graphics);
		graphics.dispose();
		bufferStrategy.show();
	}
	
	public void render(Graphics2D graphics) {
		// TODO: Put in detailed rendering instructions here.
		//visObjects = findVisible();
		graphics.setColor(Color.WHITE);
		
		for (Shape s : drawnObjects) {
			//graphics.draw(s);
			graphics.fill(s);
		}
		
		for (Shape s : controlObjects) 
			graphics.draw(s);
		
	}
	
	
	
}
