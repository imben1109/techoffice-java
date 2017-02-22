package com.techoffice.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Example introduces the basic concepts of regular expressions.
 * 
 * Syntax
 * \d		A digit: [0-9]
 * \D		A non-digit: [^0-9]
 * \s		A whitespace character: [\t\n\x0B\f\r]
 * \S 		A non-whitespace character: [^\S]
 * \w		A word character: [a-zA-Z_0-9]
 * \W 		A non-word character: [^\w]
 * 
 * Quantifiers
 * *		Match 0 or more times
 * + 		Match 1 or more times
 * ?		Match 1 or 0 times
 * {n}		Match exactly n times
 * {n,}		Match at least n times
 * {n,m}	Match at least n but not more than m times
 * 
 * Meta-characters
 * \ 		Escape the next meta-character
 * ^ 		Match the beginning of the line
 * .		Match any character (except newline)
 * |		Alternation (or statement)
 * ()		Grouping
 * []		Custom character class
 * 
 * @author Ben_c
 *
 */
public class RegularExpressionExample {
	
	public static void main(String... args){
		
		String str = "Today is 2016-11-21";
		
		// Check if String match a regular expression
		String strMatchPatternStr = "\\w+ \\w+ \\d+-\\d+-\\d+";
		System.out.println("Regular Expression Matched: " + str.matches(strMatchPatternStr));
		
		// Extracting value
		String str4Extract = "Today is 2016-11-21. Today is 2016-11-22";
		String extractPatternStr = "Today is (\\d+-\\d+-\\d+)";
		Pattern extractPattern = Pattern.compile(extractPatternStr);
		Matcher extractMatcher = extractPattern.matcher(str4Extract);
		while (extractMatcher.find()){
			System.out.println("Extracted Value: " + extractMatcher.group(1));
		}

	}
}
