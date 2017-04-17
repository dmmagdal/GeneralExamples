//Search file for a target word
import java.io.*;
import java.util.Scanner;

public class Search {
	public static void main(String[] args) throws IOException{
		if (args.length < 2){
			System.err.println("Usage: Search file <target1>");
			System.exit(1);
		}
		
		Scanner in = new Scanner(new File(args[0]));
		String[] lines = null; //array to hold each string word on each line
		in.useDelimiter("\\Z"); //matches the end of file character
		String s = in.next(); //read in whole file as a single string
		in.close();
		lines = s.split("\n"); //split s into individual lines
		int lineCount = lines.length; //extract length of the resulting array
		int[] lineNumber = new int[lineCount];
		for (int i = 0; i < lineCount; i++){
			lineNumber[i] = i+1;
		}
		
		//print out number of lines in file
		System.out.println(args[0]+" contains "+lineCount+" lines");
		
		mergeSort(lines, lineNumber, 0 , lineCount-1);
		for (int i = 1; i < args.length; i++){
			String Subject = args[1];
			int index = binarySearch(lines, 0, lineCount-1, Subject);
			if (index == -1){
				System.out.println(Subject + " not found");
			}
			else{
				System.out.println(Subject + " found on line "+ lineNumber[index]);
			}
		}
	}

	static void mergeSort(String[] word, int[] lineNumber, int p, int r){
		int q;
		if (p <r){
			q = (p+r)/2;
			mergeSort(word, lineNumber, p, q);
			mergeSort(word, lineNumber, q+1, r);
			merge(word, lineNumber, p, q, r);
		}
	}
	
	static void merge(String[] word, int[] lineNumber, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L1 = new int[n1];
		int[] R2 = new int[n2];
		String[] L = new String[n1];
		String[] R = new String[n2];
		int i, j, k;
		
		for (i = 0; i < n1; i++){
			L[i] = word[p+i];
			L1[i] = lineNumber[p+i];
		}
		for (j = 0; j < n2; j++){
			R[j] = word[q+j+1];
			R2[j] = lineNumber[q+j+1];
		}
		i = 0; j = 0;
		for (k = p; k <= r; k++){
			if (i < n1 && j < n2){
				if (L[i].compareTo(R[j]) < 0){
					word[k] = L[i];
					lineNumber[k] = L1[i];
					i++;
				}
				else{
					word[k] = R[j];
					lineNumber[k] = R2[j];
					j++;
				}
			}
			else if (i < n1){
				word[k] = L[1];
				lineNumber[k] = L1[i];
				i++;
			}
			else{ //j<n2
				word[k] = R[j];
				lineNumber[k] = R2[j];
				j++;
			}
		}
	}
	
	static int binarySearch(String[] word, int p, int r, String target){
		int q;
		if (p > r){
			return -1;
		}
		else{
			q = (p+r)/2;
			if (target.compareTo(word[q]) == 0){
				return q;
			}
			else if (target.compareTo(word[q]) < 0){
				return binarySearch(word, p, q-1, target);
			}
			else{
				return binarySearch(word, q+1, r, target);
			}
		}
	}
}