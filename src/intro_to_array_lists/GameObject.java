package intro_to_array_lists;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean up, down, left, right;
	boolean isAlive=true;
	Graphics graphics; 
	GameObject(int x, int y, int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {

	}
	void draw(Graphics graphics) {

	}
}
