package Panels;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Moves.Move;


//The StratPanel holds an ArrayList of the currentStrategy the player has implemented
public class StratPanel extends JPanel implements ActionListener{

	private ArrayList<Move> currentStrat;
	private SelectPanel selectPanel; 
	
	
	//Default Constructor for the StratPanel
	public StratPanel()
	{
		initGUI();

		currentStrat = new ArrayList<Move>();

	}
	public void setSelectPanel(SelectPanel newSelectPanel)
	{
		selectPanel = newSelectPanel; 
	}
	
	//When the clear button is pressed, clear the current strategy and repaint the StratPanel
	public void clearCurrentStrat()
	{
		currentStrat.clear(); 
		removeAll(); 
		initGUI(); 
		
		selectPanel.setAddToWhile(false); 
		selectPanel.resetSelectOptions();
		 
		setVisible(true); 
	}
	
	//Instantiate the location of the Panel, and create the button that can be used to clear the current strategy
	public void initGUI()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JButton clearButton = new JButton();
		clearButton.setText("CLEAR");
		clearButton.addActionListener(this);

		add(clearButton);
	}

	//Getter for the current Strategy
	public ArrayList<Move> getCurrentStrat(){
		return  currentStrat;
	}
	
	//When the user selects a move, it is added to the ArrayList
	public void addMove(Move toAdd) {
		currentStrat.add(toAdd);
	}

	//When the clear button is pressed,  it calls the clearCurrentStrat function
	public void actionPerformed(ActionEvent e) {
		clearCurrentStrat(); 
	}

}