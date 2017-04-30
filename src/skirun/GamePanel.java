package skirun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Skier ski = new Skier(400, 75, 50, 50);
	
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer(50 / 3, this);
	}

	
	
	ObjectManager manager = new ObjectManager();

	void startGame() {

		timer.start();
	}

	void updateMenuState() {
	}

	void updateGameState() {

		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		
		if(ski.isAlive == false){
			currentState = END_STATE;
			manager.reset();
			manager.addObject(ski);
			
		}

	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {


	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Skirun.width, Skirun.height);
		manager.draw(g);

	}

	void drawEndState(Graphics g) {


	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keytyped");

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("keypressed");
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			ski.left = true;

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			ski.right = true;

		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyreleased");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ski.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ski.left = false;
		}

	}

}