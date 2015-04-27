package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Moves.Move;
import Moves.conditionalMove;
import Panels.MainGamePanel;
import Panels.SelectPanel;
import Panels.StratPanel;

public class conditionalMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	MainGamePanel mgp; 
	private String conditional;
	private JButton redSquare = new JButton("Red Square");
	private JButton blueSquare = new JButton("Blue Square");
	private JButton bracket = new JButton("}");
	
	
	
	
	//Constructor
	public conditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, MainGamePanel mainPanel)
	{
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		mgp = mainPanel; 
		conditional = null;
	
	}
	
	public void displayConditionalOptions()
	{
		selectPanel.removeAll();
		selectPanel.resetSelectOptions();
		
		
		redSquare.addActionListener(this);
		blueSquare.addActionListener(this);
		bracket.addActionListener(this);
	
		selectPanel.add(redSquare);
		selectPanel.add(blueSquare);
		
		selectPanel.revalidate();
		selectPanel.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource().equals(redSquare))
		{
			conditional = "Red Square";
			((conditionalMove) toAdd).setConditionalMove("red square");
			stratPanel.addMove(toAdd); 
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			selectPanel.removeAll();
			selectPanel.reset(false);
			selectPanel.add(bracket);
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		else if(e.getSource().equals(blueSquare))
		{
			conditional = "Blue Square";
			((conditionalMove) toAdd).setConditionalMove("blue square");
			stratPanel.addMove(toAdd); 
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			selectPanel.removeAll();
			selectPanel.reset(false);
			selectPanel.add(bracket);
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		else if(e.getSource().equals(bracket))
		{
			stratPanel.add(new JLabel("}"));
			
			selectPanel.removeAll();
			selectPanel.resetSelectOptions();
			selectPanel.reset(true);
			
			selectPanel.revalidate();
			selectPanel.repaint();
			
			selectPanel.setAddToConditional(false);
		}
		else{
		//Only add the move if the user has moves available
			if (stratPanel.currentNumberMovesAvailable > 0) {
				
				selectPanel.setAddToConditional(true); 
				selectPanel.resetSelectOptions();
			
				displayConditionalOptions();
				
				stratPanel.revalidate();
				selectPanel.revalidate();
			}
		}
			
	}

}
