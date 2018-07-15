/**
* Created on 11 September, 2017
* @author: Emma Jing
*/

public class Point {
	private double x;
	private double y;
	private int i;
	public Point(double x, double y, int i){
		this.x = x;
		this.y = y;
		this.i = i;
	}
	public Point (double x, double y){
		this.x = x;
		this.y = y;
		this.i = 0;
	}
	public void setI(int i){
		this.i = i;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public int getI(){
		return i;
	}
	public void addI(int counter){
		this.i += counter;
	}
}
