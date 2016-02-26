import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
	
	private class Input implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
					
			if(key == KeyEvent.VK_D) {
				stopMoving();
				ball.movingRight = true;
			}
			if(key == KeyEvent.VK_A) {
				stopMoving();
				ball.movingLeft = true;
			}
		
		}
		public void keyReleased(KeyEvent e) {
			ball.movingRight = false;
			ball.movingLeft = false;
		}
		public void stopMoving() {
			ball.movingRight = false;
			ball.movingLeft = false;
		}
		
	}
	
	
	private static final long serialVersionUID = 1L;
	static int WIDTH = 1080;
	static int HEIGHT = 720;
	
	private boolean running = false;
	private Ball ball;
	private Input inputs;
	private ArrayList<Platform> platforms;
	
	private int x = 600, y = 300, radius = 30;
	
	public Screen() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		ball = new Ball(x, y, radius);
		inputs = new Input();
		platforms = new ArrayList<Platform>();
		addKeyListener(inputs);
		start();
	
	}
	
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public void run() {
		int count = 0;
		while(running) {
			count++;
			ball.jump();
			for(int i = 0; i < platforms.size(); i++) {
				platforms.get(i).travel();
			}
			repaint();
			if(count == 30) {
				addPlatform();
				count = 0;
			}
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addPlatform() {
		Random rand = new Random();
		int y = rand.nextInt(2);
		int x = rand.nextInt(2);
		y = (y + 1) * (x + 2) * 100;
		platforms.add(new Platform(WIDTH, y));
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLUE);
		ball.draw(g);
		for(int i = 0; i < platforms.size(); i++) {
			platforms.get(i).draw(g);
		}
	}

}
