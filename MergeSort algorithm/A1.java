import java.util.*;
public class A1 {
	public static void merge(ArrayList<Double> points, int left, int mid, int right){
		ArrayList<Double> temp = new ArrayList<Double>();
		int i = left;
		int j = mid + 1;
		while(i <= mid && j<= right){
			if(points.get(i) <= points.get(j)){
				temp.add(points.get(i));
				i++;
			}else{
				temp.add(points.get(j));
				j++;
			}
		}
		while(i <= mid){
			temp.add(points.get(i));
			i++;
		}
		while(j <= right){
			temp.add(points.get(j));
			j++;
		}
		for(double point : temp){
			points.set(left++, point);
		}
	}
	public static void mergeSort(ArrayList<Double> points, int left, int right){
		int mid = (left + right) / 2;
		if(left < right){
			mergeSort(points, left, mid);
			mergeSort(points, mid + 1, right);
			merge(points, left, mid, right);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		ArrayList<Double> points = new ArrayList<Double>();
		while(size-- > 0){
			points.add((double)sc.nextInt());
		}
		mergeSort(points, 0, points.size() - 1);
		for(double point : points){
			int count = points.indexOf(point);
			System.out.println(count);
		}
	}
}
