package skirun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanelSki extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	int score;

	Font titleFont;
	Font enterFont;
	Font l1Font;
	Font l2Font;
	Font l3Font;
	Font overFont;
	Font scoreFont;
	Font restartFont;

	ObjectManager manager = new ObjectManager();
	Skier ski = new Skier(400, 555, 90, 90);

	GamePanelSki() {
		timer = new Timer(1000 / 60, this);
		manager.addObject(ski);
		// manager.addObject(new GameObject(200, 200, 100, 100));
		titleFont = new Font("Arial", Font.ITALIC, 48);
		enterFont = new Font("Arial", Font.PLAIN, 24);
		l1Font = new Font("Arial", Font.PLAIN, 24);
		l2Font = new Font("Arial", Font.PLAIN, 24);
		l3Font = new Font("Arial", Font.PLAIN, 24);

		overFont = new Font("Arial", Font.PLAIN, 48);
		scoreFont = new Font("Arial", Font.PLAIN, 24);
		restartFont = new Font("Arial", Font.PLAIN, 24);
		
		
	}

	void startGame() {

		timer.start();
	}

	void updateMenuState() {
		score = 0;
	}

	void updateGameState() {

		manager.update();
		manager.manageEnemies();
		manager.checkCollision();

		if (ski.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			manager.addObject(ski);
			ski.isAlive = true;
			ski.setLocation(400, 555);

		}

		score++;
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, Skirun.width, Skirun.height);

		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Ski Run 3", 150 + 250, 200); // +500

		g.setColor(Color.WHITE);
		g.setFont(enterFont);
		g.drawString("press ENTER to start", 140 + 250, 275); // +500

		g.setColor(Color.WHITE);
		g.setFont(l1Font);
		g.drawString("instructions:", 190 + 250, 325);// +500

		g.setColor(Color.WHITE);
		g.setFont(l2Font);
		g.drawString("use ARROW keys to dodge obstacles", 50 + 250, 450);// +500

		g.setColor(Color.WHITE);
		g.setFont(l3Font);
		g.drawString("DON'T DIE", 192 + 250, 550);// +500
	}

	void drawGameState(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Skirun.width, Skirun.height);
		manager.draw(g);
		drawScore(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Skirun.width, Skirun.height);

		g.setColor(Color.WHITE);
		g.setFont(overFont);
		g.drawString("GAME OVER", 100 + 250, 200);// +500

		g.setColor(Color.WHITE);
		g.setFont(scoreFont);
		g.drawString("You went " + score + " meters", 155 + 250, 250);// +500

		g.setColor(Color.WHITE);
		g.setFont(restartFont);
		g.drawString("press ENTER to restart", 125 + 250, 500);// +500
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

	void drawScore(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(scoreFont);
		g.drawString("" + score, 50, 50);

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