import java.util.Random;
import java.util.TimerTask;

public class Task extends TimerTask{
	
	@Override
	public void run(){
		String[] All = new String[94];
		//Lower case Alphabet
		All[0] = "a";
		All[1] = "b";
		All[2] = "c";
		All[3] = "d";
		All[4] = "e";
		All[5] = "f";
		All[6] = "g";
		All[7] = "h";
		All[8] = "i";
		All[9] = "j";
		All[10] = "k";
		All[11] = "l";
		All[12] = "m";
		All[13]	= "n";
		All[14] = "o";
		All[15] = "p";
		All[16] = "q";
		All[17] = "r";
		All[18] = "s";
		All[19] = "t";
		All[20] = "u";
		All[21] = "v";
		All[22] = "w";
		All[23] = "x";
		All[24] = "y";
		All[25] = "z";
		//Upper case Alphabet
		All[26] = "A";
		All[27] = "B";
		All[28] = "C";
		All[29] = "D";
		All[30] = "E";
		All[31] = "F";
		All[32] = "G";
		All[33] = "H";
		All[34] = "I";
		All[35] = "J";
		All[36] = "K";
		All[37] = "L";
		All[38] = "M";
		All[39] = "N";
		All[40] = "O";
		All[41] = "P";
		All[42] = "Q";
		All[43] = "R";
		All[44] = "S";
		All[45] = "T";
		All[46] = "U";
		All[47] = "V";
		All[48] = "W";
		All[49] = "X";
		All[50] = "Y";
		All[51] = "Z";
		//Numbers
		All[52] = "1";
		All[53] = "2";
		All[54] = "3";
		All[55] = "4";
		All[56] = "5";
		All[57] = "6";
		All[58] = "7";
		All[59] = "8";
		All[60] = "9";
		All[61] = "0";
		//Symbols
		All[62] = "~";
		All[63] = "`";
		All[64] = "!";
		All[65] = "@";
		All[66] = "#";
		All[67] = "$";
		All[68] = "%";
		All[69] = "^";
		All[70] = "&";
		All[71] = "*";
		All[72] = "(";
		All[73] = ")";
		All[74] = "_";
		All[75] = "-";
		All[76] = "+";
		All[77] = "=";
		All[78] = "{";
		All[79] = "}";
		All[80] = "[";
		All[81] = "]";
		All[82] = "|";
		All[83] = "\\"; //backslash mark
		All[84] = ":";
		All[85] = ";";
		All[86] = "\""; //quotation mark
		All[87] = "'";
		All[88] = "<";
		All[89] = ">";
		All[90] = ",";
		All[91] = ".";
		All[92] = "?";
		All[93] = "/";
		
		
		Random rand = new Random();
		int h = rand.nextInt(12);
		int[] Num = new int[11];
		for (int f = 0; f < Num.length; f++){
			Num[f] = 8+f;
		}
		String[] Pa = new String[Num[h]];
		
		for (int i = 0; i < Pa.length; i++){
			Pa[i] = All[rand.nextInt(94)];
			System.out.print(Pa[i]);
		}
		System.out.println();
	}
}
