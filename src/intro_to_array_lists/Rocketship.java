package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	Rocketship(int x, int y, int width, int height,int speed) {
		super(x, y, width, height);
		this.speed=speed;
		// TODO Auto-generated constructor stub
	}
	void update() {
		super.update();
		if (up) {
			y--;
		}
		else if (down) {
			y++;
		} 
		else if (left) {
			x--;
		}
		else if (right) {
			x++;
		}
	}
	void draw(Graphics graphics) {
		  graphics.drawImage(GamePanel.rocketImg, x, y, width, height, null);



	}
}
