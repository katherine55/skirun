package skirun;

import javax.swing.JFrame;

public class Skirun {

	JFrame myFrame = new JFrame();
	static final int width = 500;
	static final int height = 800;
	GamePanelSki myGamePanel;

	Skirun() {

		myGamePanel = new GamePanelSki();
		myGamePanel.startGame();
		myFrame = new JFrame("Ski Run");
		myFrame.setSize(width, height);
		myFrame.add(myGamePanel);
		myFrame.addKeyListener(myGamePanel);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}

	public static void main(String[] args) {

		new Skirun();

	}

}
