package pong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private int X = 50;
	private int W = 1210;
	private static final int WITH = 10;
	private static final int HEIGHT = 450;
	int y = 100;
	int ya = 0;
	// clone values for second racquet
	int z = 100;
	int za =0;
	
	// doesnt work
	int  upkey;
	int downkey;
	private Game game;
/* doesnt work, original plan was to have 2 more ints, in parameter, and then use those for keyevent listeners
	
	then use stuff like KeyEvent.VK_W when u define the racquet
	
	public Racquet(Game game, int x, int upkey, int downkey) {
		this.game = game;
		this.X = x;
		this.upkey = upkey;
		this.downkey = downkey;
	}
	
*/
	
	public Racquet(Game game, int x) {
		this.game = game;
		this.X = x;
	}


	public void move() {
		if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT)
			y= y + ya;
		if (z + za > 0 && z + za < game.getHeight() - HEIGHT)
			z= z + za;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(X, y, WITH, HEIGHT);

	}

	public void keyReleased(KeyEvent e) {
		ya = 0;
	}
	
	public void keyReleased2(KeyEvent e) {
		za = 0;
	}
/*
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == upkey)
			ya = -game.speed-3;
		if (e.getKeyCode() == downkey)
			ya = game.speed+3;
	}
	
	public void keyPressed2(KeyEvent e) {
		if (e.getKeyCode() == upkey)
			za = -game.speed-3;
		if (e.getKeyCode() == downkey)
			za = game.speed+3;
	}
*/
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			ya = -game.speed-3;
		if (e.getKeyCode() == KeyEvent.VK_S)
			ya = game.speed+3;
	}
	
	public void keyPressed2(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			za = -game.speed-3;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			za = game.speed+3;
	}


	public Rectangle getBounds() {
		return new Rectangle(X, y, WITH, HEIGHT);
	}
	
	public Rectangle getBounds2() {
   
		return new Rectangle(W, z, WITH, HEIGHT);
}
	public int getX(){
        return X;
    }
    
    public int getW(){
        return W;
    }
}


	