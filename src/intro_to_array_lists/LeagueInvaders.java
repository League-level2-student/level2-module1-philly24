package intro_to_array_lists;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
	GamePanel gamepanel = new GamePanel();
	LeagueInvaders() {
		frame = new JFrame();  
	}
	public void setup() {
		frame.add(gamepanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.getContentPane().setPreferredSize(new Dimension(width,height));
		frame.pack();
		gamepanel.startGame();
		frame.addKeyListener(gamepanel);
	}
	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();
		
		
	}
}
