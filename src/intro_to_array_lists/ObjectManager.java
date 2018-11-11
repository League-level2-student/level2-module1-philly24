package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {  
Rocketship rocket;
long enemyTimer=0;
int enemySpawnTime=3000;

ArrayList<Projectile> projectile = new ArrayList<Projectile>();
ObjectManager(Rocketship rocket){
	this.rocket = rocket;
}
ArrayList<Aliens>aliens= new ArrayList<Aliens>();
void update() {
	rocket.update();
	for (int i = 0; i < projectile.size(); i++) {
		projectile.get(i).update();
		
	}
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();
	}
}      
void draw(Graphics graphics) {
	rocket.draw(graphics);
	for (int i = 0; i < projectile.size(); i++) {
	projectile.get(i).draw(graphics);
	aliens.get(i).draw(graphics);
}

}
void addProjectile(Projectile projectile) {
	this.projectile.add(projectile);
}
void addAliens(Aliens aliens) {
	this.aliens.add(aliens);
}
public void manageEnemies(){
    if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAliens(new Aliens(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
    }
}
void purgeObjects(){
for (int i = 0; i < aliens.size(); i++) {
	if (aliens.get(i).isAlive==false) {
		aliens.remove(aliens.get(i));
	}
}
}
}
