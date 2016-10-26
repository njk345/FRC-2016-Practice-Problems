//Nick Keirstead
//This program takes an integer inputted by the user and prints the english representation of it

import java.util.Scanner;

public class keirsteadNumToWord {
	public static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	public static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	public static final String[] largerUnits = {"billion", "million", "thousand", ""};

	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		
		String input = "";
		while (true) {
			System.out.print("\nEnter Integer To Convert To English (or Q to quit): ");
			input = s.nextLine();
			if (input.equals("q") || input.equals("Q")) {
				break;
			}
			System.out.println(intToWord(Integer.parseInt(input)));
		}
	}
	
	public static String intToWord(int n) {
		String rv = "";
		if (n == 0) rv = "zero";
		else {
			if (n < 0) rv += "negative";
			rv += groupsToWord(splitDigits(n), 0);
		}
		return rv;
	}
	
	public static int[] splitDigits(int n) {
		String ns = "" + n;
		int[] groups = new int[4];
		
		boolean isNeg = ns.charAt(0) == '-';
		
		if (isNeg) {
			ns = ns.substring(1);
		}
		
		String spaces = "";
		for (int i = 0; i < 10 - ns.length(); i++) {
			spaces += " ";
		}
		ns = spaces + ns;
		
		int x = 0;
		for (int i = 0; i < groups.length; i++) {
			String group;
			if (i == 0) {
				group = removeSpaces(ns.substring(x,x+1));
				x++;
			}
			else {
				group = removeSpaces(ns.substring(x,x+3));
				x += 3;
			}
			groups[i] = group.equals("") ? 0 : Integer.parseInt(group);
		}
		
		if (isNeg) groups[0] *= -1;
		
		return groups;
	}
	
	public static String groupsToWord(int[] digs, int group) {
		if (group == 4) return "";
		if (digs[group] == 0) return groupsToWord(digs, group + 1);
		
		return " " + intToWordUnderThousand(digs[group]) + largerUnits[group] + groupsToWord(digs, group + 1);
	}
	
	public static String intToWordUnderThousand(int n) {
		String word = "";
		
		int hundreds = n / 100;
		if (hundreds != 0) {
			word += units[hundreds] + "hundred";
		}
		
		int leftover = n % 100;
		
		if (leftover < 20 && leftover > 0) {
			word += units[leftover];
		} else {
			int ten = n / 10 % 10;
			int one = n % 10;
			word += tens[ten];
			word += units[one];
		}
		
		return word;
	}
	
	public static String removeSpaces(String s) {
		String rv = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				rv += s.charAt(i);
			}
		}
		return rv;
	}
}
