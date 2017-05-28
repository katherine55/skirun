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

//	public static BufferedImage crashedImg;
//	public static BufferedImage hurdleImg;
//	public static BufferedImage treeImg;

//	GameObject() throws IOException {
//
//
//	}

	GameObject(int x, int y, int height, int width) {
//
//		try {
////			crashedImg = ImageIO.read(this.getClass().getResourceAsStream("/crashed.png"));
////			hurdleImg = ImageIO.read(this.getClass().getResourceAsStream("/hurdle.png"));
////			treeImg = ImageIO.read(this.getClass().getResourceAsStream("/tree.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		
		
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		collisionBox = new Rectangle();

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
//		y+=2;
	}

	void draw(Graphics g) {
		System.out.println("Ran");
	//	g.drawImage(crashedImg, x, y, width, height, null);
		
	}

}
