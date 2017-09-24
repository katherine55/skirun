package skirun;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;

	int randX = new Random().nextInt(Skirun.width / 2);

	long enemyTimer = 0;
	long treeTimer = 0;
	int enemySpawnTime = 700;
	int treeSpawnTime = 300;

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		purgeObjects();
	}

	// START HERE
	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);

		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies() {

		int randChange = new Random().nextInt(100) - 50;

		long timer = System.currentTimeMillis();

		if (timer - enemyTimer >= enemySpawnTime) {

			addObject(new Obstacle(new Random().nextInt(Skirun.width - 100), 
					0, 100, 100, new Random().nextInt(3)));
			enemyTimer = System.currentTimeMillis();

		}
		if (timer < 1) {
			addObject(new Obstacle(randX, 0, 100, 100, 4));
			addObject(new Obstacle(randX + 400, 0, 100, 100, 4));
			enemyTimer = System.currentTimeMillis();
		}

		if (timer - treeTimer >= treeSpawnTime) {

			addObject(new Obstacle(randX, 0, 100, 100, 4));
			addObject(new Obstacle(randX + 450, 0, 100, 100, 4));
			randX += randChange;

			treeTimer = System.currentTimeMillis();

			if (randX < 50) {
				randX += 10;
			}

			if (randX > 950) {
				randX -= 10;
			}

		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);

				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof GameObject && o2 instanceof Skier)
							|| (o2 instanceof GameObject && o1 instanceof Skier)) {
						score++;
						System.out.println(score);
						o1.isAlive = false;
						o2.isAlive = false;
					} else if ((o1 instanceof GameObject && o2 instanceof Skier)
							|| (o2 instanceof GameObject && o1 instanceof Skier)) {
						o1.isAlive = false;
						o2.isAlive = false;
					}

				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}
