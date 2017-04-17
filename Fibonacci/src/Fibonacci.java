
class Fibonacci {

	public static void main(String[] args){
		System.out.println("This prints the first 1000 numbers of the Fibonacci Sequence");
		double a = 0;
		double b = 1;
		double[]A = new double[1000];
		
		//set up for the first two numbers
		A[0] = a;
		A[1] = b;
		
		//start of print and loop
		System.out.println(A[0]);
		System.out.println(A[1]);
		for (int i = 2; i < 1000; i++){
			A[i] = A[i-2] + A[i-1];
			System.out.println(A[i]);
		}
		System.out.println("End of line");
	}

}
