package JavaConcepts;

public class Strings {

	public static void main(String[] args) {
		String str1 = "Hello World";
		String str2 = "Hello Friends";
		String str3 = "";
		String str4 = "spaces are more      ";
		String str5 = "Replsce exsmple";
		int length = str1.length();
		System.out.println("The strings are : \n String 1 : " + str1 + "\n String 2 : " + str2
				+ "\n String 3 : " + str3 + "\n String 4 : " + str4 + "\n String 5 : " + str5);
		System.out.println("\n*********************************** \n");
		System.out.println("The length of the string is " + length);
		System.out.println("The 4th letter in " + str1 + " is : " + str1.charAt(3));
		System.out.println(str1 + " joined with " + str2 + " is : " + str1.concat(" " + str2));
		System.out.println("Is " + str1 + " having W : " + str1.contains("W"));
		System.out.println("Is " + str1 + " having Z : " + str1.contains("Z"));
		System.out.println(str1 + " starts with H : " + str1.startsWith("H"));
		System.out.println(str1 + " starts with Y : " + str1.startsWith("Y"));
		System.out.println(str1 + " ends with d : " + str1.endsWith("d"));
		System.out.println(str1 + " equal to " + str2 + " : " + str1.equals(str2));
		System.out.println("The position of r in " + str1 + " is : " + str1.indexOf("r"));
		System.out.println("Is " + str1 + " empty : " + str1.isEmpty());
		System.out.println("Is " + str3 + " empty : " + str3.isEmpty());
		System.out.println("After cutting out spaces in str 4 : " + str4.trim());
		System.out.println(str5.replace("s", "a"));
		System.out.println("The substring is " + str2.substring(1, 11));
	}
}
