package clickmove.graphics;

import clickmove.worldmodel.*;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGame implements Runnable {
	
	protected World world; // Game world.
	
	// Dimensions:
	final int WIDTH = 800;
	final int HEIGHT = 600;
	
	// Frame rate information:
	long targetFPS  = 60;
	long targetDeltaLoop = (1000 * 1000 * 1000)/targetFPS;
	
	boolean running = true;
	
	// GUI Components:
	JFrame frame;
	Camera camera;
	
	public MainGame(World newWorld)
	{
		world = newWorld;
		
		frame = new JFrame("Main Game");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);
		
		camera = new Camera(world, WIDTH, HEIGHT);
		panel.add(camera);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		camera.init_buffering();
	}
	
	/**
	 * The main game loop
	 */
	public void run() {
		// Timing variables:
		long beginLoopTime;
		long endLoopTime;
		long currentUpdateTime = System.nanoTime();
		long lastUpdateTime;
		long deltaLoop;
		
		while(running) {
			beginLoopTime = System.nanoTime();
			
			camera.render();
			
			lastUpdateTime = currentUpdateTime;
			currentUpdateTime = System.nanoTime();
			
			//TODO: Update world here.
			world.update(1);
			
			endLoopTime = System.nanoTime();
			deltaLoop = endLoopTime - beginLoopTime;
			
			// Control speed:
			if (deltaLoop > targetDeltaLoop) { /* Pass */}
			else {
				try {
					Thread.sleep( (targetDeltaLoop - deltaLoop)/(1000*1000));
				} catch (InterruptedException e) { /* Pass */}
			}
		}
		
		
	}

}
