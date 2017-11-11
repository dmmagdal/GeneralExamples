import java.util.Scanner;
import java.io.*;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException{
		double[] rain = populateArray();	
		
		System.out.println("Enter the option \"average\", \"highest\", \"lowest\":");
		Scanner keyboard = new Scanner(System.in);
		
		while (!keyboard.nextLine().equals("quit")){
			System.out.println("Enter the option \"average\", \"highest\", \"lowest\":");
			if (keyboard.nextLine().equals("average")) {
				double average = findAverage(rain);
				System.out.println("Average rainfall since 1849: " + average + " inches");
			}
			else if (keyboard.nextLine().equals("lowest")) {
				int lowestYear = findLowestYearIndex(rain);
				System.out.println("Lowest rainfall since 1849: " + rain[lowestYear] + " inches which occured during year " + (1849+lowestYear));
			}
			else if (keyboard.nextLine().equals("highest")) {
				int highestYear = findHighestYearIndex(rain);
				System.out.println("Highest rainfall since 1849: " + rain[highestYear] + " inches which occured during year " + (1849+highestYear));
			}
			else {
				System.out.println("invalid input");
			}
		}
		keyboard.close();
	}
	
	public static double[] populateArray() throws FileNotFoundException {
		Scanner in = new Scanner(new File("rainfall.txt"));
		double[] rain = new double[168];
		int index = 0;
		while (in.hasNextLine()) {
			rain[index] = Double.parseDouble(in.nextLine());
			index++;
		}
		in.close();
		return rain;		
	}
	
	public static int findHighestYearIndex(double[] highest) {
		int year = -1;
		double high = 0.0;
		for (int i = 0; i< 168; i++) {
			if (highest[i] > high) {
				high = highest[i];
				year = i;
			}
		}
		return year;
	}
	
	public static int findLowestYearIndex(double[] lowest) {
		int year = -1;
		double low = lowest[0];
		for (int i = 0; i< 168; i++) {
			if (lowest[i] < low) {
				low = lowest[i];
				year = i;
			}
		}
		return year;
	}
	
	public static double findAverage(double[] average) {
		double sum = 0.0;
		for(int i =0; i< 168; i++) {
			sum = sum + average[i];
		}
		double avg = (sum/168);
		return avg;
	}
}