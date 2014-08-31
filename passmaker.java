import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class passmaker{

	static int [] passints;
	static ArrayList<Integer> invalid = new ArrayList<Integer>();
	static int reject[] = {34,35,37,38,39,40,41,42,43,44,47,58,59,60,61,62,64,91,92,93,94,95,96,123};

	public static void main(String[] args){
		passmaker pass = new passmaker();
		Scanner in = new Scanner(System.in);
		int length = 0;
		System.out.println("How many total characters would you like in your password?");
		length = in.nextInt();
		passints = new int[length];
		pass.genKey();
		for(int i=0; i<reject.length; i++){
			invalid.add(reject[i]);
		}
		System.out.println(pass.genPass());
	}

	private int genNumber(){
		Random rand = new Random();
		return rand.nextInt(91)+33;
	}

	private void genKey(){
		for(int i=0; i<passints.length; i++){
			passints[i] = genNumber();
		}
	}

	private String genPass(){
		String characters="";
		for(int i=0; i<passints.length; i++){
			if(invalid.contains(passints[i])){
				if(passints[i]==34 || passints[i]==35){
					passints[i]=33;
				}
				else if(passints[i]>=36 && passints[i]<=44){
					passints[i]=45;
				}
				else if(passints[i]==47){
					passints[i]=48;
				}
				else if(passints[i]==58 || passints[i]==59){
					passints[i]=57;
				}
				else if(passints[i]>=60 && passints[i]<=62){
					passints[i]=63;
				}
				else if(passints[i]>=91 && passints[i]<=93){
					passints[i]=90;
				}
				else if(passints[i]>=94 && passints[i]<=96){
					passints[i]=97;
				}
				else if(passints[i]==123){
					passints[i]=122;
				}
			}
			characters+=String.valueOf(((char)passints[i]));
		}

		return characters;
	}

}