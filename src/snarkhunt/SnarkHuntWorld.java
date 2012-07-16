package snarkhunt;

import java.util.ArrayList;

import clickmove.worldmodel.World;
import clickmove.worldmodel.WorldObj;

public class SnarkHuntWorld extends World {

	ArrayList<WorldObj> playerObjects = new ArrayList<WorldObj>();
	ArrayList<Snark> aiObjects = new ArrayList<Snark>();
	
	public void update(int timestep) {
		
		// Find who has detected whom
		for (WorldObj ship : playerObjects) {
			for (Snark snark : aiObjects) {
					double d = findDistance(ship, snark);
					if (d < ((MissileBoat)ship).sensor.getRange()) snark.visible = true; // Ship sees Snark
					if (d < snark.sensor.getRange()) snark.detectedObjects.add(ship); // Snark sees ship
				
			}
		}
		
		// Finally, advance everything by a timestep.
		for (WorldObj worldobj : allWorldObjects)
		{
			worldobj.update(timestep);
		}
	}
	
	
	private double findDistance(WorldObj a, WorldObj b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		double d = Math.sqrt(dx*dx + dy*dy); 
		//System.out.println("" + d);
		return d;
	}
	
}
