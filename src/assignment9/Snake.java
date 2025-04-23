package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<>();
		segments.add(new BodySegment(.5, .5, SEGMENT_SIZE));
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		BodySegment head = segments.getFirst();
		double newHeadX = head.getX() + deltaX;
		double newHeadY = head.getY() + deltaY;
		
		segments.addFirst(new BodySegment(newHeadX, newHeadY, SEGMENT_SIZE));
		segments.removeLast();
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment: segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		double headX = head.getX();
		double headY = head.getY();
		double foodX = f.getX();
		double foodY = f.getY();
		
		double distanceSquared = Math.pow(headX - foodX, 2) + Math.pow(headY - foodY, 2);
		double minDistanceSquared = Math.pow(SEGMENT_SIZE / 2 + Food.FOOD_SIZE / 2, 2);
		
		if (distanceSquared < minDistanceSquared) {
			BodySegment newHead = new BodySegment(headX + deltaX, headY + deltaY, SEGMENT_SIZE);
			segments.addFirst(newHead);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		double headX = head.getX();
		double headY = head.getY();
		return headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1;
	}
}
