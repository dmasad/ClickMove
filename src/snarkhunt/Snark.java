package snarkhunt;

import java.awt.Color;
import java.util.ArrayList;

import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.World;
import clickmove.worldmodel.WorldObj;

public class Snark extends WorldObj {
	
	//World world;
	Sensor sensor;
	
	public ArrayList<WorldObj> detectedObjects = new ArrayList<WorldObj>();
	
	public Snark(World thisWorld) {
		selectable = false;
		//world = thisWorld;
		visible = false;	
		sensor = new Sensor(this, false, 100, 10);
		graphicsObject = new CircleGraphic(this, 0, 0, 8, Color.RED);
	}
	
	public void update(int timestep) {
		// Write basics of AI loop here.
	}
	
	public void setVector(float angle, float magnitude) {
		// Pass; snarks are static.
	}
	
	public void setDetected() {
		visible = true;
	}
	
	public GraphicsObject setGraphicsObject(int xCoord, int yCoord) {
		graphicsObject.setCoords(xCoord, yCoord);
		return graphicsObject;
	}
}
