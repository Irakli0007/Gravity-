import java.awt.Color;
import java.awt.Graphics;


public class Platform {

	private int width = 150;
	private int height = 25;
	
	private int x, y, xVel = 7;
	
	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void travel() {
		x -= xVel;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
		
	}
	
}
