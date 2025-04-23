package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			snake.changeDirection(dir);
			snake.move();
			
			if (snake.eatFood(food)) {
				food  = new Food();
			}
			
			if (!snake.isInbounds()) {
				System.out.println("Game Over!");
			}
			
			updateDrawing();
			StdDraw.pause(100);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		drawGameOverScreen();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	private void drawGameOverScreen() {
	    StdDraw.clear();
	    StdDraw.setPenColor(StdDraw.RED);
	    StdDraw.text(0.5, 0.6, "Game Over");
	    StdDraw.setPenColor(StdDraw.BLACK);
	    StdDraw.text(0.5, 0.4, "Press 'R' to Restart"); 
	    StdDraw.show();

	    
	    while (true) {
	        if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
	            resetGame(); 
	            break;
	        }
	        StdDraw.pause(10);
	    }
	}
	
	private void resetGame() {
	    snake = new Snake();
	    food = new Food();
	    play(); 
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
