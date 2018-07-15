/**
* Created on 28 August, 2017
* @author: Emma Jing
*/

import java.util.*;
public class A1P1{
    public HashMap<Integer,LinkedList<Point>> read(int n, int m,Scanner scanner){
      HashMap<Integer,LinkedList<Point>> map = new HashMap<Integer,LinkedList<Point>>();
      while(m-- > 0){
			     String[] line = scanner.nextLine().split(" ");
	  		   int left = Integer.parseInt(line[0]);
	       	 int right = Integer.parseInt(line[1]);
	       	 double weight = Double.parseDouble(line[2]);
           Point point = new Point(left,right,weight);
           for(int i = 0; i < 2; i++){
             if(map.containsKey(left)){
               map.get(left).add(point);
             } else {
               LinkedList<Point> list = new LinkedList<Point>();
               list.add(point);
               map.put(left,list);
             }
             point = new Point(right,left,weight);
             int swap = left;
             left = right;
             right = swap;
            }
        }
        return map;
    }
    public boolean isConnected(HashMap<Integer,LinkedList<Point>> map, Point pointC){
        HashMap<Integer,Boolean> checkT = new HashMap<Integer,Boolean>();
        for(Integer key: map.keySet()){
            checkT.put(key,false);
        }
        LinkedList<Point> queue = new LinkedList<Point>();
        int rightPointC = pointC.getRight();
        int leftPointC = pointC.getLeft();
        int tempV = leftPointC;
            do{
                if(queue.size() != 0){
                    tempV = queue.poll().getRight();
                }
                if(map.containsKey(pointC.getLeft()) && map.containsKey(pointC.getRight())){
                    LinkedList<Point> temp = map.get(tempV);
                    checkT.put(pointC.getLeft(),true);
                    for(Point point: temp){
                        if(rightPointC == point.getRight()){
                            return true;
                        }
                        if(!checkT.get(point.getRight())){
                            queue.add(point);
                            checkT.put(point.getRight(),true);
                        }
                    }
                }
            }while(queue.size() != 0);

        return false;
    }
    public static void main(String[] args){
        A1 a1 = new A1();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        HashMap<Integer,LinkedList<Point>> map = a1.read(n,m,scanner);
        int total = Integer.parseInt(scanner.nextLine());
        LinkedList<Integer> result = new LinkedList<Integer>();
        while(total-- > 0){
          String[] line = scanner.nextLine().split(" ");
		 	    int left= Integer.parseInt(line[0]);
		  	  int right = Integer.parseInt(line[1]);
          Point point = new Point(left,right);
			    result.add(a1.isConnected(map,point) ? 1:0);
        }
    		for(int i: result){
    			System.out.println(i);
    		}
    }
}
