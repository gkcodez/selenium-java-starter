package JavaConcepts;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] myIntArray;
		myIntArray = new int[10];
		myIntArray[0] = 25;
		myIntArray[1] = 30;
		for (int i = 0; i <= 9; i++) {
			System.out.println(myIntArray[i]);
		}
		int[] myIntArray2 = { 2, 4, 6, 8 };
		for (int j = 0; j < myIntArray2.length; j++) {
			System.out.println(myIntArray2[j]);
		}
		Arrays.sort(myIntArray2);
	}
}
