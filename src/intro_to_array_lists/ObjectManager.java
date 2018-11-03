package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {  
Rocketship rocket;
boolean isAlive = true;
ArrayList<Projectile> projectile = new ArrayList<Projectile>();
ObjectManager(Rocketship rocket){
	this.rocket = rocket;
}
void update() {
	rocket.update();
	for (int i = 0; i < projectile.size(); i++) {
		projectile.get(i).update();;
		
	}
}      
void draw(Graphics graphics) {
for (int i = 0; i < projectile.size(); i++) {
	projectile.get(i).draw();
	
}	
}
void addProjectile(Projectile projectile) {
	
}
}
