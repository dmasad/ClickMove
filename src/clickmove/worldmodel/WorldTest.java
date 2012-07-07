package clickmove.worldmodel;

public class WorldTest {

	/**
	 * @param args
	 */
	
	World testWorld;
	
	public void print_coords()
	{
		for (WorldObj obj : testWorld.allWorldObjects) {
			System.out.printf("%f\t%f\n", obj.x, obj.y);
		}
	}
	
	public void test1()
	{
		testWorld = new World(); 
		MobileObj particle1 = new MobileObj(0.0, 0.0);
		MobileObj particle2 = new MobileObj(2, 4);
		
		particle1.x_speed = 2;
		particle1.y_speed = 2;
		
		testWorld.add_object(particle1);
		testWorld.add_object(particle2);
		
		System.out.println(testWorld.allWorldObjects.size());
		
		print_coords();
		testWorld.update(1);
		print_coords();
	}
	
	
	public static void main(String[] args) {
		WorldTest test = new WorldTest();
		test.test1();

	}

}
