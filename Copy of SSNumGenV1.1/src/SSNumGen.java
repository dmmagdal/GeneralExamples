import java.io.*;

public class SSNumGen {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("SSNumsGen.txt", "UTF-8");
		int[] three = new int[3];
		int[] two = new int[2];
		int[] four = new int[4];
		//formating
		three[0] = 0;
		three[1] = 0;
		three[2] = 0;
		two[0] = 0;
		two[1] = 0;
		four[0] = 0;
		four[1] = 0;
		four[2] = 0;
		four[3] = 0;
		int i = 0; //incremental int and first int for four
		int j = 0, k = 0, l = 0; //remaining ints for three
		int m = 0, n = 0; //ints for two
		int o = 0, p = 0, q = 0; //ints for four
		//m = 0; 
		//System.out.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
		//writer.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
		while (i < 11){
			four[0] = i;
			if (i == 9){
				i = 0;
				four[1] = j++;
			}
			if (j == 9){
				j = 0;
				four[2] = k++;
			}
			if (k == 9){
				k = 0;
				four[3] = l++;
			}
			if (l == 9){
				l = 0;
				two[0] = m++;
			}
			if (m == 9){
				m = 0;
				two[1] = n++;
			}
			if (n == 9){
				n = 0;
				three[0] = o++;
			}
			if (o == 9){
				o = 0;
				three[1] = p++;
			}
			if (p == 9){
				p = 0;
				three[2] = q++;
			}
			if (q == 10){
				break;
			}
			i++;
			System.out.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
			writer.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
		}
		writer.close();
		
	}

}
