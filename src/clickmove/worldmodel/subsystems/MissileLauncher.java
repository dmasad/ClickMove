package clickmove. worldmodel.subsystems;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clickmove.worldmodel.SubSystem;
import clickmove.worldmodel.WorldObj;

public class MissileLauncher extends SubSystem<Integer> {
	
	JPanel component;
	JLabel lblCounter;
	JButton btnLaunch;
	
	
	public MissileLauncher(WorldObj obj, int value) {
		super(obj, value);
		
		// Container:
		component = new JPanel();
		component.setPreferredSize(new Dimension(250, 100));
		
		// Label and button:
		lblCounter = new JLabel(""+value);
		btnLaunch = new JButton("Launch Missile");
		btnLaunch.addActionListener(actionListener);
		
		component.add(lblCounter);
		component.add(btnLaunch);
	}
	
	public JPanel setupComponent() {
		return component;
	}
	
	private ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			value--;
			if (value==0) btnLaunch.setEnabled(false);
			lblCounter.setText("" + value);
		}
	};
}
