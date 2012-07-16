package clickmove.graphics;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.WorldObj;

/**
 * The class that handles all the mouse and keyboard controls.
 * @author dmasad
 *
 */
public class Controller {
	
	// TODO: Make the entire class state-dependent.
	
	// The camera associated with the controller.
	public Camera camera;
	
	// Control constants
	public int SCROLL_BORDER = 20; // The distance from the edge of the window to scroll, in pixels.
	
	// State variables and constants.
	int DEFAULT_STATE = 0;
	int SELECTED_STATE = 1;
	int DRAGGING_STATE = 2;
	
	int state = DEFAULT_STATE;

	WorldObj selected = null; // The selected shape
	
	public Controller(Camera newCamera) {
		camera = newCamera;
	}
	
	/**
	 * Mouse click event listener.
	 */
	public MouseAdapter mouseadapter = new MouseAdapter() {
		
		public void mousePressed(MouseEvent e) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			
			if (state==DEFAULT_STATE) {
				// Check to see if the mouse has been clicked on an object
				for (GraphicsObject s : camera.drawnObjects) {
					if(s.contains(mouseX, mouseY)) {
						state = SELECTED_STATE;
						selected = s.worldObj;
						selected.select();
						//selected.selected = true;
					}
				}
			}	
		}
		
		public void mouseReleased(MouseEvent e) {
			if (state==DRAGGING_STATE) {
				camera.controlObjects.clear();
				// Issue the order:
				int mouseX = e.getX();
				int mouseY = e.getY();
				double selectedX = selected.graphicsObject.x;
				double selectedY = selected.graphicsObject.y;
				
				double deltaY = mouseY - selectedY;
				double deltaX = mouseX - selectedX;
				
				double angle = Math.atan2(deltaY, deltaX);
				double distance = Math.sqrt(deltaY*deltaY + deltaX*deltaX) / 100;
				
				selected.setVector((float)angle, (float)distance);
				
				state = SELECTED_STATE;
			}
			
		}
		
		public void mouseClicked(MouseEvent e) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			// Deselect:
			if (state==SELECTED_STATE) {
				boolean flag = false;
				for (GraphicsObject s : camera.drawnObjects)
					if (s.contains(mouseX, mouseY)) flag = true;
				if (flag == false) {
					state = DEFAULT_STATE;
					//selected.selected = false;
					selected.deselect();
					selected = null;
					camera.controlObjects.clear();
				}
						
			}
		}
		
	};
	
	public MouseMotionListener mousemotionlistener = new MouseMotionListener() {
		public void mouseMoved(MouseEvent e) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			// Scroll at screen edges:
			if(mouseX <= SCROLL_BORDER || mouseX >= camera.WIDTH - SCROLL_BORDER 
					|| mouseY <= SCROLL_BORDER || mouseY >= camera.HEIGHT - SCROLL_BORDER)
				edgeScroll(e);
			
		}
		
		public void mouseDragged(MouseEvent e) {

			if((state==SELECTED_STATE || state==DRAGGING_STATE)) {
				//if (selected.graphicsObject != null ) {
				if (selected != null ) {
					state = DRAGGING_STATE;
					
					// Draw a line from the selected unit to the mouse.
					int mouseX = e.getX();
					int mouseY = e.getY();
					
					double selectedX = selected.graphicsObject.x;
					double selectedY = selected.graphicsObject.y;
					
					Line2D.Double pointLine = new Line2D.Double(mouseX, mouseY, selectedX, selectedY);
					//camera.drawnObjects.add(pointLine);
					camera.controlObjects.clear();
					camera.controlObjects.add(pointLine);
				}
				else {
					state = SELECTED_STATE;
				}
			}
			
		}
		
	};
	
	/**
	 * Scroll the display when the mouse reaches the edges of the screen.
	 * @param e
	 */
	private void edgeScroll(MouseEvent e) {
		int x_coord = e.getX();
		int y_coord = e.getY();
		
		int deltaX = 0;
		int deltaY = 0;
		
		if (x_coord < 20) { deltaX = -10; }
		if (x_coord > camera.WIDTH - 20) { deltaX = 10; }
		if (y_coord < 20) { deltaY = -10; }
		if (y_coord > camera.HEIGHT  - 20) { deltaY = 10; }
		
		if (deltaX != 0 || deltaY != 0) camera.moveView(camera.min_x + deltaX, 
				camera.min_y + deltaY, camera.zoom); 
	}
	
	
	/*
	 * Button Action Listeners
	 */
	
	public ActionListener fullStopPressed = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (selected != null)
				selected.setVector(0,0);
		}
	};
	
}
