package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	y++;
}
void draw(Graphics graphics) {
	graphics.setColor(Color.YELLOW);

	graphics.fillRect(x, y, width, height);
}
}
