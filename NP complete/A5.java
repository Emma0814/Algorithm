/**
* Created on 5 November, 2017
* @author: Emma Jing
*/

import java.util.*;
public class A5 {

	public static void c_fair_input(double c, ArrayList<Integer> payoffs){
		System.out.println(payoffs.size());
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < payoffs.size(); i++){
			if(i != 0)
				System.out.print(" ");
			sum1 += (int)(Math.abs(payoffs.get(i))*c);
			System.out.print((int)(Math.abs(payoffs.get(i))*c));
		}
		System.out.println();
		for(int i = 0; i < payoffs.size(); i++){
			if(i != 0)
				System.out.print(" ");
			if(payoffs.get(i) > 0)
				sum2 += payoffs.get(i);
			else
				sum1 -= payoffs.get(i);
			System.out.print(Math.abs(payoffs.get(i)));
		}
		System.out.println();
		//System.out.println(sum2/2 +"..."+sum1/2);
		if(c==1.0 && sum2 % 2 != 0){
			System.out.println(0);
			System.out.println(Integer.MAX_VALUE);
		}else{
			System.out.println((int)(sum2/2));
			System.out.println((int)(sum1/2));
		}
	}

	public static void fair_pair(ArrayList<Integer> as, ArrayList<Integer> bs){
		ArrayList<Integer> payoffs = new ArrayList<>();
		for(int i = 0; i < as.size(); i++){
			payoffs.add(as.get(i) - bs.get(i));
		}
		c_fair_input(1.0, payoffs);
	}

	public static void c_fixed(double c, ArrayList<String> dir, ArrayList<Integer> dis){
		ArrayList<Integer> as = new ArrayList<>();
		ArrayList<Integer> bs = new ArrayList<>();
		for(int i = 0; i < dir.size(); i++){
			if(dir.get(i).equals("right")){
				as.add(0);
				bs.add((int) (dis.get(i)*c));
			}else{
				bs.add(0);
				as.add((int) (dis.get(i)*c));
			}
		}
		fair_pair(as, bs);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		if(line.equals("c-fair")){
			//1a
			double c = Double.parseDouble(sc.nextLine());
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<Integer> payoffs = new ArrayList<>();
			while(n-- > 0){
				payoffs.add(sc.nextInt());
			}
			c_fair_input(c, payoffs);
		}else if(line.equals("fair-pair")){
			//1b
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<Integer> as = new ArrayList<>();
			ArrayList<Integer> bs = new ArrayList<>();
			while(n-- > 0){
				as.add(sc.nextInt());
				bs.add(sc.nextInt());
			}
			fair_pair(as, bs);
		}else{
			//1c
			double c = Double.parseDouble(sc.nextLine());
			int n =  Integer.parseInt(sc.nextLine());
			ArrayList<String> dir = new ArrayList<>();
			ArrayList<Integer> dis = new ArrayList<>();
			while(n-- > 0){
				dir.add(sc.next());
				dis.add(sc.nextInt());
			}
			c_fixed(c, dir, dis);
		}
	}

}
