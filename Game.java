package pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this, 50);
	Racquet racquet2 = new Racquet(this, 1210);

	
	
	int speed = 1;

	private int getScore() {
		return speed - 1;
	}

	/*public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				
			}
		});
		
//-------------------------------------------------------------------//
//***************** next listener *********************************	//										
//------------------------------------------------------------------//
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet2.keyReleased2(e);
	
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet2.keyPressed2(e);
;
			}
		});
		
		
		
		
		setFocusable(true);
		Sound.BACK.loop();
	}
	*/
	
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
                                //TODO need to be able to press multiple buttons
                                
				racquet.keyPressed(e);                             
			}
		});
                addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { 
				racquet2.keyReleased2(e);
                                
			}

			@Override
			public void keyPressed(KeyEvent e) {
                               
                                racquet2.keyPressed2(e);                               
			}
		});
		setFocusable(true);
	}

	private void move() throws InterruptedException {
		ball.move();
		racquet2.move();
		racquet.move();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		
		racquet.paint(g2d);
		racquet2.paint(g2d);

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}

	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("PONG");
		Game game = new Game();
		frame.add(game);
		frame.setSize(1280, 720);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}