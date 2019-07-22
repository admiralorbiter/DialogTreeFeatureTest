package Panels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Application.ConversationParser;
import Conversation.ConversationNode;
import Text.Textbox;

public class TextFeatures extends Panel implements KeyListener{

	Textbox textbox = new Textbox(null);
	ConversationNode conversation;
	
	@Override
	public void init() {
		System.out.println("Test");
		addKeyListener(this);
		conversation=ConversationParser.ConversationParser("src/Application/test.txt");
		ConversationNode.printList(conversation);
	}
	
	@Override
	public void run() {
		/*conversation=ConversationParser.ConversationParser("src/Application/test.txt");
		ConversationNode.printList(conversation);
		System.exit(0);*/
		textbox = new Textbox(ConversationParser.getCurrentConversationText(conversation));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		textbox.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE && textbox.isActive()) {
			textbox.update();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
