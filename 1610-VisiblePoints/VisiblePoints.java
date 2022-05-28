import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VisiblePoints{

	public int visiblePoints(ArrayList<ArrayList<Integer>> points, int angle, ArrayList<Integer> location){
		int maxPoints = 0;
		for(int d = 0; d < 360; d++){
			int[] fov = new int[2];
			fov[0] = d - angle/2;
			fov[1] = d + angle/2;
			// i should use a sliding window
		}
		return maxPoints;
	}
	public static void main(String[] args) {
		if(args.length != 0){
			try{
				// variables
				String filename = args[0];
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				ArrayList<ArrayList<Integer>> points = new ArrayList<>();
				ArrayList<Integer> location = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				VisiblePoints vp = new VisiblePoints();
				// reading point data into "points"
				String line;
				while( (line = reader.readLine())!=null ){
					String[] coord = line.split(",");
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(String s:coord){
						list.add(Integer.parseInt(s));
					}
					points.add(list);	
				}
				// getting angle
				System.out.println("Your data:\t"+points.toString());
				System.out.print("Angle:\t");
				int angle = scanner.nextInt();			// angle of vision
				// getting (starting)location
				System.out.print("Starting position:\t");
				String sss = scanner.next();
				String[] pos_str = (sss).split(",");
				for(String num:pos_str){
					location.add(Integer.parseInt(num));
				}

				// System.out.println("echo: "+points.toString());
				// System.out.println("echo: "+angle);
				// System.out.println("echo: "+location.toString());

				System.out.println(vp.visiblePoints(points, angle, location));

			}catch(Exception e){
				e.printStackTrace();
				System.out.println("uhh i think this file doesn't exist: "+args[0]);
			}
		}else{
			System.out.println("Dick head, you gotta pass the filename as a parameter.");
		}

	}
}