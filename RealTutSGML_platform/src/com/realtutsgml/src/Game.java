package com.realtutsgml.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.realtutsgml.src.input.Controller;
import com.realtutsgml.src.input.KeyInput;
import com.realtutsgml.src.objects.Player;

public class Game extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String background = "/images/bg.png";
	
	Timer gametimer;
	Player p;
	Controller c;
	int[] provax = new int[5];
	int[] provay = new int[5];

	public Game() {
		setFocusable(true);
		
		gametimer = new Timer(1, this);
		gametimer.start();
		
		p = new Player(5, 5);
		c = new Controller();
		
		addKeyListener(new KeyInput(p));
	}
	
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		p.draw(g2d);
		c.draw(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (!p.isStopped(p)) {
		p.update();
		c.update();
		repaint();
		} else {
            long t0, t1;
            t0 = System.currentTimeMillis();
            do {
            	t1 = System.currentTimeMillis();
            } while (t1 - t0 < 500);
			p.Continue(p);
			
		}
	}

}
