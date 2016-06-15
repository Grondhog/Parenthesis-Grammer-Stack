import java.util.ArrayList;
import java.util.Stack;


public class ParenGrammer {

	public static void main(String[] args) {
		System.out.println(checkParensTwo("(()()()9))"));
		System.out.println(checkAllParens("(fgg[f{rt}qwer]qwer)"));

	}
	
	private static boolean checkParens(String input)
	{
		Stack<Character> parens = new Stack<Character>();
		int count = 0;
		char[] charAra = input.toCharArray();
		for(char c : charAra)
		{
			if(c == '(' || c == ')')
			{
				parens.push(c);
			}
		}
		char ch;
		while(parens.size() > 0)
		{
			ch = parens.pop().charValue();
			if(ch == '(')
			{
				count++;
			}
			else if(ch == ')')
			{
				count --;
			}
		}
		return count == 0;
	}
	
	private static boolean checkParensTwo(String input)
	{
		Stack<Character> stack = new Stack<Character>();
		char[] ara = input.toCharArray();
		for(char c : ara)
		{
			if(c == '(')
			{
				stack.push(c);
			}
			if(c == ')')
			{
				if(stack.size() == 0)
				{
					return false;
				}
				else if(stack.peek().charValue() == '(')
				{
					stack.pop();
				}
			}
		}
		return stack.empty();
	}
	
	private static boolean checkAllParens(String input)
	{
		Stack<Character> stack = new Stack<Character>();
		char[] ara = input.toCharArray();
		for(char c : ara)
		{
			if(c == '(')
			{
				stack.push(c);
			}
			else if(c == ')')
			{
				if(stack.size() == 0)
				{
					return false;
				}
				else if(stack.peek().charValue() == '(')
				{
					stack.pop();
				}
			}
			else if(c == '[')
			{
				stack.push(c);
			}
			else if(c == ']')
			{
				if(stack.size() == 0)
				{
					return false;
				}
				else if(stack.peek().charValue() == '[')
				{
					stack.pop();
				}
			}
			else if(c == '{')
			{
				stack.push(c);
			}
			else if(c == '}')
			{
				if(stack.size() == 0)
				{
					return false;
				}
				else if(stack.peek().charValue() == '{')
				{
					stack.pop();
				}
			}
		}
		return stack.empty();
	}

}
