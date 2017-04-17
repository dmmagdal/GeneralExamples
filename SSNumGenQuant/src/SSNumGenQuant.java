
public class SSNumGenQuant {

	public static void main(String[] args) {
		System.out.println("This program tells the possible number of SSNs");
		int a = 10; //base number of combinations
		double b = Math.pow((double)a, (double)(3+2+4));
		System.out.println(b);
		
	}

}
