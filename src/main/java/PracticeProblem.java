/*File: Practice Problem 5.9
Author: Kaveeshan Sathasivam
Date Created: May 19, 2026
Date Last Modified: May 19 2026 
*/

import java.util.ArrayDeque;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static String processBackspaces(String input) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch != '#') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}

		String result = "";

		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}

		return result;
	}

	public static String simulateLine(String[] commands) {
		ArrayDeque<String> line = new ArrayDeque<String>();

		for (int i = 0; i < commands.length; i++) {

			String[] parts = commands[i].split(" ", 2);
			String command = parts[0];

			if (command.equals("ENQUEUE")) {
				line.addLast(parts[1]);
			}

			else if (command.equals("VIP")) {
				line.addFirst(parts[1]);
			}

			else if (command.equals("SERVE")) {
				if (!line.isEmpty()) {
					line.removeFirst();
				}
			}

			else if (command.equals("REQUEUE")) {
				if (!line.isEmpty()) {
					line.addLast(line.removeFirst());
				}
			}

			else if (command.equals("SCARE")) {
				if (!line.isEmpty()) {
					line.removeLast();
				}
			}
		}

		String result = "[";
		boolean first = true;

		while (!line.isEmpty()) {
			if (!first) {
				result += ", ";
			}
			result += line.removeFirst();
			first = false;
		}

		result += "]";

		return result;
	}
}