import java.util.Scanner;
import java.util.ArrayList;
//import java.util.stream;
public class JumpGame{

	private boolean dfs(ArrayList<Integer> array, ArrayList<Integer> fringe , boolean[] done){
		while(fringe.size()>0){
			int index = fringe.remove(0);
			done[index] = true;
			if(array.get(index) == 0)
				return true;

			int pluss = index+array.get(index);
			int minus = index-array.get(index);

			if(pluss <= array.size() && !done[pluss])
				fringe.add(pluss);
			if(minus >= 0 && !done[minus])
				fringe.add(minus);
		}
		return false;
	}

	public boolean canReach(ArrayList<Integer> arr, int start){
		
		if(!arr.stream().anyMatch(x->x==0) || start>=arr.size())
			return false;

		ArrayList<Integer> fringe = new ArrayList<>();
		
		boolean[] done = new boolean[arr.size()];
		fringe.add(start);
		return this.dfs(arr, fringe, done);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<>();
		System.out.print("Give me a set of numbers:\t");
		
		while(true){
			int temp = scanner.nextInt();
			if(temp == -1)
				break;
			array.add(temp);
		}

		System.out.print("Give me a start index:\t");
		int start = scanner.nextInt();


		JumpGame game = new JumpGame();
		System.out.println("Output: "+game.canReach(array, start));
	
	}

}