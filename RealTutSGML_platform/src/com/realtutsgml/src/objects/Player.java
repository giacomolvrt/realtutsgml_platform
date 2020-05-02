package com.realtutsgml.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.realtutsgml.src.GlobalPosition;
import com.realtutsgml.src.input.Controller;

public class Player extends GlobalPosition {
	
	private String playerimage = "/images/player.png";
	
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	int velX = 0;
	int velY = 0;
	int stop = 0;

	public Player(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		
		//Aggiorno la posizione rispetto alla velocità
		x += velX;
		y += velY;
				
		//COLLISION WITH OUTSIDE
		if (x < 0) {
			x = 0;
			System.out.println("bordo sinistro");
		}
		if (y < 0) {
			y = 0;
			System.out.println("bordo alto");
		}
		if (x > 608) {
			x = 608;
			System.out.println("bordo dx");
		}
		if (y > 427) {
			y = 427;
			System.out.println("bordo basso");
		}
		
		Collision();
	}
	
	public void Collision() {
		for (int i = 0; i < e.size(); i++) {
			if (getBounds().intersects(e.get(i).getBounds())) {
				System.out.println("COLLISION!"+i);
				//stop = 1;
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key==KeyEvent.VK_RIGHT) {
			velX = 5;
		} else if (key==KeyEvent.VK_LEFT) {
			velX = -5;
		} else if (key==KeyEvent.VK_DOWN) {
			velY = 5;
		} else if (key==KeyEvent.VK_UP) {
			velY = -5;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key==KeyEvent.VK_RIGHT) {
			velX = 0;
		} else if (key==KeyEvent.VK_LEFT) {
			velX = 0;
		} else if (key==KeyEvent.VK_DOWN) {
			velY = 0;
		} else if (key==KeyEvent.VK_UP) {
			velY = 0;
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), x, y, null);		
		//g2d.draw(getBounds()); Non disegno il rettangolo intorno
		
	}
	
	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 26, 26);
	}
	
	public boolean isStopped(Player p) {
		if (p.stop == 1)
			return true;
		return false;
	}
	
	public void Continue(Player p) {
		p.stop = 0;
	}
}
