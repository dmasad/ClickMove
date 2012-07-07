package clickmove.graphics;

import clickmove.worldmodel.*;

import java.lang.Math;

public class MainGameTest extends MainGame {
	
	public MainGameTest()
	{
		super(new World());
		
		MobileObj particle1 = new MobileObj(30, 30);
		MobileObj particle2 = new MobileObj(300, 300);
		
		//particle1.x_speed = 1;
		//particle1.y_speed = 0;
		
		world.add_object(particle1);
		world.add_object(particle2);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainGameTest test = new MainGameTest();
		new Thread(test).start();
	}

}
