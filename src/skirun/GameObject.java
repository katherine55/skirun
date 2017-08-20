package skirun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;

	boolean isAlive = true;

	Rectangle collisionBox;

	GameObject(int x, int y, int height, int width) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		collisionBox = new Rectangle();

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
		System.out.println("hi");
		if (y > Skirun.height) {

			isAlive = false;

		}
		// y+=2;
	}

	void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		System.out.println("Ran");
		// g.drawImage(crashedImg, x, y, width, height, null);

	}

}
