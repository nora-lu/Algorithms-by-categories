/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class Solution {
	public boolean isValid(String s) {
		if (s == null) { return true; }
		Map<Character, Character> map = new HashMap<Character, Character>() {
			{
				put('(', ')');
			    put('{', '}');
			    put('[', ']');
			}
		};
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) { stack.push(c); }
			else {
				if (stack.isEmpty() || c != map.get(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}