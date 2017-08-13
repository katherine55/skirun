package skirun;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		if (y > Skirun.height) {

			isAlive = false;

		}
		// y+=2;
	}

	void draw(Graphics g) {
		System.out.println("Ran");
		// g.drawImage(crashedImg, x, y, width, height, null);

	}

}
