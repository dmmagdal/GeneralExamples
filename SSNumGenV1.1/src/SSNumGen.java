import java.io.*;

//This is the V1.1 Copy
public class SSNumGen {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("SSNumsGen.txt", "UTF-8");
		int[] three = new int[3];
		int[] two = new int[2];
		int[] four = new int[4];
		//formating
		int i = 0; //incremental int and first int for four
		int j = 0, k = 0, l = 0; //remaining ints for three
		int m = 0, n = 0; //ints for two
		int o = 0, p = 0, q = 0; //ints for four
		three[0] = i;
		three[1] = j;
		three[2] = k;
		two[0] = l;
		two[1] = m;
		four[0] = n;
		four[1] = o;
		four[2] = p;
		four[3] = q;
		//Number generating algorithm
		while (i < 11){
			four[0] = i;
			if (i == 9){
				i = 0;
				four[1] = j++;
			}
			if (j == 5){
				break;
			}
			i++;
			System.out.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
			writer.println(three[2]+three[1]+three[0]+"-"+two[1]+two[0]+"-"+four[3]+four[2]+four[1]+four[0]);
		}
		writer.close();
		
	}

}
