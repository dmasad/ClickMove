package snarkhunt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clickmove.worldmodel.SubSystem;
import clickmove.worldmodel.World;

/**
 * The ship subsystem that deploys missiles.
 * @author dmasad
 *
 */
public class MissileLauncher extends SubSystem<Integer> {
	
	World gameWorld;
	
	JPanel component;
	JLabel lblCounter;
	JButton btnLaunch;
	
	/**
	 * Initiate a new MissileLauncher subsystem
	 * @param world: The game world object 
	 * @param parentObj: The parent WorldObj; e.g. the ship carrying the launcher
	 * @param value: The number of missiles the ship starts out with.
	 */
	public MissileLauncher(World world, MissileBoat parentObj, int value) {
		super(parentObj, value);
		gameWorld = world;
		
		// Container:
		component = new JPanel();
		component.setPreferredSize(new Dimension(250, 100));
		
		// Label and button:
		lblCounter = new JLabel("Missiles Remaining: "+value);
		btnLaunch = new JButton("Launch Missile");
		btnLaunch.addActionListener(actionListener);
		
		component.add(lblCounter);
		component.add(btnLaunch);
	}
	
	public JPanel setupComponent() {
		return component;
	}
	
	public void fireMissile() {
		value--;
		// TODO: Spawn code goes here.
	}
	
	private ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			value--;
			if (value==0) btnLaunch.setEnabled(false);
			lblCounter.setText("Missiles Remaining: " + value);
			
			//Deploy missile:
			//MissileBoat mb = (MissileBoat) rootObj;
			Missile newMissile = new Missile( ((MissileBoat)rootObj).xSpeed, ((MissileBoat)rootObj).ySpeed);
			newMissile.x = ((MissileBoat)rootObj).x + 10; // Missile starts out 10 ticks ahead of parent.
			newMissile.y = ((MissileBoat)rootObj).y + 10;
			gameWorld.add_object(newMissile);
			
			
		}
	};
}
