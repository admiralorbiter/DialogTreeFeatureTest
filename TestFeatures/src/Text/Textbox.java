package Text;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Application.Settings;

public class Textbox {

	private List<Text> textArray = new ArrayList<Text>();
	private boolean active=false;
	private int index=0;
	
	public Textbox(List<Text> textArray) {
		if(textArray!=null)
			active=true;
		
		this.textArray=textArray;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		if(active) {
			g.setColor(Color.gray);
			g.fill3DRect(100, Settings.getScreensize().height-400, Settings.getScreensize().width-200, 250, true);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			for(int i=0; i<textArray.get(index).text.size(); i++) {
				g.drawString(textArray.get(index).text.get(i), 150, Settings.getScreensize().height-350+i*30);
			}
		}
	}
	
	//Getters and Setters
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active=active;}
	
}
