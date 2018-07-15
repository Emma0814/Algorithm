/**
* Created on 19 October, 2017
* @author: Emma Jing
*/

import java.util.*;
public class A4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int Y = sc.nextInt();
		int[] delta = new int[Y];
		for(int i = 0; i < Y; i++){
			delta[i] = sc.nextInt();
		}
		int[] tau = new int[k];
		for(int i = 0; i < k; i++){
			tau[i] = sc.nextInt();
		}
		int[][] w = new int[k][Y];
		for(int i = 0; i < k; i++){
			for(int j = 0; j < Y; j++){
				w[i][j] = sc.nextInt();
			}
		}
		int[] u = new int[Y];
		for(int i = 0; i < Y; i++){
			u[i] = sc.nextInt();
		}
		HashMap<Integer, LinkedList<Edge>> map = new HashMap<Integer, LinkedList<Edge>>();
		LinkedList<Edge> listD = new LinkedList<>();
		int count = 0;
		for(int i = 0; i < k; i++){
			LinkedList<Edge> listW = new LinkedList<>();
			Edge edgeD = new Edge(0, i + 1, tau[i]);
			listD.add(edgeD);
			count++;
			for(int j = 0; j < Y; j++){
				LinkedList<Edge> list = new LinkedList<>();
				Edge edgeW = new Edge(i + 1, j + i * Y + 1 + k, w[i][j]);
				listW.add(edgeW);
				count++;
				if(delta[j] > 0){
					for(int p = 0; p < delta[j]; p++){
						Edge edgeY = new Edge(j + i * Y + 1 + k, 1 + k + k * Y + j + p, Integer.MAX_VALUE);
						list.add(edgeY);
						count++;
						if(1 + k + k * Y + j + p == k + k * Y + Y){
							break;
						}
					}
				}else{
					Edge edgeY = new Edge(j + i * Y + 1 + k, 1 + k + k * Y + j, 0);
					list.add(edgeY);
					count++;
				}
				map.put(j + i * Y + 1 + k, list);
			}
			map.put(i + 1, listW);
		}
		map.put(0, listD);
		for(int i = 0; i < Y; i++){
			LinkedList<Edge> listU = new LinkedList<>();
			Edge edgeU = new Edge(1 + k + k * Y + i, 1 + k + k * Y + Y, u[i]);
			listU.add(edgeU);
			count++;
			map.put(1 + k + k * Y + i, listU);
		}
		System.out.println(map.size() + 1);
		System.out.println(count);
		for(int i = 0; i < map.size(); i++){
			for(int j = 0; j < map.get(i).size(); j++){
				System.out.println(map.get(i).get(j).print());
			}
		}
	}
}
