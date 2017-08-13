package skirun;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacle extends GameObject {

	int speed;
	static boolean left;
	static boolean right;
	int id;
	int sheight;
	int swidth;
	int counter;
	int spriteX;
	int spriteY;

	public static BufferedImage crashedImg;
	public static BufferedImage hurdleImg;
	public static BufferedImage treeImg;
	public static BufferedImage treeGif;

	Obstacle(int x, int y, int width, int height, int id) {

		super(x, y, width, height);
		if (crashedImg == null) {
			try {

				crashedImg = ImageIO.read(this.getClass().getResourceAsStream("/crashed.png"));
				hurdleImg = ImageIO.read(this.getClass().getResourceAsStream("/hurdle.png"));
				treeImg = ImageIO.read(this.getClass().getResourceAsStream("/tree.png"));
				treeGif = ImageIO.read(this.getClass().getResourceAsStream("/Trees.png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		speed = 5;
		this.id = id;
		swidth = treeGif.getWidth() / 3;
		sheight = treeGif.getHeight() / 3;

	}

	void update() {
		super.update();

		y += 5;
	}

	void draw(Graphics g) {
		
		//*****TREE GIF DO NOT REMOVE*****
		if (id ==4){
		if(counter%60==0){
			spriteX++;
			
			if(spriteX%3==0){
				spriteX%=3;
				spriteY++;
				spriteY%=3;
			}
			
			
		}
		
		g.drawImage(treeGif.getSubimage(swidth*spriteX, sheight*spriteY, swidth, sheight), x, y, width+55, height+55, null);}

		if (id == 0) {
			System.out.println("crashed0");
			g.drawImage(crashedImg, x, y, width, height, null);
		}

		else if (id == 1) {
			System.out.println("hurdle1");
			g.drawImage(hurdleImg, x, y, width, height, null);
		}

		else if (id == 2) {
			System.out.println("tree2");
			g.drawImage(treeImg, x, y, width, height, null);
		}

	}

}
