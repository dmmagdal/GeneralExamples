import java.io.*;

public class NumBrute {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("This program lists the number quantity of all possible passwords");
		System.out.println("Given the use of the alphabet (upper and lowercase), numbers, and");
		System.out.println("All symbols that are accessed from the keyboard and shift key");
		System.out.println("Combinations.");
		System.out.println();
		System.out.println("Check the file named NumBrute.");
		
		PrintWriter writer = new PrintWriter("NumBrute.txt", "UTF-8");
		int a = 32 + 26 + 26 + 10; //base number of combinations 
		double[] A = new double[26]; //array containing value quantity of combinations up to 26 characters long
		for (int i = 0; i < A.length; i++){
			A[i] = Math.pow((double)a, (double)i+1);
			writer.println(i+1);
			writer.println(A[i]);
			System.out.println(i+1);
			System.out.println(A[i]);
		}
		writer.close();
	}

}