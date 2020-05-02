package com.realtutsgml.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import com.realtutsgml.src.GlobalPosition;
import com.realtutsgml.src.MainClass;

public class Enemy extends GlobalPosition {
	
	private String enemyimage = "/images/enemy.png";
	
	int speedX, speedY;

	public Enemy(int x, int y) {
		super(x, y);
		double rX = Math.random() * 7;
		double rY = Math.random() * 5;
		speedX = (int) rX + 1;
		speedY = (int) rY + 1;
	}
	
	public void update() {
		x += speedX; //è questo che fa muovere l'oggetto
		if (x > MainClass.WIDTH-32) {
			speedX = speedX*(-1);
		}
		if (x < 0) {
			speedX = speedX*(-1);
		}
		y += speedY; //è questo che fa muovere l'oggetto
		if (y > MainClass.HEIGHT-50) {
			speedY = speedY*(-1);
		}
		if (y < 0) {
			speedY = speedY*(-1);
		}

	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(), x, y, null);
	}
	
	public Image getEnemyImage() {

		ImageIcon i = new ImageIcon(getClass().getResource(enemyimage));
		return i.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 26, 26);
	}

}
