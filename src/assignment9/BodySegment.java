package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		
		//See ColorUtils for some color options (or choose your own)
		this.color = StdDraw.GREEN;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
