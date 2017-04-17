import java.io.*;

public class PrintBruteWordList {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("PrintBruteWordList.txt", "UTF-8");
		//There are 26 lower case letters, 26 upper case letters, 32 symbols on the keyboard, and 10 numbers
		
		//I know this is a crude and tedious way to store the necessary variables, but I did this so that I can test the code
		//I'll come back and put in proper code later
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
		//1 Character
		BruteList(All);
		int a = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0;
		//2 Characters
		while (a < All.length){
			for (int i = 0; i < All.length; i++){
				System.out.println(All[a]+All[i]);
				writer.println(All[a]+All[i]);
			}
			a++;
		}
		//3 Characters
		for (c = 0; c < All.length; c++){
			for (a = 0; a < All.length; a++){
				for (int i = 0; i < All.length; i++){
					System.out.println(All[c]+All[a]+All[i]);
					writer.println(All[c]+All[a]+All[i]);
				}
			}
		}
		//4 Characters
		for (d = 0; d < All.length; d++){
			for (c = 0; c < All.length; c++){
				for (a = 0; a < All.length; a++){
					for (int i = 0; i < All.length; i++){
						System.out.println(All[d]+All[c]+All[a]+All[i]);
						writer.print(All[d]+All[c]+All[a]+All[i]);
					}
				}
			}
		}
		//5 Characters
		for (e = 0; e < All.length; e++){
			for (d = 0; d < All.length; d++){
				for (c = 0; c < All.length; c++){
					for (a = 0; a < All.length; a++){
						for (int i = 0; i < All.length; i++){
							System.out.println(All[e]+All[d]+All[c]+All[a]+All[i]);
							writer.print(All[e]+All[d]+All[c]+All[a]+All[i]);
						}
					}
				}
			}
		}
		//6 Characters
		for (f = 0; f < All.length; f++){
			for (e = 0; e < All.length; e++){
				for (d = 0; d < All.length; d++){
					for (c = 0; c < All.length; c++){
						for (a = 0; a < All.length; a++){
							for (int i = 0; i < All.length; i++){
								System.out.println(All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
								writer.print(All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
							}
						}
					}
				}
			}
		}
		//7 Characters
		for (g = 0; g < All.length; g++){
			for (f = 0; f < All.length; f++){
				for (e = 0; e < All.length; e++){
					for (d = 0; d < All.length; d++){
						for (c = 0; c < All.length; c++){
							for (a = 0; a < All.length; a++){
								for (int i = 0; i < All.length; i++){
									System.out.println(All[g]+All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
									writer.print(All[g]+All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
								}
							}
						}
					}
				}
			}
		}
		//8 Characters
		for (h = 0; h < All.length; h++){
			for (g = 0; g < All.length; g++){
				for (f = 0; f < All.length; f++){
					for (e = 0; e < All.length; e++){
						for (d = 0; d < All.length; d++){
							for (c = 0; c < All.length; c++){
								for (a = 0; a < All.length; a++){
									for (int i = 0; i < All.length; i++){
										System.out.println(All[h]+All[g]+All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
										writer.print(All[h]+All[g]+All[f]+All[e]+All[d]+All[c]+All[a]+All[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		writer.close();
	}
	
	static void BruteList(String[] A) throws FileNotFoundException, UnsupportedEncodingException{
		int i;
		PrintWriter writer2 = new PrintWriter("PrintBruteWordList.txt", "UTF-8");
		
		//printing characters to new text file
		for (i = 0; i < A.length; i++){
			System.out.println(A[i]);
			writer2.println(A[i]);
		}
		writer2.close();
	}

}
