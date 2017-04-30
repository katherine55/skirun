package skirun;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skirun {
	
	JFrame myFrame = new JFrame();
	static final int width = 500;
	static final int height = 800;
	GamePanel myGamePanel;

	Skirun(){
		
		myGamePanel = new GamePanel();
		myFrame = new JFrame("Ski Run");
		myFrame.setSize(width, height);
		myFrame.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		
		new Skirun();

	}

}
