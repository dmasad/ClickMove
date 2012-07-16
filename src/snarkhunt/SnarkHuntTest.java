package snarkhunt;

import clickmove.graphics.MainGame;
import clickmove.worldmodel.World;


public class SnarkHuntTest extends MainGame {
	
		public SnarkHuntTest()
		{
			super(new SnarkHuntWorld());
			
			MissileBoat boat1 = new MissileBoat(world);
			boat1.x = 100;
			boat1.y = 100;
			boat1.acceleration = 0.0005;
			
			Snark snark1 = new Snark(world);
			snark1.x = 250;
			snark1.y = 250;
			
			world.add_object(boat1);
			world.add_object(snark1);
			
			((SnarkHuntWorld)world).aiObjects.add(snark1);
			((SnarkHuntWorld)world).playerObjects.add(boat1);
		}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			SnarkHuntTest test = new SnarkHuntTest();
			new Thread(test).start();
		}

	}


