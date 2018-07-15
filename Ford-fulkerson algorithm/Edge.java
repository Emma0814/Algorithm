/**
* Created on 19 October, 2017
* @author: Emma Jing
*/

public class Edge{
	private int left;
	private int right;
	private int weight;
	public Edge(int left, int right, int weight){
		this.left = left;
		this.right = right;
		this.weight = weight;
	}
	// public int getLeft(){
	// 	return left;
	// }
	// public int getRight(){
	// 	return right;
	// }
	// public int getWeight(){
	// 	return weight;
	// }
	public String print(){
		return left + " " + right + " " + weight;
	}
}
