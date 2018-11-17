package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed = 10;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics graphics) {
		graphics.setColor(Color.RED);

		graphics.fillRect(x, y, width, height);	
	}
	void update() {
		super.update();
		int num=y-speed;
		if (y>0) {
			isAlive=false;	
		}

	}

}
