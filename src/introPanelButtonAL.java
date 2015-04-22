import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//When the Player indicates that they are ready to start playing the game from the button on the
//introPanel, this class moves the display from the introPanel to the actual Game.
public class introPanelButtonAL implements ActionListener{
	//Holds an instance of the Game
	Game game; 
	
	//Constructor- Takes in the game so that when the button is called, it adds the maingamePanel to the display
	public introPanelButtonAL(Game g)
	{
		game = g; 
	}
	
	//When the button is pressed, this actionPerformed changes the display to the actual game.
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Removes the introPanel
		game.removeAll(); 
		//adds the mainGamePanel
		game.add(game.mainGamePanel); 
		//Sets the game Visible
		game.setVisible(false); 
		game.setVisible(true); 
		//Repaints the game, now with the mainGamePanel displaying.
		game.repaint(); 		
	}

}
