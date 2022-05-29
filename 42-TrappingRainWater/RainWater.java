import java.util.Scanner;
public class RainWater{

	private int volume(int lower, int upper, int[] height){
		if(height[lower] > height[upper]){
			int nextBiggest = lower;
			for(int i = lower+1; i < upper; i++){
				if(height[i]==height[upper]){
					nextBiggest = i;
					break;
				}
				if(height[i]>height[upper])
					nextBiggest = i;
			}
			lower = nextBiggest;
		}
		int answer = 0;
		int max = (height[lower]<=height[upper])? lower:upper;
		for(int i = lower+1; i < upper; i++){
			answer+= height[max]-height[i];
		}
		System.out.println(answer);
		return answer;
	}

	private int getNextUpper(int lower, int[] height){
		int nextHighest = -1;
		for(int i = lower+1; i<height.length; i++){
			int val = height[i];
			if(val >= height[lower])
				return i;

			if(nextHighest == -1 || val>height[nextHighest])
				nextHighest = i;
		}	

		if(nextHighest == lower+1)
			return -1;
		return nextHighest;
	}

	public int trap(int[] height){
		int len = height.length;
		
		int lower = 0;
		int upper = 0;
		int water_units = 0;

		while(lower < len && height[lower]==0){
			lower++;
		}
		upper=lower;

		while(upper < len && lower < len){
			upper = this.getNextUpper(lower, height);
			if(upper == -1){
				lower++;
				upper = lower;
				continue;
			}
			System.out.print("range: "+lower+","+upper+" :\t");
			water_units+= this.volume(lower, upper, height);
			lower = upper;
		}

		return water_units;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give me a graph:\t");
		String input = scanner.next();
		String[] csv = input.split(",");
		int[] height = new int[csv.length];
		for(int i = 0; i < csv.length; i++){
			height[i] = Integer.parseInt(csv[i]);
		}
		RainWater solution = new RainWater();
		System.out.println("Toal units of water: "+solution.trap(height));
	}
}