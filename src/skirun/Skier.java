package skirun;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Skier extends GameObject {

	int speed;
	static boolean left;
	static boolean right;
	public static BufferedImage skierImg;

	Skier(int x, int y, int width, int height) {
		super(x, y, width, height);
		try {
			skierImg = ImageIO.read(this.getClass().getResourceAsStream("/skier.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speed = 5;
	}

	void update() {
		super.update();

		if (x >= 925) {
			x = 925;
		}
		if (x <= 0) {
			x = 0;
		}
		if (left) {
			x -= speed;

		}
		if (right) {
			x += speed;

		}

	}

	void draw(Graphics g) {

		g.drawImage(skierImg, x, y, width, height, null);

	}

}
