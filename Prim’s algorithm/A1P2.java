/**
* Created on 28 August, 2017
* @author: Emma Jing
*/

import java.util.*;
public class A1P2{
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
	public double setWeightZero(HashMap<Integer,LinkedList<Point>> map, int leftPoint, int rightPoint){
		 double weight = 0.00;
     for(int j = 0; j < 2; j++){
       for(int i = 0; i < map.get(leftPoint).size(); i++){
         if(map.get(leftPoint).get(i).getRight() == rightPoint){
           weight = map.get(leftPoint).get(i).getWeight();
				   map.get(leftPoint).get(i).setWeight(0);
					 break;
				 }
			 }
       int temp = leftPoint;
			 leftPoint = rightPoint;
			 rightPoint = temp;
		 }
		 return weight;
	}

    public double prim(HashMap<Integer,LinkedList<Point>> map, double sum){
      PriorityQueue<Point> queue= new PriorityQueue<Point>(new Comparator<Point>(){
        @Override
        public int compare(Point point1,Point point2){
            if (point1.getWeight() < point2.getWeight())
                return -1;
            else if (Math.abs(point1.getWeight() - point2.getWeight()) < 0.0001)
                return 0;
            else
                return 1;
        }
      });
    	int leftPoint = 0;
    	ArrayList<Integer> checked = new ArrayList<Integer>();
    	checked.add(leftPoint);
    	while(checked.size() != map.size()){
    		 LinkedList<Point> temp = map.get(checked.get(checked.size() - 1));
    		 for(Point pointA : temp){
           if(!checked.contains(pointA.getRight())){
             queue.add(pointA);
    			 }
			   }
      	 double minWeight = Double.MAX_VALUE;
      	 int index = 0;
  			 Point pointQ = queue.poll();
      	 while(true){
           if(checked.contains(pointQ.getLeft()) && checked.contains(pointQ.getRight())){
             pointQ = queue.poll();
  				 }else {
  					 break;
  				 }
  			 }
  			 sum = sum + pointQ.getWeight();
      	 checked.add(pointQ.getRight());
    	}
    	return sum;
    }

    public static void main(String[] args){
        A1 a1 = new A1();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        HashMap<Integer,LinkedList<Point>> map = a1.read(n,m,scanner);
        int total = Integer.parseInt(scanner.nextLine());
        double sum = 0.00;
        while(total-- > 0){
          String[] line = scanner.nextLine().split(" ");
          int left= Integer.parseInt(line[0]);
			    int right = Integer.parseInt(line[1]);
			    double weight = a1.setWeightZero(map, left, right);
			    sum = sum + weight;
        }
        sum = a1.prim(map, sum);
        System.out.printf("%.2f\n",sum);
    }
}
