package Buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

public class TitlePageButton extends JButton {
	
	public Color buttonColor = Color.getHSBColor((float).58, (float)0.42, (float)0.9);
	public Color fontColor = Color.BLACK;
	private String button_text;
	private int xStagger;
	private int button_width = 200;
	private int button_height = 50;
	
	public TitlePageButton(String text, int staggerX) {
		super(text);
		button_text = text;
		xStagger = staggerX;
		initGUI();
	}
	
	public void setButtonColor(Color c){
		buttonColor = c;
	}
	
	public void setFontColor(Color c){
		fontColor = c;
	}
	
	public void setSize(int width, int height){
		button_width = width;
		button_height = height;
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
	}
	
	public void initGUI(){
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setContentAreaFilled(false);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(buttonColor);
		g.fillRect(0, 0, button_width, button_height);
		g.setColor(fontColor);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.drawString(button_text, xStagger, 33);
	}
}