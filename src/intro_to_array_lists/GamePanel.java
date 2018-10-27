package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject gameobject;
	Rocketship rocket;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		rocket= new Rocketship(250,700,50,50,5);
	}

	void updateMenuState() {

	}

	void updateGameState() {
		rocket.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics graphics) {
		graphics.setColor(Color.BLUE);

		graphics.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawGameState(Graphics graphics) {
		graphics.setColor(Color.BLACK);

		graphics.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocket.draw(graphics);
	}

	void drawEndState(Graphics graphics) {
		graphics.setColor(Color.RED);

		graphics.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
		rocket.draw(graphics);
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
		if (currentState > END_STATE) {

			currentState = MENU_STATE;

		} else {
			currentState++;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			gameobject.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gameobject.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gameobject.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gameobject.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			gameobject.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gameobject.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gameobject.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gameobject.right = false;
		}
	}
}
