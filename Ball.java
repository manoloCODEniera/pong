package pong;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.*;

public class Ball {
	private static final int DIAMETER = 30;
	
	int x = 640;
	int y = 360;
	int xa = 2;
	int ya = 2;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() throws InterruptedException {
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			game.gameOver();
		else if (x + xa < 3)
			game.gameOver();
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			ya = -game.speed;
		else if (collision()){
			xa = -game.speed;
			//y = game.racquet.getTopY() - DIAMETER; useless and will make the program not run smooth
			game.speed++;
		}
		else if (collision2()){
				xa = game.speed;
				game.speed++;
		} else 
			changeDirection = false;
		
		if (changeDirection) 
			Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}
	
	

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	 private boolean collision2() {
			return game.racquet.getBounds2().intersects(getBounds());
		}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.PINK);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}