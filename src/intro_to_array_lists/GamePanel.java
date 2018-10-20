package intro_to_array_lists;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	GameObject gameobject;
	GamePanel(){
		timer = new Timer(1000/60, this);
		 gameobject = new GameObject(10, 2, 2, 2);
		 
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		gameobject.update();
	} 
	void startGame() {
		timer.start();
	}
	@Override

	public void paintComponent(Graphics graphics){
		gameobject.draw(graphics);
	                
	        }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("my name");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("is phillip");
	}
}
