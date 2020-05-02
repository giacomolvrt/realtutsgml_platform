package com.realtutsgml.src.input;

import java.awt.Graphics2D;
import java.util.LinkedList;

import com.realtutsgml.src.objects.Enemy;

public class Controller {
	
	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	Enemy TempEnemy;
	
	public Controller() {
		addEnemy(new Enemy(100,100));
		addEnemy(new Enemy(200,100));
		addEnemy(new Enemy(300,200));
		addEnemy(new Enemy(450,300));
		addEnemy(new Enemy(398,365));
		addEnemy(new Enemy(150,50));
		addEnemy(new Enemy(30,100));
		addEnemy(new Enemy(200,250));
	}
	
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			
			TempEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for (int i = 0; i < e.size(); i++) {
			TempEnemy = e.get(i);
			
			TempEnemy.update();
		}
	}
	
	public static LinkedList<Enemy> getEnemyBounds() {
		return e;
	}
	
	public void addEnemy(Enemy enemy) {
		e.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		e.remove(enemy);
	}

}
