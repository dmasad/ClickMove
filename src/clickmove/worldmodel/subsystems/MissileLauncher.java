package clickmove.worldmodel.subsystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import clickmove.worldmodel.SubSystem;
import clickmove.worldmodel.WorldObj;

public class MissileLauncher extends SubSystem<Integer> {
	
	JButton component; 
	
	public MissileLauncher(WorldObj obj, int value) {
		super(obj, value);
		
		component = new JButton(""+value);
		component.addActionListener(actionListener);
	}
	
	public JButton setupComponent() {
		return component;
	}
	
	private ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			value--;
			if (value==0) component.setEnabled(false);
			component.setText("" + value);
		}
	};
}
