import javax.swing.JFrame;


public class Main {

	private JFrame frame;
	private Screen screen;
	
	public Main() {
		frame = new JFrame();
		screen = new Screen();
		screen.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(screen);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
