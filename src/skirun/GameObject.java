package skirun;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	
	public static BufferedImage crashedImg;
	public static BufferedImage hurdleImg;
	public static BufferedImage treeImg;
	
	GameObject() throws IOException{
	
	crashedImg = ImageIO.read(this.getClass().getResourceAsStream("crashed.png"));
	hurdleImg = ImageIO.read(this.getClass().getResourceAsStream("hurdle.png"));
	treeImg = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
	
	}
	
	GameObject(int x, int y, int height, int width) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		collisionBox = new Rectangle();

	}
	
	
}
