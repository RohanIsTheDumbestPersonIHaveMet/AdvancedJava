import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
	ArrayList<Integer>numbers;
	ArrayList<String> operators;
	HashMap<String, Integer> variables;
	
	public Calculator (){
		operators = new ArrayList <String> ();
		numbers = 	new ArrayList <Integer> ();
		variables = new HashMap <String, Integer> ();
	}
	public int calculate(String expr){
		numbers.clear();
		operators.clear();
		expr = expr.replaceAll("\\s", "");
		String[] parts = expr.split("((?=(\\+|\\-|\\*|\\/|\\(|\\)))|(?<=(\\+|\\-|\\*|\\/|\\(|\\))))");
		
		for (String part : parts){
			if (part.length() == 0){continue;}
			put(part);
		}	
		while (operators.size() > 0){
			reduce();
			
		}
		return numbers.get(0);
		
	}
	public void put(String elem){
		if (elem.equals("(")){
			operators.add(elem);
		}
		else if (elem.equals(")")){
			while( ! operators.get(operators.size() - 1).equals("(")){
				reduce();
				
			}
			operators.remove(operators.size() - 1);
		}
		if (elem.matches("\\d+")){
			putNum(elem);
			
		}
		else {
			putOp(elem);
			
		}
		
	}
	public void reduce(){
		int num2 = numbers.remove(numbers.size() - 1);
		int num1 = numbers.remove(numbers.size() - 1);
		String op = operators.remove(operators.size() - 1); 
		
		if (op.equals("+")){
			numbers.add(num1 + num2);
		}
		if (op.equals("-")){
			numbers.add(num1 - num2);
		}
		if (op.equals("*")){
			numbers.add(num1 * num2);
		}
		if (op.equals("/")){
			numbers.add(num1 / num2);
		}
		
	}
	public void putNum(String num){
		int value = Integer.parseInt(num);
		numbers.add(value);
		
	}
	public void putOp(String op){
		if (operators.size() > 0){
			while (operators.size() > 0 && Importance(operators.get(operators.size() - 1)) >= Importance(op) ){
				reduce();	
			}
			
		}
		operators.add(op);
	}
	public int Importance(String op){
		if (op.equals("+") || op.equals ("-")){
			return 1;
		}
		if (op.equals("*") || op.equals ("/")){
			return 2;
		}
		return 0;
	}
}
