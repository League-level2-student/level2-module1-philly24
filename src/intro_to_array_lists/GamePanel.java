package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject gameobject;
	Rocketship rocket;
	Font titleFont;
	public static BufferedImage alienImg;

    public static BufferedImage rocketImg;

    public static BufferedImage bulletImg;

    public static BufferedImage spaceImg;



	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	int currentState = MENU_STATE;
	ObjectManager objectmanager;
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		rocket= new Rocketship(250,700,50,50,5);
		objectmanager = new ObjectManager(rocket);
		titleFont = new Font("Arial",Font.PLAIN,48);
		try {

            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		objectmanager.update();
		objectmanager.manageEnemies();
		objectmanager.checkCollision();
		objectmanager.purgeObjects();
		if (rocket.isAlive==false) {
			currentState=END_STATE;
		}
	}

	void updateEndState() {
	
		
		
	}

	void drawMenuState(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(titleFont);
		graphics.drawString("League Invaders " , 80, 100);
		graphics.drawString("press enter to play", 60, 400);
		
		
	}

	void drawGameState(Graphics graphics) {
	
		
		graphics.drawImage(GamePanel.spaceImg,0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT,null);
		objectmanager.draw(graphics);
	}

	void drawEndState(Graphics graphics) {
		graphics.setColor(Color.RED);		
		graphics.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		graphics.setFont(titleFont);
		graphics.setColor(Color.BLACK);
		graphics.drawString("Game Over", 80, 80);

		graphics.drawString("your score is "+ objectmanager.getscore(), 80,200 );
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		rocket.update();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics graphics) {
		
		if (currentState == MENU_STATE) {

			drawMenuState(graphics);

		} else if (currentState == GAME_STATE) {

			drawGameState(graphics);

		} else if (currentState == END_STATE) {

			drawEndState(graphics);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar()==KeyEvent.VK_ENTER) {
			
			if (currentState > END_STATE) {

				currentState = MENU_STATE;
				
			}
			else if (currentState==END_STATE) {
				rocket = new Rocketship(250,700,50,50,5);
				objectmanager = new ObjectManager(rocket);
			}
			else {
				currentState++;
			}
			 
		}
	
		if (e.getKeyChar()==KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(new Projectile(rocket.x+20, rocket.y+20, 10, 10));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			rocket.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = false;
		}
	}
}
