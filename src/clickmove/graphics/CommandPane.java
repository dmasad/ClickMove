/**
 * 
 */
package clickmove.graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;

/**
 * 
 * @author dmasad
 *
 */
public class CommandPane extends JPanel {
	
	// Data sources:
	public Controller controller;
	
	// State variables:
	int DEFAULT_STATE = 0;
	int SELECTED_STATE = 1;
	
	// Components:
	JLabel lbl_summaryHeader = new JLabel("Unit Summary");
	JLabel lbl_name = new JLabel();
	JLabel lbl_xCoord = new JLabel("X: ");
	JLabel lbl_yCoord = new JLabel("Y: ");
	JButton btn_fullStop = new JButton("Full Stop");
	
	private void drawComponents() {
		add(lbl_summaryHeader);
		add(lbl_name);
		add(lbl_xCoord);
		add(lbl_yCoord);
		add(new JSeparator());
		
		btn_fullStop.setEnabled(false);
		add(btn_fullStop);
		
	}
	
	public void setupListeners() {
		btn_fullStop.addActionListener(controller.fullStopPressed);
	}
	
	public CommandPane() { 
		super();
		drawComponents();
		
	}
	
	public void repaint() {
		if (controller == null) {
			super.repaint();
			return;
		}
		
		if(controller.selected != null) {
			lbl_xCoord.setText("X: " + controller.selected.x);
			lbl_yCoord.setText("Y: " + controller.selected.y);
			btn_fullStop.setEnabled(true);
		} else {
			lbl_xCoord.setText("X: ");
			lbl_yCoord.setText("Y: ");
			btn_fullStop.setEnabled(false);
		}
		
		super.repaint();
	}
}
