	import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Scanner scan = new Scanner(System.in);
		
		int result = calc.calculate("1 + 1");
		System.out.println("Result:" + result);
				
	}

}
