package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		int counter1=0;
		int counter2=0;	
		for (int i = 0; i < s1.length(); i++) {
			counter1++;
		}for (int i = 0; i < s2.length(); i++) {
			counter2++;
		}
		if(counter1>counter2) {
			return s1;
		}else {
			return s2;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores")) {
			s.replace(' ', '_');
		}
		return null;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	/*
	 * public static String lineLeader(String s1, String s2, String s3) {
	 * 
	 * if(s1.indexOf(0)!=' ') { if(s1.contains(" ")) {
	 * 
	 * } } return null; }
	 */
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int fin=0;
		ArrayList <Integer> nums=new ArrayList <Integer>();
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				nums.add(Character.getNumericValue(s.charAt(i)));
			}
		}for (int i = 0; i < nums.size(); i++) {
			fin=fin+nums.get(i);
		}
		
		return fin;
	}
	
	
	// Return the number of times String substring appears in String s
	
	public static int substringCount(String s, String substring) {
	  
	  int num=0;
	  int subLength=substring.length();
	  
	  for (int i = 0; i < s.length()-subLength+1; i++) {
		  if(s.substring(i, i+subLength).equals(substring)) {
			  num++; 
			  } 
		  }
	  System.out.println(num);
	  
	  return num;
	  
	  }

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte b=7;
		
		Utilities.encrypt(s.getBytes(), b);
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return null;
		//not done
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int subLength=substring.length();
		int count=0;
		  String[] words=s.split(" ");
		  for (int i = 0; i < words.length; i++) {
			  if(subLength<=words[i].length()) {
			  if(words[i].substring(words[i].length()-subLength,words[i].length()).equals(substring)) {
				  count++;
			  }
			  }
		}
			
			  return count;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		  int subLength=substring.length();
		  int firstOcc=0;
		  int secondOcc = 0;

		  for (int i = 0; i < s.length()-subLength+1; i++) {
			  if(s.substring(i, i+subLength).equals(substring)) {
				   firstOcc=i+subLength;
				   break;
				  } 
			  }
		  for (int i = s.length()-subLength; i > 0; i--) {
			  if(s.substring(i,i+subLength).equals(substring)) {
				   secondOcc=i;
				   break;
				  } 
			  }
		  System.out.println();
		  
		  return secondOcc-firstOcc;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		int counter=0;
		String f= "";
		for (int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				f+=s.charAt(i)+"";
			}
		}
		
		f=f.toLowerCase();

		int halfWord=f.length()/2;
		for (int i = 0; i < halfWord; i++) {
			char first= f.charAt(i);
			char last=f.charAt(f.length()-1-i);
			if(first==last) {
				counter++;

				}
		}
	
		if(counter>=halfWord) {
			return true;
		}
		return false;
		
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
