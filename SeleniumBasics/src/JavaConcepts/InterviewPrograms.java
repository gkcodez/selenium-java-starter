package JavaConcepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InterviewPrograms {

	public static void main(String[] args) throws IOException {
		JavaPrograms javaPrograms = new JavaPrograms();
		// javaPrograms.primeNumbersRange(3);
		javaPrograms.reverseNumber(123456789);
		// // Factorial
		// javaPrograms.factorial(6);
		//
		// // Longest word in a string
		// javaPrograms.longestWord("I am a software Developer in India"); // //
		// Reverse a String javaPrograms.reverseString("I am a string"); // //
		// Swap numbers without using 3rd Variable javaPrograms.swapNumbers(20,
		// 30); // // String Replace String replacedString =
		// javaPrograms.strReplace("selenium driver.", "selenium", "firefox");
		// System.out.println(replacedString); // // Prime Number Check boolean
		// primeCheckResult = javaPrograms.primeNumberCheck(11);
		// System.out.println(primeCheckResult); // // Read XML
		// javaPrograms.readXML();
		//
	}
}

class JavaPrograms {

	public boolean primeNumberCheck(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public void swapNumbers(int i, int j) {
		i = i + j;
		j = i - j;
		i = i - j;
		System.out.println("i=" + i + " j=" + j);
	}

	public String strReplace(String str, String strtoFind, String strtoReplace) {
		str = str.replaceAll(strtoFind, strtoReplace);
		return str;
	}

	public void reverseString(String str) {
		String strRev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			strRev = strRev.concat(String.valueOf(str.charAt(i)));
		}
		System.out.println(strRev);
	}

	public void longestWord(String str) {
		String words[] = str.split(" ");
		int l = 0;
		String lw = "";
		for (String word : words) {
			if (word.length() > l) {
				lw = word;
				l = word.length();
			}
		}
		System.out.println("Longest word in the given string is " + lw);
		System.out.println("Length of the longest word is " + l);
	}

	public void readXML() throws IOException {
		FileReader fReader = new FileReader("D://colors.xml");
		BufferedReader bReader = new BufferedReader(fReader);
		StringBuffer sBuffer = new StringBuffer();
		while (bReader.readLine() != null) {
			sBuffer = sBuffer.append(bReader.readLine() + "\n");
		}
		System.out.println(sBuffer);
	}

	public void factorial(int i) {
		int j = 1;
		int k = 2;
		while (k <= i) {
			j = j * k;
			k++;
		}
		System.out.println("Factorial of " + i + " is " + j);
	}

	public void primeNumbersRange(int i) {
		for (int j = 2; j < i / 2; j++) {
			if (i % j == 0) {
				System.out.println("Not a prime");
			}
		}
		System.out.println("prime");
	}

	public void reverseNumber(int i) {
		int num = 0;
		int reverse = 0;
		num = i;
		while (num != 0) {
			reverse = reverse * 10;
			reverse = reverse + num % 10;
			num = num / 10;
		}
		System.out.println(reverse);
	}
}
