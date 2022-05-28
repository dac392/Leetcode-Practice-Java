import java.util.Scanner;
public class Reverse{


	private int findMatch(String s){
		char[] arr = new char[s.length()];
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch == '('){
				arr[count] = ch;
				count++;
			}else if(ch == ')'){
				count--;
				if(count == 0)
					return i;
			}
		}
		return -1;
	}
	private String reverse(String s){
		if(s.equals(""))
			return "";

		char[] rev = new char[s.length()];
		int j = s.length()-1;
		for(int i = 0; i < s.length(); i++){
			rev[i] = s.charAt(j);
			j--;
		}
		return new String(rev);
	}

	public String reverseParentheses(String s){
		
		while(s.indexOf("(") != -1){
			System.out.println("looking at: "+s);
			int start = s.indexOf("(")+1;
			int end = this.findMatch(s);
			String sub = reverseParentheses(s.substring(start, end));
			String rev = this.reverse(sub);
			s = s.replace(s.substring(start-1, end+1), rev);
		}
		

		return s;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give me a string:\t");
		String str = scanner.nextLine();
		Reverse reverser = new Reverse();
		String reversed = reverser.reverseParentheses(str);
		System.out.println(reversed);
	}
}

/*
	(yo)
		yo
	I(evol)you

	I(love)you

	(u(love)I)
*/