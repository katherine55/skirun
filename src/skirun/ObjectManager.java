package skirun;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
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
//START HERE
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

	public void manageEnemies(){
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			addObject(new GameObject(new Random().nextInt(Skirun.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
					if((o1 instanceof GameObject && o2 instanceof Skier) ||
							(o2 instanceof GameObject && o1 instanceof Skier)){
						o1.isAlive = false;
						o2.isAlive = false;
					}
	
				}
			}
		}
	
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
