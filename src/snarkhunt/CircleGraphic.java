package snarkhunt;

import clickmove.graphics.Camera;
import clickmove.graphics.graphicsobjects.GraphicsObject;
import clickmove.worldmodel.WorldObj;

public class CircleGraphic extends GraphicsObject {

	public CircleGraphic(Camera myCamera, WorldObj underlyingObj, int xCoord, int yCoord) {
		super(myCamera, underlyingObj, xCoord, yCoord);
	}
}
