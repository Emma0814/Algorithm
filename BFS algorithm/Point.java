/**
* Created on 28 August, 2017
* @author: Emma Jing
*/

public class Point{
  private int leftPoint;
  private int rightPoint;
  private double weight;
  public Point(int leftPoint, int rightPoint,double weight){
    this.leftPoint = leftPoint;
    this.rightPoint = rightPoint;
    this.weight = weight;
  }
  public Point(int leftPoint, int rightPoint){
    this.leftPoint = leftPoint;
    this.rightPoint = rightPoint;
    this.weight = 0.0;
  }
  public int getLeft(){
    return leftPoint;
  }
  public int getRight(){
    return rightPoint;
  }
  public double getWeight(){
    return weight;
  }
  public String toString(){
    return "****"+leftPoint+"-"+rightPoint;
  }
}
