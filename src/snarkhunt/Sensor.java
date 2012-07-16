package snarkhunt;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import clickmove.worldmodel.SubSystem;
import clickmove.worldmodel.WorldObj;

/**
 * A sensor has two states: active (value==true) and passive (value==false).
 * Each state has a range associated with it.
 * @author dmasad
 *
 */
public class Sensor extends SubSystem<Boolean> {
	
	// Range definition
	double activeRange;
	double passiveRange;
	
	// GUI components:
	JPanel component;
	// TODO Add radio buttons.
	JRadioButton rdoYes;
	JRadioButton rdoNo;
	ButtonGroup sensorButtons; 
	
	public Sensor(WorldObj parentObj, Boolean active, double aRange, double pRange ) {
		super(parentObj, active);
		activeRange = aRange;
		passiveRange = pRange;
		value = false;
		setupRadioButtons();
	}
	
	private void setupRadioButtons() {
		rdoYes = new JRadioButton();
		rdoNo = new JRadioButton();
		
		rdoYes.setText("Active");
		rdoNo.setText("Passive");
		
		rdoYes.setActionCommand("Yes");
		rdoNo.setActionCommand("No");
		
		rdoNo.setSelected(true);
		
		rdoYes.addActionListener(actionListener);
		rdoNo.addActionListener(actionListener);
		
		sensorButtons = new ButtonGroup();
		sensorButtons.add(rdoYes);
		sensorButtons.add(rdoNo);
		
		component = new JPanel();
		component.setPreferredSize(new Dimension(250, 100));
		component.add(rdoYes);
		component.add(rdoNo);
	}
	
	public JPanel setupComponent() {
		return component;
	}
	
	public Boolean getValue() {
		return value;
	}
	
	public double getRange() {
		if (value==true) return activeRange; 
		return passiveRange;
	}
	
	
	
	private ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Yes")
				value = true;
			if (e.getActionCommand() == "No")
				value = false;
			System.out.println("" + value);
		}
	};
	
	
	

}
