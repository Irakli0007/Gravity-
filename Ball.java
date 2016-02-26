import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int radius;
	private int x;
	private int y;
	private double grav = 0.98;
	private double xVel = 5;
	private double yVel = 9.8;
	private double time = 0;
	
	public boolean movingRight = false;
	public boolean movingLeft = false;
	
	public Ball(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;

	}
	
	public void jump() {
		checkBounds();
		yVel = yVel - (grav * time);
		y = (int) (y - yVel);
		time += 0.01;
		if(movingRight) {
			x += xVel;
		}
		if(movingLeft) {
			x -= xVel;
		}
	}

	public void checkBounds() {
		if(y > 650) {
			yVel = 9.8;
			time = 0;
		}
		if(x < 0) {
			x = 0;
		}
		if(x > 1080 - 2 * radius) {
			x = 1080 - 2 * radius;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, radius * 2, radius * 2);
	}
	
}
